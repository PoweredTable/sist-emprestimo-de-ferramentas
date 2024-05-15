package modelo;

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
    private String nomeAmigo;
    private String apelidoAmigo;
    private String nomeFerramenta;

    private static final EmprestimoDAO DAO = EmprestimoDAO.getInstance();

    public Emprestimo() {
        this.id = null;
        this.idFerramenta = null;
        this.idAmigo = null;
        this.dataInicial = null;
        this.dataPrazo = null;
        this.dataDevolucao = null;
        this.nomeAmigo = null;
        this.apelidoAmigo = null;
        this.nomeFerramenta = null;
    }

    public Emprestimo(Integer idFerramenta, Integer idAmigo, LocalDate dataInicial, LocalDate dataPrazo) {
        this.idFerramenta = idFerramenta;
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataPrazo = dataPrazo;
    }

    public Emprestimo(Integer idFerramenta, Integer idAmigo, LocalDate dataInicial, LocalDate dataPrazo,
    LocalDate dataDevolucao) {
        this.idFerramenta = idFerramenta;
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataPrazo = dataPrazo;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo(Integer id, Integer idFerramenta, Integer idAmigo, LocalDate dataInicial, LocalDate dataPrazo,
    LocalDate dataDevolucao) {
        this.id = id;
        this.idFerramenta = idFerramenta;
        this.idAmigo = idAmigo;
        this.dataInicial = dataInicial;
        this.dataPrazo = dataPrazo;
        this.dataDevolucao = dataDevolucao;
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

    public String getNomeAmigo() {
        return nomeAmigo;
    }

    public void setNomeAmigo(String nomeAmigo) {
        this.nomeAmigo = nomeAmigo;
    }

    public String getApelidoAmigo() {
        return apelidoAmigo;
    }

    public void setApelidoAmigo(String apelidoAmigo) {
        this.apelidoAmigo = apelidoAmigo;
    }

    public String getNomeFerramenta() {
        return nomeFerramenta;
    }

    public void setNomeFerramenta(String nomeFerramenta) {
        this.nomeFerramenta = nomeFerramenta;
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

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", idFerramenta=" + idFerramenta +
                ", idAmigo=" + idAmigo +
                ", dataInicial=" + dataInicial +
                ", dataPrazo=" + dataPrazo +
                ", dataDevolucao=" + dataDevolucao +
                ", nomeAmigo='" + nomeAmigo + '\'' +
                ", apelidoAmigo='" + apelidoAmigo + '\'' +
                ", nomeFerramenta='" + nomeFerramenta + '\'' +
                '}';
    }
}
