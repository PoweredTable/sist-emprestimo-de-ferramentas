package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ArrayList;

import modelo.Amigo;

public class AmigoDAO implements Dao<Amigo> {

    // teste de insert
    // public static void main(String[] args) {
    // try {
    // AmigoDAO amigoDAO = new AmigoDAO();

    // // Dados de exemplo para cadastrar um amigo
    // String nome = "Eduardo";
    // String apelido = "Dudu";
    // String telefone = "987654321";

    // AmigoModelo amigo = new AmigoModelo(nome, apelido, telefone);
    // amigoDAO.create(amigo);

    // System.out.println("Amigo cadastrado com sucesso!");
    // } catch (ExceptionDAO e) {
    // System.out.println("Erro ao cadastrar amigo: " + e.getMessage());
    // }
    // }

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

    public Optional<Amigo> buscar(Integer id) throws ExceptionDAO {
        return Optional.empty();
    }

    public ArrayList<Amigo> buscarTudo() throws ExceptionDAO {
        String sql = "SELECT * FROM amigos ORDER BY nome ASC;";
        PreparedStatement pStatement = null;
        Connection connection = null;
        ArrayList<Amigo> amigos = null;

        try {
            connection = new DBConnection().getConnection();
            pStatement = connection.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery();

            if (rs != null) {
                amigos = new ArrayList<Amigo>();
                while (rs.next()) {
                    Amigo amigo = new Amigo();
                    amigo.setId(rs.getInt("id"));
                    amigo.setNome(rs.getString("nome"));
                    amigo.setApelido(rs.getString("telefone"));
                    amigo.setTelefone(rs.getString("telefone"));
                    amigos.add(amigo);
                }
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar amigo: " + e);
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
        return amigos;
    }

    public void cadastrar(Amigo amigo) throws ExceptionDAO {
        String sql = "INSERT INTO amigos (nome,apelido,telefone) values (?,?,?)";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new DBConnection().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, amigo.getNome());
            pStatement.setString(2, amigo.getApelido());
            pStatement.setString(3, amigo.getTelefone());
            pStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar amigo: " + e);
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

    public void alterar(Amigo amigo) throws ExceptionDAO {
        String sql = "UPDATE amigos SET nome = ?, apelido = ?, telefone = ? WHERE id = ?;";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new DBConnection().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, amigo.getNome());
            pStatement.setString(2, amigo.getApelido());
            pStatement.setString(3, amigo.getTelefone());
            pStatement.setInt(4, amigo.getId());
            pStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao alterar amigo: " + e);
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

    public void excluir(Integer amigo) throws ExceptionDAO {
        String sql = "DELETE FROM amigos WHERE id = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new DBConnection().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, amigo);
            pStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao deletar amigo: " + e);
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
