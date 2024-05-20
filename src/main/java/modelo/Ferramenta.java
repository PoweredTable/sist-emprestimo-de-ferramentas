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

    /**
     * Construtor padrão que inicializa todos os atributos com valores nulos.
     */
    public Ferramenta() {
        this.id = null;
        this.nome = null;
        this.marca = null;
        this.preco = null;
    }

    /**
     * Construtor que inicializa a ferramenta com nome, marca e preço.
     *
     * @param nome Nome da ferramenta.
     * @param marca Marca da ferramenta.
     * @param preco Preço da ferramenta.
     */
    public Ferramenta(String nome, String marca, Double preco) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }

    /**
     * Construtor que inicializa a ferramenta com id, nome, marca e preço.
     *
     * @param id ID da ferramenta.
     * @param nome Nome da ferramenta.
     * @param marca Marca da ferramenta.
     * @param preco Preço da ferramenta.
     */
    public Ferramenta(int id, String nome, String marca, Double preco) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }

    /**
     * Obtém o ID da ferramenta.
     *
     * @return ID da ferramenta.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o ID da ferramenta.
     *
     * @param id ID da ferramenta.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o nome da ferramenta.
     *
     * @return Nome da ferramenta.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da ferramenta.
     *
     * @param nome Nome da ferramenta.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a marca da ferramenta.
     *
     * @return Marca da ferramenta.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Define a marca da ferramenta.
     *
     * @param marca Marca da ferramenta.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtém o preço da ferramenta.
     *
     * @return Preço da ferramenta.
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * Define o preço da ferramenta.
     *
     * @param preco Preço da ferramenta.
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * Busca uma ferramenta pelo ID.
     *
     * @param id ID da ferramenta.
     * @return Optional contendo a ferramenta encontrada ou vazio se não encontrada.
     * @throws ExceptionDAO Exceção lançada pela camada DAO.
     */
    public static Optional<Ferramenta> buscar(Integer id) throws ExceptionDAO {
        return DAO.buscar(id);
    }

    /**
     * Busca todas as ferramentas.
     *
     * @return Lista de todas as ferramentas.
     * @throws ExceptionDAO Exceção lançada pela camada DAO.
     */
    public static ArrayList<Ferramenta> buscarTudo() throws ExceptionDAO {
        return DAO.buscarTudo();
    }

    /**
     * Cadastra uma nova ferramenta.
     *
     * @param ferramenta Ferramenta a ser cadastrada.
     * @throws ExceptionDAO Exceção lançada pela camada DAO.
     */
    public static void cadastrar(Ferramenta ferramenta) throws ExceptionDAO {
        DAO.cadastrar(ferramenta);
    }

    /**
     * Altera uma ferramenta existente.
     *
     * @param ferramenta Ferramenta a ser alterada.
     * @return Número de linhas afetadas.
     * @throws ExceptionDAO Exceção lançada pela camada DAO.
     */
    public static int alterar(Ferramenta ferramenta) throws ExceptionDAO {
        return DAO.alterar(ferramenta);
    }

    /**
     * Exclui uma ferramenta pelo ID.
     *
     * @param id ID da ferramenta a ser excluída.
     * @return Número de linhas afetadas.
     * @throws ExceptionDAO Exceção lançada pela camada DAO.
     */
    public static int excluir(Integer id) throws ExceptionDAO {
        return DAO.excluir(id);
    }

    /**
     * Verifica se uma ferramenta está emprestada.
     *
     * @param id ID da ferramenta.
     * @return true se a ferramenta está emprestada, false caso contrário.
     * @throws ExceptionDAO Exceção lançada pela camada DAO.
     */
    public static boolean ferramentaEmprestada(Integer id) throws ExceptionDAO {
        return DAO.ferramentaEmprestada(id);
    }

    /**
     * Busca todas as ferramentas disponíveis.
     *
     * @return Lista de ferramentas disponíveis.
     * @throws ExceptionDAO Exceção lançada pela camada DAO.
     */
    public static ArrayList<Ferramenta> buscarFerramentasDisponiveis() throws ExceptionDAO {
        return DAO.buscarFerramentasDisponiveis();
    }

    /**
     * Busca ferramentas pelo nome.
     *
     * @param nome Nome da ferramenta.
     * @return Lista de ferramentas que correspondem ao nome.
     * @throws ExceptionDAO Exceção lançada pela camada DAO.
     */
    public static ArrayList<Ferramenta> buscarNome(String nome) throws ExceptionDAO {
        return DAO.buscarNome(nome);
    }

<<<<<<< HEAD
    @Override
=======
    public static int quantidadeFerramentas() throws ExceptionDAO {
        return DAO.quantidadeFerramentas();
    }

>>>>>>> dev
    public String toString() {
        return "Ferramenta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", preco='" + preco + '\'' +
                '}';
    }
}