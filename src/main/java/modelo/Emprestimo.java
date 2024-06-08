package modelo;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Optional;

import dao.EmprestimoDAO;
import dao.ExceptionDAO;

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

    public Emprestimo() {
        this(null, null ,null, null);
    }

    public Emprestimo(Integer idFerramenta, Integer idAmigo, LocalDate dataInicial, LocalDate dataPrazo) {
        this(idFerramenta, idAmigo, dataInicial, dataPrazo, null);
    }

    public Emprestimo(Integer idFerramenta, Integer idAmigo, LocalDate dataInicial, LocalDate dataPrazo,
                      LocalDate dataDevolucao) {
        this(null, idFerramenta, idAmigo, dataInicial, dataPrazo, dataDevolucao);
    }

    public Emprestimo(Integer id, Integer idFerramenta, Integer idAmigo, LocalDate dataInicial, LocalDate dataPrazo,
                      LocalDate dataDevolucao) {
        this(id, idFerramenta, idAmigo, dataInicial, dataPrazo, dataDevolucao, new Amigo(), new Ferramenta());
    }

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
  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdFerramenta() {
        return idFerramenta;
    }

    public void setIdFerramenta(Integer idFerramenta) {
        this.idFerramenta = idFerramenta;
    }

    public Integer getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(Integer idAmigo) {
        this.idAmigo = idAmigo;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataPrazo() {
        return dataPrazo;
    }

    public void setDataPrazo(LocalDate dataPrazo) {
        this.dataPrazo = dataPrazo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Amigo getAmigo() {
        return amigo;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

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

    public String getDataInicialFormatada(String formato) {
        return getDataFormatada(dataInicial, formato);
    }

    public String getDataPrazoFormatada(String formato) {
        return getDataFormatada(dataPrazo, formato);
    }

    public String getDataDevolucaoFormatada(String formato) {
        return getDataFormatada(dataDevolucao, formato);
    }

    public String getDataInicialFormatada() {
        return getDataInicialFormatada("dd/MM/yyyy");
    }

    public String getDataPrazoFormatada() {
        return getDataPrazoFormatada("dd/MM/yyyy");
    }

    public String getDataDevolucaoFormatada() {
        return getDataDevolucaoFormatada("dd/MM/yyyy");
    }
    public static Optional<Emprestimo> buscar(Integer id) throws ExceptionDAO {
        return DAO.buscar(id);
    }

    public static ArrayList<Emprestimo> buscarTudo() throws ExceptionDAO {
        return DAO.buscarTudo();
    }

    public static void cadastrar(Emprestimo emprestimo) throws ExceptionDAO {
        DAO.cadastrar(emprestimo);
    }

    public static int alterar(Emprestimo emprestimo) throws ExceptionDAO {
        return DAO.alterar(emprestimo);
    }

    public static int excluir(Integer id) throws ExceptionDAO {
        return DAO.excluir(id);
    }

    public static ArrayList<Emprestimo> buscarAtivos() throws ExceptionDAO {
        return DAO.buscarAtivos();
    }

    public static ArrayList<Emprestimo> buscarEmDia() throws ExceptionDAO {
        return DAO.buscarEmDia();
    }

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
