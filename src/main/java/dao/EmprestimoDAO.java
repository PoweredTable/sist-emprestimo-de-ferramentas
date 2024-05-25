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

    // testes
    public static void main(String[] args) {
        // testarBuscar();
        // testarBuscarTudo();
        // testarBuscarVencidos();
        // testarBuscarEmDia();
        // testarCadastrar();
        testarAlterar();
        // testarExcluir();
    }

    public Optional<Emprestimo> buscar(Integer id) throws ExceptionDAO {
        String sql = "SELECT e.id, e.id_ferramenta, e.id_amigo, e.data_inicial, e.data_prazo, e.data_devolucao, f.nome AS nome_ferramenta, f.marca, f.custo, a.nome AS nome_amigo, a.apelido, a.telefone FROM emprestimos " +
                 "JOIN ferramentas f ON emprestimos.id_ferramenta = ferramentas.id " +
                 "JOIN amigos a ON emprestimos.id_amigo = amigos.id " +
                 "WHERE emprestimos.id =?;";
    
        try (Connection conn = new DBConexao().getConexao();
             PreparedStatement pStatement = conn.prepareStatement(sql);
             ResultSet rs = pStatement.executeQuery()) {
    
            pStatement.setInt(1, id);
    
            if (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                
                emprestimo.setId(rs.getInt("id"));
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
                

                emprestimo.setId(rs.getInt("id"));
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
        String sql = "SELECT e.id, e.id_ferramenta, e.id_amigo, e.data_inicial, e.data_prazo, e.data_devolucao, f.nome AS nome_ferramenta, f.marca, f.custo, a.nome AS nome_amigo, a.apelido, a.telefone " +
                "FROM emprestimos " +
                "JOIN ferramentas ON emprestimos.id_ferramenta = ferramentas.id " +
                "JOIN amigos ON emprestimos.id_amigo = amigos.id " +
                "ORDER BY data_prazo ASC;";
        return buscarEmprestimos(sql);
    }

    public ArrayList<Emprestimo> buscarAtivos() throws ExceptionDAO {
        String sql = "SELECT e.id, e.id_ferramenta, e.id_amigo, e.data_inicial, e.data_prazo, e.data_devolucao, f.nome AS nome_ferramenta, f.marca, f.custo, a.nome AS nome_amigo, a.apelido, a.telefone  " +
                "FROM emprestimos " +
                "JOIN ferramentas ON emprestimos.id_ferramenta = ferramentas.id " +
                "JOIN amigos ON emprestimos.id_amigo = amigos.id " +
                "WHERE data_devolucao IS NULL;";
        return buscarEmprestimos(sql);
    }

    public ArrayList<Emprestimo> buscarEmDia() throws ExceptionDAO {
        String sql = "SELECT e.id, e.id_ferramenta, e.id_amigo, e.data_inicial, e.data_prazo, e.data_devolucao, f.nome AS nome_ferramenta, f.marca, f.custo, a.nome AS nome_amigo, a.apelido, a.telefone  " +
                "FROM emprestimos " +
                "JOIN ferramentas ON emprestimos.id_ferramenta = ferramentas.id " +
                "JOIN amigos ON emprestimos.id_amigo = amigos.id " +
                "WHERE data_prazo >= CURRENT_DATE AND data_devolucao IS NULL " +
                "ORDER BY data_prazo ASC;";
        return buscarEmprestimos(sql);
    }

    public ArrayList<Emprestimo> buscarAtrasados() throws ExceptionDAO {
        String sql = "SELECT e.id, e.id_ferramenta, e.id_amigo, e.data_inicial, e.data_prazo, e.data_devolucao, f.nome AS nome_ferramenta, f.marca, f.custo, a.nome AS nome_amigo, a.apelido, a.telefone  " +
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

    public static void testarBuscar() {
        try {
            EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
            Optional<Emprestimo> emprestimo = emprestimoDAO.buscar(1);
            if (emprestimo.isPresent()) {
                System.out.println("Emprestimo encontrado: " + emprestimo.get());
            } else {
                System.out.println("Nenhum emprestimo encontrado com o ID especificado.");
            }
        } catch (ExceptionDAO e) {
            System.out.println("Erro ao buscar emprestimo: " + e.getMessage());
        }
    }

    public static void testarBuscarTudo() {
        try {
            EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
            ArrayList<Emprestimo> emprestimos = emprestimoDAO.buscarTudo();
            if (!emprestimos.isEmpty()) {
                System.out.println("Emprestimos encontrados:");
                for (Emprestimo emprestimo : emprestimos) {
                    System.out.println(emprestimo);
                }
            } else {
                System.out.println("Nenhum emprestimo encontrado.");
            }
        } catch (ExceptionDAO e) {
            System.out.println("Erro ao buscar emprestimos: " + e.getMessage());
        }
    }

    public static void testarCadastrar() {
        try {
            EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setIdFerramenta(1);
            emprestimo.setIdAmigo(1);
            emprestimo.setDataInicial(LocalDate.of(1999, 10, 10));
            emprestimo.setDataPrazo(LocalDate.of(1999, 11, 11));

            emprestimoDAO.cadastrar(emprestimo);

            System.out.println("Emprestimo cadastrado com sucesso!");
        } catch (ExceptionDAO e) {
            System.out.println("Erro ao cadastrar emprestimo: " + e.getMessage());
        }
    }

    public static void testarAlterar() {
        try {
            EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setId(999); // ID do emprestimo que deseja alterar
            emprestimo.setDataDevolucao(LocalDate.now()); // Nova data de devolucao

            int x = emprestimoDAO.alterar(emprestimo);

            System.out.println(x);
        } catch (ExceptionDAO e) {
            System.out.println("Erro ao alterar emprestimo: " + e.getMessage());
        }
    }

    public static void testarExcluir() {
        try {
            EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
            emprestimoDAO.excluir(1); // ID do emprestimo que deseja excluir

            System.out.println("Emprestimo excluido com sucesso!");
        } catch (ExceptionDAO e) {
            System.out.println("Erro ao excluir emprestimo: " + e.getMessage());
        }
    }

    public static void testarBuscarVencidos() {
        try {
            EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
            ArrayList<Emprestimo> emprestimosVencidos = emprestimoDAO.buscarAtrasados();
            if (!emprestimosVencidos.isEmpty()) {
                System.out.println("Emprestimos vencidos encontrados:");
                for (Emprestimo emprestimo : emprestimosVencidos) {
                    System.out.println(emprestimo);
                }
            } else {
                System.out.println("Nenhum emprestimo vencido encontrado.");
            }
        } catch (ExceptionDAO e) {
            System.out.println("Erro ao buscar emprestimos vencidos: " + e.getMessage());
        }
    }

    public static void testarBuscarEmDia() {
        try {
            EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
            ArrayList<Emprestimo> emprestimosEmDia = emprestimoDAO.buscarEmDia();
            if (!emprestimosEmDia.isEmpty()) {
                System.out.println("Emprestimos em dia encontrados:");
                for (Emprestimo emprestimo : emprestimosEmDia) {
                    System.out.println(emprestimo);
                }
            } else {
                System.out.println("Nenhum emprestimo em dia encontrado.");
            }
        } catch (ExceptionDAO e) {
            System.out.println("Erro ao buscar emprestimos em dia: " + e.getMessage());
        }
    }

    public int quantidadeEmprestimos() throws ExceptionDAO {
        String sql = "SELECT COUNT(id) FROM emprestimos;";
        int quantidade = 0;

        try (Connection conn = new DBConexao().getConexao();
                PreparedStatement pStatement = conn.prepareStatement(sql);
                ResultSet rs = pStatement.executeQuery()) {

            if (rs.next()) {
                quantidade = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar quantidade de emprestimos: " + e);
        }

        return quantidade;
    }
}
