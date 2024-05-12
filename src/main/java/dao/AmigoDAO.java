package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import modelo.Amigo;

public class AmigoDAO implements Dao<Amigo> {

    public static void main(String[] args) throws ExceptionDAO{
        AmigoDAO amigo = new AmigoDAO();

        amigo.excluir(1);

     }

    public Optional<Amigo> buscar(Integer id) throws ExceptionDAO {
        return Optional.empty();
    }

    public ArrayList<Amigo> buscarTudo() throws ExceptionDAO {
        String sql = "SELECT * FROM amigos ORDER BY nome ASC;";
        ArrayList<Amigo> amigos = new ArrayList<>();

        try (Connection connection = new DBConnection().getConnection();
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
        
        try (Connection connection = new DBConnection().getConnection();
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
        
        try (Connection connection = new DBConnection().getConnection();
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

    public int excluir(Integer amigo) throws ExceptionDAO {
        String sql = "DELETE FROM amigos WHERE id = ?";
        
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(sql)) {

            pStatement.setInt(1, amigo);
            return pStatement.executeUpdate();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao deletar amigo: " + e);
        }
    }
}
