package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import modelo.Amigo;

public class AmigoDAO implements DAO<Amigo> {

    private static AmigoDAO instance;

    private AmigoDAO() {
    }

    public static AmigoDAO getInstance() {
        if (instance == null) {
            instance = new AmigoDAO();
        }
        return instance;
    }

    public Optional<Amigo> buscar(Integer id) throws ExceptionDAO {
        return Optional.empty();
    }

    public ArrayList<Amigo> buscarTudo() throws ExceptionDAO {
        String sql = "SELECT * FROM amigos ORDER BY nome ASC;";
        ArrayList<Amigo> amigos = new ArrayList<>();

        try (Connection connection = new DBConexao().getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql);
                ResultSet rs = pStatement.executeQuery()) {

            while (rs.next()) {
                Amigo amigo = new Amigo();
                amigo.setId(rs.getInt("id"));
                amigo.setNome(rs.getString("nome"));
                amigo.setApelido(rs.getString("apelido"));
                amigo.setTelefone(rs.getString("telefone"));
                amigos.add(amigo);
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar amigo: " + e);
        }

        return amigos;
    }

    public void cadastrar(Amigo amigo) throws ExceptionDAO {
        String sql = "INSERT INTO amigos (nome, apelido, telefone) VALUES (?, ?, ?)";

        try (Connection connection = new DBConexao().getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql)) {

            pStatement.setString(1, amigo.getNome());
            pStatement.setString(2, amigo.getApelido());
            pStatement.setString(3, amigo.getTelefone());
            pStatement.execute();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar amigo: " + e);
        }
    }

    public int alterar(Amigo amigo) throws ExceptionDAO {
        String sql = "UPDATE amigos SET nome = ?, apelido = ?, telefone = ? WHERE id = ?";

        try (Connection connection = new DBConexao().getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql)) {

            pStatement.setString(1, amigo.getNome());
            pStatement.setString(2, amigo.getApelido());
            pStatement.setString(3, amigo.getTelefone());
            pStatement.setInt(4, amigo.getId());
            return pStatement.executeUpdate();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao alterar amigo: " + e);
        }
    }

    public int excluir(Integer id) throws ExceptionDAO {
        String sql = "DELETE FROM amigos WHERE id = ?";

        try (Connection connection = new DBConexao().getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql)) {

            pStatement.setInt(1, id);
            return pStatement.executeUpdate();

        } catch (SQLException e) {
            if (e.getSQLState().equals("23503") && amigoPossuiEmprestimo(id)) {
                throw new ExceptionDAO("Não é possível deletar amigo pois ele " +
                        "possui registros de empréstimo.");

            }
            throw new ExceptionDAO("Erro ao deletar amigo: " + e);
        }
    }

    private boolean amigoPossuiEmprestimo(String sql, Integer id) throws ExceptionDAO {
        try (Connection connection = new DBConexao().getConnection();
                PreparedStatement pStatement = connection.prepareStatement(sql)) {

            pStatement.setInt(1, id);
            try (ResultSet rs = pStatement.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao verificar empréstimos: " + e);
        }
        return false;
    }

    private boolean amigoPossuiEmprestimo(Integer id) throws ExceptionDAO {
        String sql = "SELECT COUNT(*) FROM emprestimos WHERE id_amigo = ?";
        return amigoPossuiEmprestimo(sql, id);
    }

    public boolean amigoPossuiEmprestimoAtivo(Integer id) throws ExceptionDAO {
        String sql = "SELECT COUNT(*) FROM emprestimos WHERE id_amigo = ? AND data_devolucao IS NULL";
        return amigoPossuiEmprestimo(sql, id);
    }

    public Amigo buscarMaiorUtilizador() throws ExceptionDAO {
        String sql = "SELECT a.id, a.nome, a.apelido, a.telefone " +
                     "FROM amigos a " +
                     "JOIN emprestimos e ON e.id_amigo = a.id " +
                     "GROUP BY a.id, a.nome, a.apelido, a.telefone " +
                     "ORDER BY COUNT(e.id_amigo) DESC " +
                     "LIMIT 1;";
        Amigo amigo = new Amigo();
    
        try (Connection connection = new DBConexao().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(sql);
             ResultSet rs = pStatement.executeQuery()) {
    
            if (rs.next()) {
                amigo.setId(rs.getInt("id"));
                amigo.setNome(rs.getString("nome"));
                amigo.setApelido(rs.getString("apelido"));
                amigo.setTelefone(rs.getString("telefone"));
            }
    
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar amigo: " + e);
        }
    
        return amigo;
    }

    public Amigo buscarNome(String nome) throws ExceptionDAO {
        String sql = "SELECT * FROM amigos WHERE UPPER(nome) LIKE UPPER(?)";
        Amigo amigo = new Amigo();
    
        try (Connection connection = new DBConexao().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(sql)) {
    
            pStatement.setString(1, "%" + nome + "%"); // Adicione os curingas diretamente aqui
            ResultSet rs = pStatement.executeQuery();
    
            if (rs.next()) {
                amigo.setId(rs.getInt("id"));
                amigo.setNome(rs.getString("nome"));
                amigo.setApelido(rs.getString("apelido"));
                amigo.setTelefone(rs.getString("telefone"));
            }
    
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar amigo: " + e);
        }
    
        return amigo;
    }
    
    //TODO: implementar testes
}
