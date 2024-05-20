package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConexao {

    private static final String URL = System.getenv("URL");
    private static final String USER = System.getenv("USER");
    private static final String PASSWORD = System.getenv("PASSWORD");

    public DBConexao() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConexao() throws SQLException {
        if (URL == null || USER == null || PASSWORD == null) {
            throw new SQLException("Configurações de conexão com o banco de dados indefinidas!");
        }
        Connection conn;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return conn;
    }
}
