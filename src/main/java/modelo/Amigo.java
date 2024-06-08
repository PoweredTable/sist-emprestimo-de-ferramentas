package modelo;

import java.util.ArrayList;
import java.util.Optional;

import dao.AmigoDAO;
import dao.ExceptionDAO;

/**
 * Classe Amigo representa um amigo com seus atributos e métodos de manipulação.
 */
public class Amigo {
    private Integer id;
    private String nome;
    private String apelido;
    private String telefone;

    private static final AmigoDAO DAO = AmigoDAO.getInstance();

    /**
     * Construtor padrão que inicializa os atributos com valores nulos.
     */
    public Amigo(){
        this("", "", "");
    }

    /**
     * Construtor que inicializa os atributos com os valores fornecidos.
     */
    public Amigo(String nome, String apelido, String telefone) {
        this(null, nome, apelido, telefone);
    }

    /**
     * Construtor que inicializa todos os atributos com os valores fornecidos.
     */
    public Amigo(Integer id, String nome, String apelido, String telefone) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
    }

    // Métodos getters e setters

    /**
     * Obtém o ID do amigo.
     * 
     * @return o ID do amigo
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o ID do amigo.
     */ 
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o nome do amigo.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do amigo.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o apelido do amigo.
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * Define o apelido do amigo.
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * Obtém o telefone do amigo.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do amigo.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Busca um amigo pelo ID.
     */
    public static Optional<Amigo> buscar(Integer id) throws ExceptionDAO {
        return DAO.buscar(id);
    }

    /**
     * Busca todos os amigos.
     */
    public static ArrayList<Amigo> buscarTudo() throws ExceptionDAO {
        return DAO.buscarTudo();
    }

    /**
     * Cadastra um novo amigo.
     */
    public static void cadastrar(Amigo amigo) throws ExceptionDAO {
        DAO.cadastrar(amigo);
    }

    /**
     * Altera os dados de um amigo.
     */
    public static int alterar(Amigo amigo) throws ExceptionDAO {
        return DAO.alterar(amigo);
    }

    /**
     * Exclui um amigo pelo ID.
     */
    public static int excluir(Integer id) throws ExceptionDAO {
        return DAO.excluir(id);
    }

    /**
     * Verifica se um amigo possui empréstimo ativo.
     */
    public static boolean amigoPossuiEmprestimoAtivo(Integer id) throws ExceptionDAO {
        return DAO.amigoPossuiEmprestimoAtivo(id);
    }

    /**
     * Busca o amigo com o maior número de utilizações.
     */
    public static Optional<Amigo> buscarMaiorUtilizador() throws ExceptionDAO {
        return DAO.buscarMaiorUtilizador();
    }

    /**
     * Busca amigos pelo nome.
     */
    public static ArrayList<Amigo> buscarNome(String nome) throws ExceptionDAO {
        return DAO.buscarNome(nome);
    }

    /**
     * Retorna a quantidade de amigos cadastrados.
     */
    public static int quantidadeAmigos() throws ExceptionDAO {
        return DAO.quantidadeAmigos();
    }

    /**
     * Retorna uma representação em string do amigo.
     */
    @Override
    public String toString() {
        return "Amigo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}