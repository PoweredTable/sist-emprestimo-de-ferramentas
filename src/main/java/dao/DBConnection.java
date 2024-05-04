/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author caeta
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    
    public Connection getConnection(){
        String url = System.getenv("URL");
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        

        Connection conn = null;
        
        try{
            Class.forName("org.postgresql.Driver");
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
    
    
//    public static Connection connect() throws SQLException {;
//        try {
//            // Get database credentials from DatabaseConfig class
//            String jdbcUrl = "jdbc:postgresql://isabelle.db.elephantsql.com:5432/kaignlpr";
//            String user = "kaignlpr";
//            String password = "V258psJd3-9wF-fZWPwfHyeNJvAbElRO";
//
//            // Open a connection
//            return DriverManager.getConnection(jdbcUrl, user, password);
//
//        } catch (SQLException  e) {
//            System.err.println(e.getMessage());
//            return null;
//        }
//    }
}
