package controle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import dao.ExceptionDAO;
import modelo.Emprestimo;

public class EmprestimoControle {

    private static final String erroMsgModeloNulo = "O objeto 'emprestimo' não pode ser nulo!";
    private static final String erroMsgIdNulo = "O atributo 'Id' do objeto 'emprestimo' não pode ser nulo!";

    private EmprestimoControle() {

    }

    public static Optional<Emprestimo> buscar(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroMsgIdNulo);
        return Emprestimo.buscar(id);
    }

    public static ArrayList<Emprestimo> buscarTudo() throws ExceptionDAO {
        return Emprestimo.buscarTudo();
    }

    public static void cadastrar(Emprestimo emprestimo) throws ExceptionDAO {
        Objects.requireNonNull(emprestimo, erroMsgModeloNulo);
        Objects.requireNonNull(emprestimo.getIdFerramenta(), "O atributo 'IdFerramenta' do objeto " +
                "'emprestimo' não pode ser nulo!");
        Objects.requireNonNull(emprestimo.getIdAmigo(), "O atributo 'IdAmigo' do objeto " +
                "'emprestimo' não pode ser nulo!");
        Objects.requireNonNull(emprestimo.getDataInicial(), "O atributo 'dataInicial' do objeto " +
                "'emprestimo' não pode ser nulo!");
        Objects.requireNonNull(emprestimo.getDataPrazo(), "O atributo 'dataPrazo' do objeto " +
                "'emprestimo' não pode ser nulo!");
        Emprestimo.cadastrar(emprestimo);
    }

    public static void cadastrar(Integer idFerramenta, Integer idAmigo, LocalDate dataInicial, LocalDate dataPrazo) throws ExceptionDAO {
        Emprestimo emprestimo = new Emprestimo(idFerramenta, idAmigo, dataInicial, dataPrazo);
        cadastrar(emprestimo);
    }

    public static void alterar(Emprestimo emprestimo) throws ExceptionDAO {
        Objects.requireNonNull(emprestimo, erroMsgModeloNulo);
        Integer id = emprestimo.getId();
        Objects.requireNonNull(id, erroMsgIdNulo);
        int rowsAffected = Emprestimo.alterar(emprestimo);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("O empréstimo '" + id + "' não foi alterado pois não exite!");
        }
    }

    public static void excluir(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroMsgIdNulo);
        int rowsAffected = Emprestimo.excluir(id);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("O empréstimo '" + id + "' não foi excluído pois não existe!");
        }
    }

    public static void excluir(Emprestimo emprestimo) throws ExceptionDAO {
        excluir(emprestimo.getId());
    }

    public static ArrayList<Emprestimo> buscarAtivos() throws ExceptionDAO {
        return Emprestimo.buscarAtivos();
    }

    public static ArrayList<Emprestimo> buscarEmDia() throws ExceptionDAO {
        return Emprestimo.buscarEmDia();
    }

    public static ArrayList<Emprestimo> buscarAtrasados() throws ExceptionDAO {
        return Emprestimo.buscarAtrasados();
    }

    public static void confirmarDevolucao(Integer id, LocalDate date) throws ExceptionDAO {
        Objects.requireNonNull(id, erroMsgIdNulo);
        Objects.requireNonNull(date, "A data de devolução não pode ser nula!");

        Optional<Emprestimo> emprestimoOptional = buscar(id);
        if (emprestimoOptional.isEmpty()) {
            throw new ExceptionDAO("O empréstimo de Id '" + id + "' não foi encontrado!");
        }
        Emprestimo emprestimo = emprestimoOptional.get();
        if (emprestimo.getDataDevolucao() != null) {
            throw new ExceptionDAO("Não é possível confirmar a devolução de um empréstimo já devolvido!");
        }
        emprestimo.setDataDevolucao(date);
        Emprestimo.alterar(emprestimo);
    }

    public static void confirmarDevolucao(Integer id) throws ExceptionDAO {
        confirmarDevolucao(id, LocalDate.now());
    }

    public static void confirmarDevolucao(Emprestimo emprestimo) throws ExceptionDAO {
        confirmarDevolucao(emprestimo.getId(), emprestimo.getDataDevolucao());
    }

    public static int quantidadeEmprestimos() throws ExceptionDAO {
        return Emprestimo.quantidadeEmprestimos();
    }
}

