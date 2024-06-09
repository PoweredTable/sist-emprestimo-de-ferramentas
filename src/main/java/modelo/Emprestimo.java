package modelo;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Optional;

import dao.EmprestimoDAO;
import dao.ExceptionDAO;

/**
 * Classe Emprestimo representa um empréstimo com seus atributos e métodos de manipulação.
 */
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

    /**
     * Construtor sem parâmetros que inicializa todos os atributos com valores nulos ou objetos vazios.
     */
    public Emprestimo() {
        this(null, null ,null, null);
    }

    /**
     * Construtor que inicializa um empréstimo sem data de devolução.
     */
    public Emprestimo(Integer idFerramenta, Integer idAmigo, LocalDate dataInicial, LocalDate dataPrazo) {
        this(idFerramenta, idAmigo, dataInicial, dataPrazo, null);
    }

    /**
     * Construtor que inicializa um empréstimo com data de devolução.
     */
    public Emprestimo(Integer idFerramenta, Integer idAmigo, LocalDate dataInicial, LocalDate dataPrazo,
                      LocalDate dataDevolucao) {
        this(null, idFerramenta, idAmigo, dataInicial, dataPrazo, dataDevolucao);
    }

    /**
     * Construtor que inicializa todos os atributos do empréstimo, incluindo o id.
     */
    public Emprestimo(Integer id, Integer idFerramenta, Integer idAmigo, LocalDate dataInicial, LocalDate dataPrazo,
                      LocalDate dataDevolucao) {
        this(id, idFerramenta, idAmigo, dataInicial, dataPrazo, dataDevolucao, new Amigo(), new Ferramenta());
    }

    /**
     * Construtor completo que inicializa todos os atributos do empréstimo, incluindo objetos Amigo e Ferramenta.
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

    /**
     * Retorna o id do empréstimo.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o id do empréstimo.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retorna o id da ferramenta associada ao empréstimo.
     */
    public Integer getIdFerramenta() {
        return idFerramenta;
    }

    /**
     * Define o id da ferramenta associada ao empréstimo.
     */
    public void setIdFerramenta(Integer idFerramenta) {
        this.idFerramenta = idFerramenta;
    }

    /**
     * Retorna o id do amigo associado ao empréstimo.
     */
    public Integer getIdAmigo() {
        return idAmigo;
    }

    /**
     * Define o id do amigo associado ao empréstimo.
     */
    public void setIdAmigo(Integer idAmigo) {
        this.idAmigo = idAmigo;
    }

    /**
     * Retorna a data inicial do empréstimo.
     */
    public LocalDate getDataInicial() {
        return dataInicial;
    }

    /**
     * Define a data inicial do empréstimo.
     */
    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    /**
     * Retorna a data de prazo do empréstimo.
     */
    public LocalDate getDataPrazo() {
        return dataPrazo;
    }

    /**
     * Define a data de prazo do empréstimo.
     */
    public void setDataPrazo(LocalDate dataPrazo) {
        this.dataPrazo = dataPrazo;
    }

    /**
     * Retorna a data de devolução do empréstimo.
     */
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * Define a data de devolução do empréstimo.
     */
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * Retorna o objeto Amigo associado ao empréstimo.
     */
    public Amigo getAmigo() {
        return amigo;
    }

    /**
     * Define o objeto Amigo associado ao empréstimo.
     */
    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    /**
     * Retorna o objeto Ferramenta associado ao empréstimo.
     */
    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    /**
     * Define o objeto Ferramenta associado ao empréstimo.
     */
    public void setFerramenta(Ferramenta ferramenta) {
        this.ferramenta = ferramenta;
    }

    private String getDataFormatada(LocalDate data, String formato) {
        if (data == null) {
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return data.format(formatter);
    }

    /**
     * Retorna a data inicial do empréstimo formatada.
     */
    public String getDataInicialFormatada(String formato) {
        return getDataFormatada(dataInicial, formato);
    }

    /**
     * Retorna a data de prazo do empréstimo formatada.
     */
    public String getDataPrazoFormatada(String formato) {
        return getDataFormatada(dataPrazo, formato);
    }

    /**
     * Retorna a data de devolução do empréstimo formatada.
     */
    public String getDataDevolucaoFormatada(String formato) {
        return getDataFormatada(dataDevolucao, formato);
    }

    /**
     * Retorna a data inicial do empréstimo formatada no padrão "dd/MM/yyyy".
     */
    public String getDataInicialFormatada() {
        return getDataInicialFormatada("dd/MM/yyyy");
    }

    /**
     * Retorna a data de prazo do empréstimo formatada no padrão "dd/MM/yyyy".
     */
    public String getDataPrazoFormatada() {
        return getDataPrazoFormatada("dd/MM/yyyy");
    }

    /**
     * Retorna a data de devolução do empréstimo formatada no padrão "dd/MM/yyyy".
     */
    public String getDataDevolucaoFormatada() {
        return getDataDevolucaoFormatada("dd/MM/yyyy");
    }

    /**
     * Busca um empréstimo pelo id.
     */
    public static Optional<Emprestimo> buscar(Integer id) throws ExceptionDAO {
        return DAO.buscar(id);
    }

    /**
     * Busca todos os empréstimos.
     */
    public static ArrayList<Emprestimo> buscarTudo() throws ExceptionDAO {
        return DAO.buscarTudo();
    }

    /**
     * Cadastra um novo empréstimo.
     */
    public static void cadastrar(Emprestimo emprestimo) throws ExceptionDAO {
        DAO.cadastrar(emprestimo);
    }

    /**
     * Altera um empréstimo existente.
     */
    public static int alterar(Emprestimo emprestimo) throws ExceptionDAO {
        return DAO.alterar(emprestimo);
    }

    /**
     * Exclui um empréstimo pelo id.
     */
    public static int excluir(Integer id) throws ExceptionDAO {
        return DAO.excluir(id);
    }

    /**
     * Busca todos os empréstimos ativos.
     */
    public static ArrayList<Emprestimo> buscarAtivos() throws ExceptionDAO {
        return DAO.buscarAtivos();
    }

    /**
     * Busca todos os empréstimos em dia.
     */
    public static ArrayList<Emprestimo> buscarEmDia() throws ExceptionDAO {
        return DAO.buscarEmDia();
    }

    /**
     * Busca todos os empréstimos atrasados.
     */
    public static ArrayList<Emprestimo> buscarAtrasados() throws ExceptionDAO {
        return DAO.buscarAtrasados();
    }

    /**
     * Retorna a quantidade de empréstimos cadastrados.
     */
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