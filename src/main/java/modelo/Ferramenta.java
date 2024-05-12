package modelo;

import java.util.ArrayList;
import java.util.Optional;

import dao.ExceptionDAO;
import dao.FerramentaDAO;

public class Ferramenta {
    private Integer id;
    private String nome;
    private String marca;
    private Double preco;

    private static final FerramentaDAO DAO = FerramentaDAO.getInstance();

    public Ferramenta() {
    }

    public Ferramenta(String nome, String marca, Double preco) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }

    public Ferramenta(int id, String nome, String marca, Double preco) {
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

    public static Optional<Ferramenta> buscar(Integer id) throws ExceptionDAO {
        return DAO.buscar(id);
    }

    public static ArrayList<Ferramenta> buscarTudo() throws ExceptionDAO {
        return DAO.buscarTudo();
    }

    public static void cadastrar(Ferramenta ferramenta) throws ExceptionDAO {
        DAO.cadastrar(ferramenta);
    }

    public static void alterar(Ferramenta amigo) throws ExceptionDAO {
        DAO.alterar(amigo);
    }

    public static void excluir(Integer id) throws ExceptionDAO {
        DAO.excluir(id);
    }

    public String toString() {
        return "Ferramenta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", preco='" + preco + '\'' +
                '}';
    }
}
