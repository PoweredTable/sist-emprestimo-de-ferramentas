package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import modelo.Ferramenta;

public class FerramentaDAO implements Dao<Ferramenta> {
    
    //teste de select
    // public static void main(String[] args) {
    //     try {
    //         FerramentaDAO ferramentaDAO = new FerramentaDAO();

    //         ArrayList<FerramentaModelo> ferramentas = ferramentaDAO.getAll();

    //         System.out.println(ferramentas);
    //     } catch (ExceptionDAO e) {
    //         System.out.println("Erro ao consultar ferramenta: " + e.getMessage());
    //     }
    // }

    //teste insert
    // public static void main(String[] args) {
    //     try {
    //     FerramentaDAO ferramentaDao = new FerramentaDAO();
    
    //     // Dados de exemplo para cadastrar um amigo
    //     String nome = "Pregos";
    //     String marca = "Pregs";
    //     double preco = 5.25;
    
    //     FerramentaModelo ferramenta = new FerramentaModelo(nome, marca, preco);
    //     ferramentaDao.create(ferramenta);
    
    //     System.out.println("Ferramenta cadastrada com sucesso!");
    //     } catch (ExceptionDAO e) {
    //     System.out.println("Erro ao cadastrar ferramenta: " + e.getMessage());
    //     }
    //     }

    //teste update
    // public static void main(String[] args) {
    //     try {
    //     FerramentaDAO ferramentaDAO = new FerramentaDAO();
    
    //     // Dados de exemplo para cadastrar um amigo
    //     String nome = "Marreta";
    //     String marca = "Hammer";
    //     double preco = 15.99;
    //     int id = 1;
    //     // como passar esse id pra funcao / criei um novo contrutor em AmigoModelo
    //     FerramentaModelo ferramenta = new FerramentaModelo(id, nome, marca, preco);
    //     ferramentaDAO.update(ferramenta);
    
    //     System.out.println("Ferramenta alterada com sucesso!");
    //     } catch (ExceptionDAO e) {
    //     System.out.println("Erro ao alterar ferramenta: " + e.getMessage());
    //     }
    //     }

    //teste delete
    // public static void main(String[] args) {
    //     try {
    //     FerramentaDAO ferramentaDAO = new FerramentaDAO();
    
    //     ferramentaDAO.delete(4);
    
    //     System.out.println("Ferramenta deletada com sucesso!");
    //     } catch (ExceptionDAO e) {
    //     System.out.println("Erro ao deletar ferramenta: " + e.getMessage());
    //     }
    //     }

    public Optional<Ferramenta> buscar(Integer id) throws ExceptionDAO {
        return Optional.empty();
    }

    public ArrayList<Ferramenta> buscarTudo() throws ExceptionDAO {
        String sql = "SELECT * FROM ferramentas ORDER BY nome ASC;";
        PreparedStatement pStatement = null;
        Connection connection = null;
        ArrayList<Ferramenta> ferramentas = null;

        try {
            connection = new DBConnection().getConnection();
            pStatement = connection.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery();

            if (rs != null) {
                ferramentas = new ArrayList<Ferramenta>();
                while (rs.next()) {
                    Ferramenta ferramenta = new Ferramenta();
                    ferramenta.setId(rs.getInt("id"));
                    ferramenta.setNome(rs.getString("nome"));
                    ferramenta.setMarca(rs.getString("marca"));
                    //custo no bd e preco no codigo
                    ferramenta.setPreco(rs.getDouble("custo"));
                    ferramentas.add(ferramenta);
                }
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar ferramenta: " + e);
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
        return ferramentas;
    }

    public void cadastrar(Ferramenta ferramenta) throws ExceptionDAO {
        String sql = "INSERT INTO ferramentas (nome,marca,custo) values (?,?,?)";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new DBConnection().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, ferramenta.getNome());
            pStatement.setString(2, ferramenta.getMarca());
            pStatement.setDouble(3, ferramenta.getPreco());
            pStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar ferramenta: " + e);
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

    public void alterar(Ferramenta ferramenta) throws ExceptionDAO {
        String sql = "UPDATE ferramentas SET nome = ?, marca = ?, custo = ? WHERE id = ?;";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new DBConnection().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, ferramenta.getNome());
            pStatement.setString(2, ferramenta.getMarca());
            pStatement.setDouble(3, ferramenta.getPreco());
            pStatement.setInt(4, ferramenta.getId());
            pStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao alterar ferramenta: " + e);
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

    public void excluir(Integer ferramenta) throws ExceptionDAO {
        String sql = "DELETE FROM ferramentas WHERE id = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new DBConnection().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, ferramenta);
            pStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao deletar ferramenta: " + e);
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
}
