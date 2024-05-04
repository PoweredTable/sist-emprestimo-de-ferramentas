package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ArrayList;

import modelo.AmigoModelo;

public class AmigoDAO implements Dao<AmigoModelo> {

    public static void main(String[] args) {
        try {
            AmigoDAO amigoDAO = new AmigoDAO();
            
            // Dados de exemplo para cadastrar um amigo
            String nome = "Eduardo";
            String apelido = "Dudu";
            String telefone = "987654321";

            AmigoModelo amigo = new AmigoModelo(nome, apelido, telefone);
            amigoDAO.create(amigo);
            
            System.out.println("Amigo cadastrado com sucesso!");
        } catch (ExceptionDAO e) {
            System.out.println("Erro ao cadastrar amigo: " + e.getMessage());
        }
    }

    public Optional<AmigoModelo> get(Integer id) throws ExceptionDAO {
        return Optional.empty();
    }

    public ArrayList<AmigoModelo> getAll() throws ExceptionDAO {
        return new ArrayList<>();
    }

    public void create(AmigoModelo amigo) throws ExceptionDAO {
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

    public void update(AmigoModelo amigo) throws ExceptionDAO {

    }

    public void delete(Integer amigo) throws ExceptionDAO {

    }
}
