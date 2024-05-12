package modelo;

import java.util.ArrayList;
import java.util.Optional;

import dao.AmigoDAO;
import dao.ExceptionDAO;

public class Amigo {
    private Integer id;
    private String nome;
    private String apelido;
    private String telefone;

    private static final AmigoDAO DAO = AmigoDAO.getInstance();

    public Amigo(){
    }

    public Amigo(String nome, String apelido, String telefone) {
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
    }

    public Amigo(Integer id, String nome, String apelido, String telefone) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public static Optional<Amigo> buscar(Integer id) throws ExceptionDAO {
        return DAO.buscar(id);
    }

    public static ArrayList<Amigo> buscarTudo() throws ExceptionDAO {
        return DAO.buscarTudo();
    }

    public static void cadastrar(Amigo amigo) throws ExceptionDAO {
        DAO.cadastrar(amigo);
    }

    public static void alterar(Amigo amigo) throws ExceptionDAO {
        DAO.alterar(amigo);
    }

    public static void excluir(Integer id) throws ExceptionDAO {
        DAO.excluir(id);
    }

    public String toString() {
        return "Amigo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
