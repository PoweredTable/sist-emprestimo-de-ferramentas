package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ArrayList;

import modelo.Emprestimo;

public class EmprestimoDAO implements Dao<Emprestimo> {

    // teste de insert
    public static void main(String[] args) {
        // testarBuscar();
        // testarBuscarTudo();
        // testarCadastrar();
        // testarAlterar();
        // testarExcluir();
    }

    public Optional<Emprestimo> buscar(Integer id) throws ExceptionDAO {
        return Optional.empty();
    }

    public ArrayList<Emprestimo> buscarTudo() throws ExceptionDAO {
        String sql = "SELECT * FROM emprestimos;";
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(sql);
             ResultSet rs = pStatement.executeQuery()) {
            
            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rs.getInt("id"));
                emprestimo.setIdFerramenta(rs.getInt("id_ferramenta"));
                emprestimo.setIdAmigo(rs.getInt("id_amigo"));
                emprestimo.setDataInicial(toLocalDate(rs.getDate("data_inicial")));
                emprestimo.setDataPrazo(toLocalDate(rs.getDate("data_prazo")));
                emprestimo.setDataDevolucao(toLocalDate(rs.getDate("data_devolucao")));
                emprestimos.add(emprestimo);
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar emprestimo: " + e);
        }
        
        return emprestimos;
    }

    public void cadastrar(Emprestimo emprestimo) throws ExceptionDAO {
        String sql = "INSERT INTO emprestimos (id_ferramenta, id_amigo, data_inicial, data_prazo) VALUES (?, ?, ?, ?);";
        
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(sql)) {
            
            pStatement.setInt(1, emprestimo.getIdFerramenta());
            pStatement.setInt(2, emprestimo.getIdAmigo());
            pStatement.setDate(3, toSqlDate(emprestimo.getDataInicial()));
            pStatement.setDate(4, toSqlDate(emprestimo.getDataPrazo()));
            pStatement.execute();
            
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar emprestimo: " + e);
        }
    }

    public void alterar(Emprestimo emprestimo) throws ExceptionDAO {
        String sql = "UPDATE emprestimos SET data_devolucao=? WHERE id = ?;";
    
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(sql)) {
    
            pStatement.setDate(1, toSqlDate(emprestimo.getDataDevolucao()));
            pStatement.setInt(2, emprestimo.getId());
            pStatement.execute();
    
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao alterar emprestimo: " + e);
        }
    }

    public void excluir(Integer emprestimo) throws ExceptionDAO {
        String sql = "DELETE FROM emprestimos WHERE id = ?";
        
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(sql)) {
            
            pStatement.setInt(1, emprestimo);
            pStatement.execute();
            
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
            emprestimo.setDataInicial(LocalDate.now());
            emprestimo.setDataPrazo(LocalDate.now().plusDays(30));
    
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
            emprestimo.setId(1); // ID do emprestimo que deseja alterar
            emprestimo.setDataDevolucao(LocalDate.now()); // Nova data de devolucao
    
            emprestimoDAO.alterar(emprestimo);
    
            System.out.println("Emprestimo alterado com sucesso!");
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
}
