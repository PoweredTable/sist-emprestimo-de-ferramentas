package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConexao {
    private final String URL = "jdbc:mysql://localhost:3306/sistema_de_emprestimo_de_ferramenta";
    private final String USUARIO = "root";
    private final String SENHA = "Senha1234.";

    public Connection getConexao() {

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
