package modelo;

import dao.EmprestimoDAO;
import dao.ExceptionDAO;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Optional;

public class Emprestimo {
    private Integer id;
    private Integer id_ferramenta;
    private Integer id_amigo;
    private LocalDate data_inicial;
    private LocalDate data_prazo;
    private LocalDate data_devolucao;

    private static final EmprestimoDAO DAO = new EmprestimoDAO();

    // Construtor vazio
    public Emprestimo() {
    }

    // Construtor com todos os parâmetros
    public Emprestimo(Integer id_ferramenta, Integer id_amigo, LocalDate data_inicial, LocalDate data_prazo,
    LocalDate data_devolucao) {
        this.id_ferramenta = id_ferramenta;
        this.id_amigo = id_amigo;
        this.data_inicial = data_inicial;
        this.data_prazo = data_prazo;
        this.data_devolucao = data_devolucao;
    }

    // Construtor para testes com id
    public Emprestimo(Integer id, Integer id_ferramenta, Integer id_amigo, LocalDate data_inicial, LocalDate data_prazo,
    LocalDate data_devolucao) {
        this.id = id;
        this.id_ferramenta = id_ferramenta;
        this.id_amigo = id_amigo;
        this.data_inicial = data_inicial;
        this.data_prazo = data_prazo;
        this.data_devolucao = data_devolucao;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_ferramenta() {
        return id_ferramenta;
    }

    public void setId_ferramenta(Integer id_ferramenta) {
        this.id_ferramenta = id_ferramenta;
    }

    public Integer getId_amigo() {
        return id_amigo;
    }

    public void setId_amigo(Integer id_amigo) {
        this.id_amigo = id_amigo;
    }

    public LocalDate getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(LocalDate data_inicial) {
        this.data_inicial = data_inicial;
    }

    public LocalDate getData_prazo() {
        return data_prazo;
    }

    public void setData_prazo(LocalDate data_prazo) {
        this.data_prazo = data_prazo;
    }

    public LocalDate getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(LocalDate data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    // Métodos de acesso ao banco de dados
    public static Optional<Emprestimo> buscar(Integer id) throws ExceptionDAO {
        return DAO.get(id);
    }

    public static ArrayList<Emprestimo> buscarTudo() throws ExceptionDAO {
        return DAO.getAll();
    }

    public static void cadastrar(Emprestimo emprestimo) throws ExceptionDAO {
        DAO.create(emprestimo);
    }

    public static void alterar(Emprestimo emprestimo) throws ExceptionDAO {
        DAO.update(emprestimo);
    }

    public static void excluir(Integer id) throws ExceptionDAO {
        DAO.delete(id);
    }

    // toString para facilitar a visualização dos dados
    @Override
    public String toString() {
        return "EmprestimoModelo{" +
                "id=" + id +
                ", id_ferramenta=" + id_ferramenta +
                ", id_amigo=" + id_amigo +
                ", data_inicial=" + data_inicial +
                ", data_prazo=" + data_prazo +
                ", data_devolucao=" + data_devolucao +
                '}';
    }
}
