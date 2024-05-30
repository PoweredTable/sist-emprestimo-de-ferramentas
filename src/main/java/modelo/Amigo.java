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
        this("","","");
    }

    /**
     * Construtor que inicializa os atributos com os valores fornecidos.
     * 
     * @param nome o nome do amigo
     * @param apelido o apelido do amigo
     * @param telefone o telefone do amigo
     */
    public Amigo(String nome, String apelido, String telefone) {
        this(null, nome, apelido, telefone);
    }

    /**
     * Construtor que inicializa todos os atributos com os valores fornecidos.
     * 
     * @param id o ID do amigo
     * @param nome o nome do amigo
     * @param apelido o apelido do amigo
     * @param telefone o telefone do amigo
     */
    public Amigo(Integer id, String nome, String apelido, String telefone) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
    }

    // Métodos getters e setters

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

    /**
     * Busca um amigo pelo ID.
     * 
     * @param id o ID do amigo
     * @return um Optional contendo o amigo encontrado ou vazio se não encontrado
     * @throws ExceptionDAO se ocorrer um erro na busca
     */
    public static Optional<Amigo> buscar(Integer id) throws ExceptionDAO {
        return DAO.buscar(id);
    }

    /**
     * Busca todos os amigos.
     * 
     * @return uma lista de todos os amigos
     * @throws ExceptionDAO se ocorrer um erro na busca
     */
    public static ArrayList<Amigo> buscarTudo() throws ExceptionDAO {
        return DAO.buscarTudo();
    }

    /**
     * Cadastra um novo amigo.
     * 
     * @param amigo o amigo a ser cadastrado
     * @throws ExceptionDAO se ocorrer um erro no cadastro
     */
    public static void cadastrar(Amigo amigo) throws ExceptionDAO {
        DAO.cadastrar(amigo);
    }

    /**
     * Altera os dados de um amigo.
     * 
     * @param amigo o amigo com os dados alterados
     * @return o número de registros alterados
     * @throws ExceptionDAO se ocorrer um erro na alteração
     */
    public static int alterar(Amigo amigo) throws ExceptionDAO {
        return DAO.alterar(amigo);
    }

    /**
     * Exclui um amigo pelo ID.
     * 
     * @param id o ID do amigo a ser excluído
     * @return o número de registros excluídos
     * @throws ExceptionDAO se ocorrer um erro na exclusão
     */
    public static int excluir(Integer id) throws ExceptionDAO {
        return DAO.excluir(id);
    }

    /**
     * Verifica se um amigo possui empréstimo ativo.
     * 
     * @param id o ID do amigo
     * @return true se o amigo possuir empréstimo ativo, false caso contrário
     * @throws ExceptionDAO se ocorrer um erro na verificação
     */
    public static boolean amigoPossuiEmprestimoAtivo(Integer id) throws ExceptionDAO {
        return DAO.amigoPossuiEmprestimoAtivo(id);
    }

    /**
     * Busca o amigo com o maior número de utilizações.
     * 
     * @return um Optional contendo o amigo encontrado ou vazio se não encontrado
     * @throws ExceptionDAO se ocorrer um erro na busca
     */
    public static Optional<Amigo> buscarMaiorUtilizador() throws ExceptionDAO {
        return DAO.buscarMaiorUtilizador();
    }

    /**
     * Busca amigos pelo nome.
     * 
     * @param nome o nome dos amigos a serem buscados
     * @return uma lista de amigos com o nome fornecido
     * @throws ExceptionDAO se ocorrer um erro na busca
     */
    public static ArrayList<Amigo> buscarNome(String nome) throws ExceptionDAO {
        return DAO.buscarNome(nome);
    }

<<<<<<< HEAD
    /**
     * Retorna uma representação em string do amigo.
     * 
     * @return uma string representando o amigo
     */
    @Override
=======
    public static int quantidadeAmigos() throws ExceptionDAO {
        return DAO.quantidadeAmigos();
    }

>>>>>>> dev
    public String toString() {
        return "Amigo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}