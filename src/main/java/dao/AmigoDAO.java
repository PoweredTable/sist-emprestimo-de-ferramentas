package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Amigo;


public class AmigoDAO {
    
    public static void main(String[] args){
        try {
            AmigoDAO amigoDAO = new AmigoDAO();
            // Dados de exemplo para cadastrar um amigo
            String nome = "Eduardo";
            String apelido = "Dudu";
            String telefone = "987654321";

            amigoDAO.cadastrarAmigo(nome, apelido, telefone);
            System.out.println("Amigo cadastrado com sucesso!");
        } catch (ExceptionDAO e) {
            System.out.println("Erro ao cadastrar amigo: " + e.getMessage());
        }
    }
    public void cadastrarAmigo(String nome,String apelido,String telefone) throws ExceptionDAO{
        String sql = "INSERT INTO amigos (nome,apelido,telefone) values (?,?,?)";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try{
            connection = new DBConnection().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, nome);
            pStatement.setString(2, apelido);
            pStatement.setString(3, telefone);
            pStatement.execute();
        }catch(SQLException e){
            throw new ExceptionDAO("Erro ao cadastrar amigo: "+ e);
        }finally{
            try{
                if(pStatement != null){
                    pStatement.close();
                }
            }catch(SQLException e ){
                throw new ExceptionDAO("Erro ao fechar o Statement: "+e);
            } try{
                if (connection != null){
                    connection.close();
                }
            } catch(SQLException e){
                throw new ExceptionDAO("Erro ao fechar a conexão: "+e);
            }
        }
    }
}
