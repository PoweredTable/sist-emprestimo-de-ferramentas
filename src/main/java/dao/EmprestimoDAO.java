package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ArrayList;

import modelo.*;

public class EmprestimoDAO implements DAO<Emprestimo> {

    private static EmprestimoDAO instance;

    private EmprestimoDAO() {
    }

    public static EmprestimoDAO getInstance() {
        if (instance == null) {
            instance = new EmprestimoDAO();
        }
        return instance;
    }

    public Optional<Emprestimo> buscar(Integer id) throws ExceptionDAO {
        String sql = "SELECT *, ferramentas.nome AS nome_ferramenta FROM emprestimos, amigos.nome AS nome_amigo" +
                "JOIN ferramentas ON emprestimos.id_ferramenta = ferramentas.id " +
                "JOIN amigos ON emprestimos.id_amigo = amigos.id " +
                "WHERE emprestimos.id =?;";

        try (Connection conn = new DBConexao().getConexao();
                PreparedStatement pStatement = conn.prepareStatement(sql);
                ResultSet rs = pStatement.executeQuery()) {

            pStatement.setInt(1, id);

            if (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();

                emprestimo.setId(rs.getInt("id_emprestimo"));
                emprestimo.setIdFerramenta(rs.getInt("id_ferramenta"));
                emprestimo.setIdAmigo(rs.getInt("id_amigo"));
                emprestimo.setDataInicial(toLocalDate(rs.getDate("data_inicial")));
                emprestimo.setDataPrazo(toLocalDate(rs.getDate("data_prazo")));
                emprestimo.setDataDevolucao(toLocalDate(rs.getDate("data_devolucao")));

                Ferramenta ferramenta = new Ferramenta();
                ferramenta.setId(rs.getInt("id_ferramenta"));
                ferramenta.setNome(rs.getString("nome_ferramenta"));
                ferramenta.setMarca(rs.getString("marca"));
                ferramenta.setPreco(rs.getDouble("custo"));
                emprestimo.setFerramenta(ferramenta);

                Amigo amigo = new Amigo();
                amigo.setId(rs.getInt("id_amigo"));
                amigo.setNome(rs.getString("nome_amigo"));
                amigo.setApelido(rs.getString("apelido"));
                amigo.setTelefone(rs.getString("telefone"));
                emprestimo.setAmigo(amigo);

                return Optional.of(emprestimo);
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar emprestimo: " + e);
        }
    }

    private ArrayList<Emprestimo> buscarEmprestimos(String sql) throws ExceptionDAO {
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();

        try (Connection conn = new DBConexao().getConexao();
                PreparedStatement pStatement = conn.prepareStatement(sql);
                ResultSet rs = pStatement.executeQuery()) {

            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();

                emprestimo.setId(rs.getInt("id_emprestimo"));
                emprestimo.setIdFerramenta(rs.getInt("id_ferramenta"));
                emprestimo.setIdAmigo(rs.getInt("id_amigo"));
                emprestimo.setDataInicial(toLocalDate(rs.getDate("data_inicial")));
                emprestimo.setDataPrazo(toLocalDate(rs.getDate("data_prazo")));
                emprestimo.setDataDevolucao(toLocalDate(rs.getDate("data_devolucao")));

                Ferramenta ferramenta = new Ferramenta();
                ferramenta.setId(rs.getInt("id_ferramenta"));
                ferramenta.setNome(rs.getString("nome_ferramenta"));
                ferramenta.setMarca(rs.getString("marca"));
                ferramenta.setPreco(rs.getDouble("custo"));
                emprestimo.setFerramenta(ferramenta);

                Amigo amigo = new Amigo();
                amigo.setId(rs.getInt("id_amigo"));
                amigo.setNome(rs.getString("nome_amigo"));
                amigo.setApelido(rs.getString("apelido"));
                amigo.setTelefone(rs.getString("telefone"));
                emprestimo.setAmigo(amigo);

                emprestimos.add(emprestimo);

            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar emprestimo: " + e);
        }

        return emprestimos;
    }

    public ArrayList<Emprestimo> buscarTudo() throws ExceptionDAO {
        String sql = "SELECT *, ferramentas.nome AS nome_ferramenta FROM emprestimos, amigos.nome AS nome_amigo" +
                "JOIN ferramentas ON emprestimos.id_ferramenta = ferramentas.id " +
                "JOIN amigos ON emprestimos.id_amigo = amigos.id " +
                "ORDER BY data_prazo ASC;";
        return buscarEmprestimos(sql);
    }

    public ArrayList<Emprestimo> buscarAtivos() throws ExceptionDAO {
        String sql = "SELECT *, ferramentas.nome AS nome_ferramenta FROM emprestimos, amigos.nome AS nome_amigo " +
                "FROM emprestimos " +
                "JOIN ferramentas ON emprestimos.id_ferramenta = ferramentas.id " +
                "JOIN amigos ON emprestimos.id_amigo = amigos.id " +
                "WHERE data_devolucao IS NULL;";
        return buscarEmprestimos(sql);
    }

    public ArrayList<Emprestimo> buscarEmDia() throws ExceptionDAO {
        String sql = "SELECT *, ferramentas.nome AS nome_ferramenta FROM emprestimos, amigos.nome AS nome_amigo" +
                "FROM emprestimos " +
                "JOIN ferramentas ON emprestimos.id_ferramenta = ferramentas.id " +
                "JOIN amigos ON emprestimos.id_amigo = amigos.id " +
                "WHERE data_prazo >= CURRENT_DATE AND data_devolucao IS NULL " +
                "ORDER BY data_prazo ASC;";
        return buscarEmprestimos(sql);
    }

    public ArrayList<Emprestimo> buscarAtrasados() throws ExceptionDAO {
        String sql = "SELECT *, ferramentas.nome AS nome_ferramenta FROM emprestimos, amigos.nome AS nome_amigo " +
                "FROM emprestimos " +
                "JOIN ferramentas ON emprestimos.id_ferramenta = ferramentas.id " +
                "JOIN amigos ON emprestimos.id_amigo = amigos.id " +
                "WHERE data_prazo < CURRENT_DATE AND data_devolucao IS NULL " +
                "ORDER BY data_prazo ASC;";
        return buscarEmprestimos(sql);
    }

    public void cadastrar(Emprestimo emprestimo) throws ExceptionDAO {
        String sql = "INSERT INTO emprestimos (id_ferramenta, id_amigo, data_inicial, data_prazo) VALUES (?, ?, ?, ?);";

        try (Connection conn = new DBConexao().getConexao();
                PreparedStatement pStatement = conn.prepareStatement(sql)) {

            pStatement.setInt(1, emprestimo.getIdFerramenta());
            pStatement.setInt(2, emprestimo.getIdAmigo());
            pStatement.setDate(3, toSqlDate(emprestimo.getDataInicial()));
            pStatement.setDate(4, toSqlDate(emprestimo.getDataPrazo()));
            pStatement.execute();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar emprestimo: " + e);
        }
    }

    public int alterar(Emprestimo emprestimo) throws ExceptionDAO {
        String sql = "UPDATE emprestimos SET data_devolucao=? WHERE id = ?;";

        try (Connection conn = new DBConexao().getConexao();
                PreparedStatement pStatement = conn.prepareStatement(sql)) {

            pStatement.setDate(1, toSqlDate(emprestimo.getDataDevolucao()));
            pStatement.setInt(2, emprestimo.getId());
            return pStatement.executeUpdate();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao alterar emprestimo: " + e);
        }
    }

    public int excluir(Integer id) throws ExceptionDAO {
        String sql = "DELETE FROM emprestimos WHERE id = ?";

        try (Connection conn = new DBConexao().getConexao();
                PreparedStatement pStatement = conn.prepareStatement(sql)) {

            pStatement.setInt(1, id);
            return pStatement.executeUpdate();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao deletar emprestimo: " + e);
        }
    }

    private java.sql.Date toSqlDate(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }

    private LocalDate toLocalDate(java.sql.Date date) {
        return date != null ? date.toLocalDate() : null;
    }

}
