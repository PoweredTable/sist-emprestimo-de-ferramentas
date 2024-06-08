package modelo;

import java.util.ArrayList;
import java.util.Optional;

import dao.ExceptionDAO;
import dao.FerramentaDAO;

/**
 * Classe que representa uma ferramenta no sistema.
 */
public class Ferramenta {
    private Integer id;
    private String nome;
    private String marca;
    private Double preco;

    private static final FerramentaDAO DAO = FerramentaDAO.getInstance();

    /**
     * Construtor padrão que inicializa todos os atributos com valores nulos.
     */
    public Ferramenta() {
        this("","",0.0);
    }

    /**
     * Construtor que inicializa a ferramenta com nome, marca e preço.
     */
    public Ferramenta(String nome, String marca, Double preco) {
        this(null, nome, marca, preco);
    }

    /**
     * Construtor que inicializa a ferramenta com id, nome, marca e preço.
     */
    public Ferramenta(Integer id, String nome, String marca, Double preco) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }

    /**
     * Obtém o ID da ferramenta.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o ID da ferramenta.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o nome da ferramenta.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da ferramenta.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a marca da ferramenta.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define a marca da ferramenta.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtém o preço da ferramenta.
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * Define o preço da ferramenta.
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * Busca uma ferramenta pelo ID.
     */
    public static Optional<Ferramenta> buscar(Integer id) throws ExceptionDAO {
        return DAO.buscar(id);
    }

    /**
     * Busca todas as ferramentas.
     */
    public static ArrayList<Ferramenta> buscarTudo() throws ExceptionDAO {
        return DAO.buscarTudo();
    }

    /**
     * Cadastra uma nova ferramenta.
     */
    public static void cadastrar(Ferramenta ferramenta) throws ExceptionDAO {
        DAO.cadastrar(ferramenta);
    }

    /**
     * Altera uma ferramenta existente.
     */
    public static int alterar(Ferramenta ferramenta) throws ExceptionDAO {
        return DAO.alterar(ferramenta);
    }

    /**
     * Exclui uma ferramenta pelo ID.
     */
    public static int excluir(Integer id) throws ExceptionDAO {
        return DAO.excluir(id);
    }

    /**
     * Verifica se uma ferramenta está emprestada.
     */
    public static boolean ferramentaEmprestada(Integer id) throws ExceptionDAO {
        return DAO.ferramentaEmprestada(id);
    }

    /**
     * Busca todas as ferramentas disponíveis.
     */
    public static ArrayList<Ferramenta> buscarFerramentasDisponiveis() throws ExceptionDAO {
        return DAO.buscarFerramentasDisponiveis();
    }

    /**
     * Busca ferramentas pelo nome.
     */
    public static ArrayList<Ferramenta> buscarNome(String nome) throws ExceptionDAO {
        return DAO.buscarNome(nome);
    }

    /**
     * Obtém a quantidade total de ferramentas.
     */
    public static int quantidadeFerramentas() throws ExceptionDAO {
        return DAO.quantidadeFerramentas();
    }

    /**
     * Retorna a representação em string da ferramenta.
     */
    public String toString() {
        return "Ferramenta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", preco='" + preco + '\'' +
                '}';
    }
}