package controle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import dao.ExceptionDAO;
import modelo.Ferramenta;
import util.TextUtil;

/**
 * Esta classe é responsável por controlar as operações relacionadas a ferramentas.
 */
public class FerramentaControle {

    private static final String erroModeloNulo = "O objeto 'ferramenta' não pode ser nulo!";
    private static final String erroIdNulo = "O Id do objeto 'ferramenta' não pode ser nulo!";

    private FerramentaControle() {

    }

    /**
     * Busca uma ferramenta pelo seu ID.
     */
    public static Optional<Ferramenta> buscar(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroIdNulo);
        return Ferramenta.buscar(id);
    }

    /**
     * Busca todas as ferramentas cadastradas.
     */
    public static ArrayList<Ferramenta> buscarTudo() throws ExceptionDAO {
        return Ferramenta.buscarTudo();
    }

    /**
     * Cadastra uma nova ferramenta.
     */
    public static void cadastrar(Ferramenta ferramenta) throws ExceptionDAO {
        Objects.requireNonNull(ferramenta, erroModeloNulo);
        if (!TextUtil.isValidText(ferramenta.getNome())) {
            throw new ExceptionDAO("Nome da ferramenta inválido!");
        }
        if (!TextUtil.isValidText(ferramenta.getMarca())) {
            throw new ExceptionDAO("Nome da ferramenta inválido!");
        }
        Ferramenta.cadastrar(ferramenta);
    }

    /**
     * Cadastra uma nova ferramenta com os parâmetros fornecidos.
     */
    public static void cadastrar(String nome, String marca, Double preco) throws ExceptionDAO {
        Ferramenta ferramenta = new Ferramenta(nome, marca, preco);
        cadastrar(ferramenta);
    }

    /**
     * Altera uma ferramenta existente.
     */
    public static void alterar(Ferramenta ferramenta) throws ExceptionDAO {
        Objects.requireNonNull(ferramenta, erroModeloNulo);
        Integer id = ferramenta.getId();
        Objects.requireNonNull(id, erroIdNulo);
        int rowsAffected = Ferramenta.alterar(ferramenta);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("A ferramenta '" + id + "' não foi alterada pois não existe!");
        }
    }

    /**
     * Exclui uma ferramenta pelo seu ID.
     */
    public static void excluir(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroIdNulo);
        int rowsAffected = Ferramenta.excluir(id);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("A ferramenta '" + id + "' não foi excluída pois não existe!");
        }
    }

    /**
     * Exclui uma ferramenta.
     */
    public static void excluir(Ferramenta ferramenta) throws ExceptionDAO {
        Objects.requireNonNull(ferramenta, erroModeloNulo);
        excluir(ferramenta.getId());
    }

    /**
     * Verifica se uma ferramenta está emprestada.
     */
    public static boolean ferramentaEmprestada(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroIdNulo);
        return Ferramenta.ferramentaEmprestada(id);
    }

    /**
     * Verifica se uma ferramenta está emprestada.
     */
    public static boolean ferramentaEmprestada(Ferramenta ferramenta) throws ExceptionDAO {
        Objects.requireNonNull(ferramenta, erroModeloNulo);
        return ferramentaEmprestada(ferramenta.getId());
    }

    /**
     * Busca todas as ferramentas disponíveis para empréstimo.
     */
    public static ArrayList<Ferramenta> buscarFerramentasDisponiveis() throws ExceptionDAO {
        return Ferramenta.buscarFerramentasDisponiveis();
    }

    /**
     * Busca ferramentas pelo nome.
     */
    public static ArrayList<Ferramenta> buscarNome(String nome) throws ExceptionDAO {
        Objects.requireNonNull(nome, "O nome da ferramenta não pode ser nulo!");
        return Ferramenta.buscarNome(nome);
    }

    /**
     * Calcula o custo total de todas as ferramentas cadastradas.
     */
    public static Double getCustoTotal() throws ExceptionDAO {
        ArrayList<Ferramenta> ferramentas = buscarTudo();
        Double soma = 0.0;
        for (Ferramenta ferramenta : ferramentas) {
            soma += ferramenta.getPreco();
        }
        return soma;
    }

    /**
     * Retorna a quantidade total de ferramentas cadastradas.
     */
    public static int quantidadeFerramentas() throws ExceptionDAO {
        return Ferramenta.quantidadeFerramentas();
    }
}