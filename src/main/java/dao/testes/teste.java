package dao.testes;

import modelo.Amigo;
import dao.AmigoDAO;
import dao.ExceptionDAO;

public class teste {
    public static void main(String[] args) throws ExceptionDAO{
    Amigo amigo = new Amigo();
    AmigoDAO amigoDAO= AmigoDAO.getInstance();
    amigo.setNome("João");
    amigo.setApelido("Juca");
    amigo.setTelefone("999999999");
    amigoDAO.cadastrar(amigo);
    }
}
