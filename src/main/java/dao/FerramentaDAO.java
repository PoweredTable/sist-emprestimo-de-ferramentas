package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import modelo.Ferramenta;

public class FerramentaDAO implements DAO<Ferramenta> {

    private static FerramentaDAO instance;

    private FerramentaDAO() {
    }

    public static FerramentaDAO getInstance() {
        if (instance == null) {
            instance = new FerramentaDAO();
        }
        return instance;
    }

    @Override
    public Optional<Ferramenta> buscar(Integer id) throws ExceptionDAO {
        return Optional.empty();
    }

    public ArrayList<Ferramenta> buscarTudo() throws ExceptionDAO {
        String sql = "SELECT id, nome, marca, custo FROM ferramentas ORDER BY nome ASC;";
        ArrayList<Ferramenta> ferramentas = new ArrayList<>();

        try (Connection conn = new DBConexao().getConexao();
                PreparedStatement pStatement = conn.prepareStatement(sql);
                ResultSet rs = pStatement.executeQuery()) {

            while (rs.next()) {
                Ferramenta ferramenta = new Ferramenta();
                ferramenta.setId(rs.getInt("id"));
                ferramenta.setNome(rs.getString("nome"));
                ferramenta.setMarca(rs.getString("marca"));
                ferramenta.setPreco(rs.getDouble("custo"));
                ferramentas.add(ferramenta);
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar ferramenta: " + e);
        }

        return ferramentas;
    }

    public void cadastrar(Ferramenta ferramenta) throws ExceptionDAO {
        String sql = "INSERT INTO ferramentas (nome, marca, custo) VALUES (?, ?, ?)";

        try (Connection conn = new DBConexao().getConexao();
                PreparedStatement pStatement = conn.prepareStatement(sql)) {

            pStatement.setString(1, ferramenta.getNome());
            pStatement.setString(2, ferramenta.getMarca());
            pStatement.setDouble(3, ferramenta.getPreco());
            pStatement.execute();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar ferramenta: " + e);
        }
    }

    public int alterar(Ferramenta ferramenta) throws ExceptionDAO {
        String sql = "UPDATE ferramentas SET nome = ?, marca = ?, custo = ? WHERE id = ?";

        try (Connection conn = new DBConexao().getConexao();
                PreparedStatement pStatement = conn.prepareStatement(sql)) {

            pStatement.setString(1, ferramenta.getNome());
            pStatement.setString(2, ferramenta.getMarca());
            pStatement.setDouble(3, ferramenta.getPreco());
            pStatement.setInt(4, ferramenta.getId());
            return pStatement.executeUpdate();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao alterar ferramenta: " + e);
        }
    }

    public int excluir(Integer id) throws ExceptionDAO {
        String sql = "DELETE FROM ferramentas WHERE id = ?";

        try (Connection conn = new DBConexao().getConexao();
                PreparedStatement pStatement = conn.prepareStatement(sql)) {

            pStatement.setInt(1, id);
            return pStatement.executeUpdate();

        } catch (SQLException e) {
            if (e.getSQLState().equals("23503") && ferramentaEmprestada(id)) {
                throw new ExceptionDAO("Não é possível deletar ferramenta pois ela " +
                        "possui registros de empréstimo.");
            }

            throw new ExceptionDAO("Erro ao deletar ferramenta: " + e);
        }
    }

    public boolean ferramentaEmprestada(Integer id) throws ExceptionDAO {
        String sql = "SELECT id_ferramenta FROM emprestimos " +
                "WHERE id_ferramenta = ? AND data_devolucao IS NULL;";
        boolean isEmprestada = false;

        try (Connection conn = new DBConexao().getConexao();
                PreparedStatement pStatement = conn.prepareStatement(sql)) {
            pStatement.setInt(1, id);
            try (ResultSet rs = pStatement.executeQuery()) {
                if (rs.next()) {
                    isEmprestada = true;
                }
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar ferramenta: " + e);
        }

        return isEmprestada;
    }

    public ArrayList<Ferramenta> buscarFerramentasDisponiveis() throws ExceptionDAO {
        String sql = "SELECT f.id, f.nome, f.marca, f.custo FROM emprestimos e " +
                     "RIGHT JOIN ferramentas f ON e.id_ferramenta = f.id " +
                     "WHERE data_devolucao IS NOT NULL OR id_ferramenta IS NULL;";
        ArrayList<Ferramenta> ferramentas = new ArrayList<>();
    
        try (Connection conn = new DBConexao().getConexao();
             PreparedStatement pStatement = conn.prepareStatement(sql);
             ResultSet rs = pStatement.executeQuery()) {
    
            while (rs.next()) {
                Ferramenta ferramenta = new Ferramenta();
                ferramenta.setId(rs.getInt("id"));
                ferramenta.setNome(rs.getString("nome"));
                ferramenta.setMarca(rs.getString("marca"));
                ferramenta.setPreco(rs.getDouble("custo"));
                ferramentas.add(ferramenta);
            }
    
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar ferramentas: " + e);
        }
    
        return ferramentas;
    }
    
    public ArrayList<Ferramenta> buscarNome(String nome) throws ExceptionDAO {
        String sql = "SELECT id, nome, marca, custo FROM ferramentas WHERE UPPER(nome) LIKE UPPER(?)";
        ArrayList<Ferramenta> ferramentas = new ArrayList<>();
    
        try (Connection conn = new DBConexao().getConexao();
             PreparedStatement pStatement = conn.prepareStatement(sql)) {
    
            pStatement.setString(1, "%" + nome + "%"); // Adicione os curingas diretamente aqui
            try (ResultSet rs = pStatement.executeQuery()) { // Use try-with-resources para garantir que o ResultSet seja fechado
                while (rs.next()) {
                    Ferramenta ferramenta = new Ferramenta();
                    ferramenta.setId(rs.getInt("id"));
                    ferramenta.setNome(rs.getString("nome"));
                    ferramenta.setMarca(rs.getString("marca"));
                    ferramenta.setPreco(rs.getDouble("custo"));
                    ferramentas.add(ferramenta);
                }
            }
    
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar ferramenta: " + e);
        }
    
        return ferramentas;
    }

    public int quantidadeFerramentas() throws ExceptionDAO {
        String sql = "SELECT COUNT(id) FROM ferramentas";
        int quantidade = 0;

        try (Connection conn = new DBConexao().getConexao();
                PreparedStatement pStatement = conn.prepareStatement(sql);
                ResultSet rs = pStatement.executeQuery()) {

            if (rs.next()) {
                quantidade = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar quantidade de ferramentas: " + e);
        }

        return quantidade;
    }


    
}
