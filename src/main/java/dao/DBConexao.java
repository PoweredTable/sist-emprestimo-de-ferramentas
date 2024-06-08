package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConexao {
    
    public Connection getConexao(){
        String url = "jdbc:mysql://localhost:3306/sistema_de_emprestimo_de_ferramenta";
        String user = "root";
        String password = "Senha1234.";
        
        Connection conn = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try {
            conn = DriverManager.getConnection(url,user,password);
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return conn;
    }
}
