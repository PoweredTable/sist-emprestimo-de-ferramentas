package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;
import java.util.ArrayList;
import java.time.LocalDate;

import modelo.Emprestimo;

public class EmprestimoDAO implements Dao<Emprestimo> {

    // teste de insert
    public static void main(String[] args) {
        try {
            EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

            // Dados de exemplo para cadastrar um amigo
            // id_ferramenta, id_amigo, data_inicial, data_prazo, data_devolucao

            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setId_ferramenta(1);
            emprestimo.setId_amigo(1);
            emprestimo.setData_inicial(LocalDate.now());
            emprestimo.setData_prazo(LocalDate.now().plusDays(30));
            emprestimoDAO.create(emprestimo);


            System.out.println("Emprestimo cadastrado com sucesso!");
        } catch (ExceptionDAO e) {
            System.out.println("Erro ao cadastrar Emprestimo: " + e.getMessage());
        }
    }

    // pensar em um novo constructor
    // Integer id_ferramenta = 1;
    // Integer id_amigo = 1;

    // AmigoModelo amigo = new AmigoModelo(nome, apelido, telefone);
    // amigoDAO.create(amigo);

    // teste de delete
    // public static void main(String[] args) {
    // try {
    // AmigoDAO amigoDAO = new AmigoDAO();

    // amigoDAO.delete(7);

    // System.out.println("Amigo deletado com sucesso!");
    // } catch (ExceptionDAO e) {
    // System.out.println("Erro ao deletar amigo: " + e.getMessage());
    // }
    // }

    // teste update
    // public static void main(String[] args) {
    // try {
    // AmigoDAO amigoDAO = new AmigoDAO();

    // // Dados de exemplo para cadastrar um amigo
    // String nome = "Carlos Eduardo";
    // String apelido = "Cadu";
    // String telefone = "987654321";
    // int id = 1;
    // // como passar esse id pra funcao / criei um novo contrutor em AmigoModelo
    // AmigoModelo amigo = new AmigoModelo(id, nome, apelido, telefone);
    // amigoDAO.update(amigo);

    // System.out.println("Amigo alterado com sucesso!");
    // } catch (ExceptionDAO e) {
    // System.out.println("Erro ao alterar amigo: " + e.getMessage());
    // }
    // }

    // teste de select
    // public static void main(String[] args) {
    // try {
    // AmigoDAO amigoDAO = new AmigoDAO();

    // ArrayList<AmigoModelo> amigos = amigoDAO.getAll();

    // System.out.println(amigos);
    // } catch (ExceptionDAO e) {
    // System.out.println("Erro ao consultar amigo amigo: " + e.getMessage());
    // }
    // }

    public Optional<Emprestimo> get(Integer id) throws ExceptionDAO {
        return Optional.empty();
    }

    public ArrayList<Emprestimo> getAll() throws ExceptionDAO {
        String sql = "SELECT * FROM emprestimos;";
        PreparedStatement pStatement = null;
        Connection connection = null;
        ArrayList<Emprestimo> emprestimos = null;

        try {
            connection = new DBConnection().getConnection();
            pStatement = connection.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery();

            if (rs != null) {
                emprestimos = new ArrayList<Emprestimo>();
                while (rs.next()) {
                    Emprestimo emprestimo = new Emprestimo();
                    emprestimo.setId(rs.getInt("id"));
                    emprestimo.setId_ferramenta(rs.getInt("id_ferramenta"));
                    emprestimo.setId_amigo(rs.getInt("id_amigo"));
                    emprestimo.setData_inicial(toLocalDate(rs.getDate("data_inicial")));
                    emprestimo.setData_prazo(toLocalDate(rs.getDate("data_prazo")));
                    emprestimo.setData_devolucao(toLocalDate(rs.getDate("data_devolucao")));
                    emprestimos.add(emprestimo);

                }
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar emprestimo: " + e);
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
        return emprestimos;
    }

    public void create(Emprestimo emprestimo) throws ExceptionDAO {
        String sql = "INSERT INTO emprestimos (id_ferramenta, id_amigo, data_inicial, data_prazo) VALUES (?, ?, ?, ?);   ";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new DBConnection().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, emprestimo.getId_ferramenta());
            pStatement.setInt(2, emprestimo.getId_amigo());
            pStatement.setDate(3, toSqlDate(emprestimo.getData_inicial()));
            pStatement.setDate(4, toSqlDate(emprestimo.getData_prazo()));
            // pStatement.setDate(5, toSqlDate(emprestimo.getData_devolucao()));
            pStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar emprestimo: " + e);
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
    }

    public void update(Emprestimo emprestimo) throws ExceptionDAO {
        String sql = "UPDATE emprestimo SET data_devolucao=? WHERE id = ?;";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new DBConnection().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setDate(1, toSqlDate(emprestimo.getData_devolucao()));
            pStatement.setInt(2, emprestimo.getId());
            pStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao alterar emprestimo: " + e);
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
    }

    public void delete(Integer emprestimo) throws ExceptionDAO {
        String sql = "DELETE FROM emprestimos WHERE id = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new DBConnection().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, emprestimo);
            pStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao deletar emprestimo: " + e);
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
    }

    private java.sql.Date toSqlDate(LocalDate date) {
        // Convertendo para LocalDate
        
        // Convertendo para java.sql.Date
        return java.sql.Date.valueOf(date);
        
    }

    private LocalDate toLocalDate(java.sql.Date date){
        return date.toLocalDate();
    }
    // private java.sql.Date toSqlDate(LocalDate localDate) {
    //     return java.sql.Date.valueOf(localDate);
    // }
}
