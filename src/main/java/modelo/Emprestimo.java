package modelo;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Optional;

import dao.EmprestimoDAO;
import dao.ExceptionDAO;
// 

public class Emprestimo {
    private Integer id;
    private Integer idFerramenta;
    private Integer idAmigo;
    private LocalDate dataInicial;
    private LocalDate dataPrazo;
    private LocalDate dataDevolucao;
    private Amigo amigo;
    private Ferramenta ferramenta;

    private static final EmprestimoDAO DAO = EmprestimoDAO.getInstance();

    /* Construtor sem parâmetros que inicializa todos os atributos com valores nulos ou objetos vazios */
    public Emprestimo() {
        this.id = null;
        this.idFerramenta = null;
        this.idAmigo = null;
        this.dataInicial = null;
        this.dataPrazo = null;
        this.dataDevolucao = null;
        this.amigo = new Amigo();
        this.ferramenta = new Ferramenta();
    }

    /* Construtor que inicializa um empréstimo sem data de devolução */
    /**
     * @param idFerramenta ID da ferramenta
     * @param idAmigo ID do amigo
     * @param dataInicial Data inicial do empréstimo
     * @param dataPrazo Data de prazo do empréstimo
     */
    public Emprestimo(Integer idFerramenta, Integer idAmigo, LocalDate dataInicial, LocalDate dataPrazo) {
        this.idFerramenta = idFerramenta;
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataPrazo = dataPrazo;
    }

    /* Construtor que inicializa um empréstimo com data de devolução */
    /**
     * @param idFerramenta ID da ferramenta
     * @param idAmigo ID do amigo
     * @param dataInicial Data inicial do empréstimo
     * @param dataPrazo Data de prazo do empréstimo
     * @param dataDevolucao Data de devolução do empréstimo
     */
    public Emprestimo(Integer idFerramenta, Integer idAmigo, LocalDate dataInicial, LocalDate dataPrazo,
    LocalDate dataDevolucao) {
        this.idFerramenta = idFerramenta;
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataPrazo = dataPrazo;
        this.dataDevolucao = dataDevolucao;
    }

    /* Construtor que inicializa todos os atributos do empréstimo, incluindo o id */
    /**
     * @param id ID do empréstimo
     * @param idFerramenta ID da ferramenta
     * @param idAmigo ID do amigo
     * @param dataInicial Data inicial do empréstimo
     * @param dataPrazo Data de prazo do empréstimo
     * @param dataDevolucao Data de devolução do empréstimo
     */
    public Emprestimo(Integer id, Integer idFerramenta, Integer idAmigo, LocalDate dataInicial, LocalDate dataPrazo,
    LocalDate dataDevolucao) {
        this.id = id;
        this.idFerramenta = idFerramenta;
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataPrazo = dataPrazo;
        this.dataDevolucao = dataDevolucao;
    }

    /* Construtor completo que inicializa todos os atributos do empréstimo, incluindo objetos Amigo e Ferramenta */
    /**
     * @param id ID do empréstimo
     * @param idFerramenta ID da ferramenta
     * @param idAmigo ID do amigo
     * @param dataInicial Data inicial do empréstimo
     * @param dataPrazo Data de prazo do empréstimo
     * @param dataDevolucao Data de devolução do empréstimo
     * @param amigo Objeto Amigo associado ao empréstimo
     * @param ferramenta Objeto Ferramenta associado ao empréstimo
     */
    public Emprestimo(Integer id, Integer idFerramenta, Integer idAmigo, LocalDate dataInicial, LocalDate dataPrazo,
    LocalDate dataDevolucao, Amigo amigo, Ferramenta ferramenta) {
        this.id = id;
        this.idFerramenta = idFerramenta;
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataPrazo = dataPrazo;
        this.dataDevolucao = dataDevolucao;
        this.amigo = amigo;
        this.ferramenta = ferramenta;
    }

    /* Retorna o id do empréstimo */
    /**
     * @return ID do empréstimo
     */
    public Integer getId() {
        return id;
    }

    /* Define o id do empréstimo */
    /**
     * @param id ID do empréstimo
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /* Retorna o id da ferramenta associada ao empréstimo */
    /**
     * @return ID da ferramenta
     */
    public Integer getIdFerramenta() {
        return idFerramenta;
    }

    /* Define o id da ferramenta associada ao empréstimo */
    /**
     * @param idFerramenta ID da ferramenta
     */
    public void setIdFerramenta(Integer idFerramenta) {
        this.idFerramenta = idFerramenta;
    }

    /* Retorna o id do amigo associado ao empréstimo */
    /**
     * @return ID do amigo
     */
    public Integer getIdAmigo() {
        return idAmigo;
    }

    /* Define o id do amigo associado ao empréstimo */
    /**
     * @param idAmigo ID do amigo
     */
    public void setIdAmigo(Integer idAmigo) {
        this.idAmigo = idAmigo;
    }

