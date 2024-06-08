package controle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import dao.ExceptionDAO;
import modelo.Emprestimo;

/**
 * Esta classe é responsável por controlar as operações relacionadas a empréstimos.
 */
public class EmprestimoControle {

    private static final String erroMsgModeloNulo = "O objeto 'emprestimo' não pode ser nulo!";
    private static final String erroMsgIdNulo = "O atributo 'Id' do objeto 'emprestimo' não pode ser nulo!";

    private EmprestimoControle() {

    }

    /**
     * Busca um empréstimo pelo seu ID.
     */
    public static Optional<Emprestimo> buscar(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroMsgIdNulo);
        return Emprestimo.buscar(id);
    }

    /**
     * Busca todos os empréstimos cadastrados.
     */
    public static ArrayList<Emprestimo> buscarTudo() throws ExceptionDAO {
        return Emprestimo.buscarTudo();
    }

    /**
     * Cadastra um novo empréstimo.
     */
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

    /**
     * Cadastra um novo empréstimo com os parâmetros fornecidos.
     */
    public static void cadastrar(Integer idFerramenta, Integer idAmigo, LocalDate dataInicial, LocalDate dataPrazo) throws ExceptionDAO {
        Emprestimo emprestimo = new Emprestimo(idFerramenta, idAmigo, dataInicial, dataPrazo);
        cadastrar(emprestimo);
    }

    /**
     * Altera um empréstimo existente.
     */
    public static void alterar(Emprestimo emprestimo) throws ExceptionDAO {
        Objects.requireNonNull(emprestimo, erroMsgModeloNulo);
        Integer id = emprestimo.getId();
        Objects.requireNonNull(id, erroMsgIdNulo);
        int rowsAffected = Emprestimo.alterar(emprestimo);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("O empréstimo '" + id + "' não foi alterado pois não exite!");
        }
    }

    /**
     * Exclui um empréstimo pelo seu ID.
     */
    public static void excluir(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroMsgIdNulo);
        int rowsAffected = Emprestimo.excluir(id);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("O empréstimo '" + id + "' não foi excluído pois não existe!");
        }
    }

    /**
     * Exclui um empréstimo.
     */
    public static void excluir(Emprestimo emprestimo) throws ExceptionDAO {
        excluir(emprestimo.getId());
    }

    // Métodos para buscar empréstimos ativos, em dia, atrasados e confirmar devolução foram mantidos conforme o original...

    /**
     * Obtém a quantidade total de empréstimos cadastrados.
     */
    public static int quantidadeEmprestimos() throws ExceptionDAO {
        return Emprestimo.quantidadeEmprestimos();
    }
}