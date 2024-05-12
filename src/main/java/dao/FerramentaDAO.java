package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import modelo.Ferramenta;

public class FerramentaDAO implements Dao<Ferramenta> {

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
        String sql = "SELECT * FROM ferramentas ORDER BY nome ASC;";
        ArrayList<Ferramenta> ferramentas = new ArrayList<>();

        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(sql);
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
        
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(sql)) {

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
        
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(sql)) {

            pStatement.setString(1, ferramenta.getNome());
            pStatement.setString(2, ferramenta.getMarca());
            pStatement.setDouble(3, ferramenta.getPreco());
            pStatement.setInt(4, ferramenta.getId());
            return pStatement.executeUpdate();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao alterar ferramenta: " + e);
        }
    }

    public int excluir(Integer ferramenta) throws ExceptionDAO {
        String sql = "DELETE FROM ferramentas WHERE id = ?";
        
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement pStatement = connection.prepareStatement(sql)) {

            pStatement.setInt(1, ferramenta);
            return pStatement.executeUpdate();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao deletar ferramenta: " + e);
        }
    }
}