    /* Retorna a data inicial do empréstimo */
    /**
     * @return Data inicial do empréstimo
     */
    public LocalDate getDataInicial() {
        return dataInicial;
    }

    /* Define a data inicial do empréstimo */
    /**
     * @param dataInicial Data inicial do empréstimo
     */
    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    /* Retorna a data de prazo do empréstimo */
    /**
     * @return Data de prazo do empréstimo
     */
    public LocalDate getDataPrazo() {
        return dataPrazo;
    }

    /* Define a data de prazo do empréstimo */
    /**
     * @param dataPrazo Data de prazo do empréstimo
     */
    public void setDataPrazo(LocalDate dataPrazo) {
        this.dataPrazo = dataPrazo;
    }

    /* Retorna a data de devolução do empréstimo */
    /**
     * @return Data de devolução do empréstimo
     */
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    /* Define a data de devolução do empréstimo */
    /**
     * @param dataDevolucao Data de devolução do empréstimo
     */
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /* Retorna o objeto Amigo associado ao empréstimo */
    /**
     * @return Objeto Amigo associado ao empréstimo
     */
    public Amigo getAmigo() {
        return amigo;
    }

    /* Define o objeto Amigo associado ao empréstimo */
    /**
     * @param amigo Objeto Amigo associado ao empréstimo
     */
    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    /* Retorna o objeto Ferramenta associado ao empréstimo */
    /**
     * @return Objeto Ferramenta associado ao empréstimo
     */
    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    /* Define o objeto Ferramenta associado ao empréstimo */
    /**
     * @param ferramenta Objeto Ferramenta associado ao empréstimo
     */
    public void setFerramenta(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }

    /* Busca um empréstimo pelo id */
    /**
     * @param id ID do empréstimo
     * @return Optional contendo o empréstimo, se encontrado
     * @throws ExceptionDAO Exceção da camada DAO
     */
    public static Optional<Emprestimo> buscar(Integer id) throws ExceptionDAO {
        return DAO.buscar(id);
    }

    /* Busca todos os empréstimos */
    /**
     * @return Lista de todos os empréstimos
     * @throws ExceptionDAO Exceção da camada DAO
     */
    public static ArrayList<Emprestimo> buscarTudo() throws ExceptionDAO {
        return DAO.buscarTudo();
    }

    /* Cadastra um novo empréstimo */
    /**
     * @param emprestimo Empréstimo a ser cadastrado
     * @throws ExceptionDAO Exceção da camada DAO
     */
    public static void cadastrar(Emprestimo emprestimo) throws ExceptionDAO {
        DAO.cadastrar(emprestimo);
    }

    /* Altera um empréstimo existente */
    /**
     * @param emprestimo Empréstimo a ser alterado
     * @return Número de linhas afetadas
     * @throws ExceptionDAO Exceção da camada DAO
     */
    public static int alterar(Emprestimo emprestimo) throws ExceptionDAO {
        return DAO.alterar(emprestimo);
    }

    /* Exclui um empréstimo pelo id */
    /**
     * @param id ID do empréstimo a ser excluído
     * @return Número de linhas afetadas
     * @throws ExceptionDAO Exceção da camada DAO
     */
    public static int excluir(Integer id) throws ExceptionDAO {
        return DAO.excluir(id);
    }

    /* Busca todos os empréstimos ativos */
    /**
     * @return Lista de empréstimos ativos
     * @throws ExceptionDAO Exceção da camada DAO
     */
    public static ArrayList<Emprestimo> buscarAtivos() throws ExceptionDAO {
        return DAO.buscarAtivos();
    }

    /* Busca todos os empréstimos em dia */
    /**
     * @return Lista de empréstimos em dia
     * @throws ExceptionDAO Exceção da camada DAO
     */
    public static ArrayList<Emprestimo> buscarEmDia() throws ExceptionDAO {
        return DAO.buscarEmDia();
    }

    /* Busca todos os empréstimos atrasados */
    /**
     * @return Lista de empréstimos atrasados
     * @throws ExceptionDAO Exceção da camada DAO
     */
    public static ArrayList<Emprestimo> buscarAtrasados() throws ExceptionDAO {
        return DAO.buscarAtrasados();
    }

    public static int quantidadeEmprestimos() throws ExceptionDAO {
        return DAO.quantidadeEmprestimos();
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", idFerramenta=" + idFerramenta +
                ", idAmigo=" + idAmigo +
                ", dataInicial=" + dataInicial +
                ", dataPrazo=" + dataPrazo +
                ", dataDevolucao=" + dataDevolucao +
                ", nomeAmigo='" + amigo.getNome() + '\'' +
                ", apelidoAmigo='" + amigo.getApelido() + '\'' +
                ", nomeFerramenta='" + ferramenta.getNome() + '\'' +
                '}';
    }
}