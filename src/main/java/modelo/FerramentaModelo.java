package modelo;

import java.util.ArrayList;
import java.util.Optional;

import dao.ExceptionDAO;
import dao.FerramentaDAO;

public class FerramentaModelo {
    private Integer id;
    private String nome;
    private String marca;
    private Double preco;

    private static final FerramentaDAO DAO = new FerramentaDAO();

    //contructor vazio 
    public FerramentaModelo() {
        this("","",0.0);
    }

    public FerramentaModelo(String nome, String marca, Double preco) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }

    public FerramentaModelo(int id, String nome, String marca, Double preco) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public static Optional<FerramentaModelo> buscar(Integer id) throws ExceptionDAO {
        return DAO.get(id);
    }

    public static ArrayList<FerramentaModelo> buscarTudo() throws ExceptionDAO {
        return DAO.getAll();
    }

    public static void cadastrar(FerramentaModelo ferramenta) throws ExceptionDAO {
        DAO.create(ferramenta);
    }

    public static void alterar(FerramentaModelo amigo) throws ExceptionDAO {
        DAO.update(amigo);
    }

    public static void excluir(Integer id) throws ExceptionDAO {
        DAO.delete(id);
    }

    //faz com que o print saia legivel
    public String toString() {
        return "FerramentaModelo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", preco='" + preco + '\'' +
                '}';
    }
}
