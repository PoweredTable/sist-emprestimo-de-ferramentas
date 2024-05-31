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
     *
     * @param id O ID da ferramenta a ser buscada.
     * @return Um objeto Optional contendo a ferramenta, se encontrada.
     * @throws ExceptionDAO Se ocorrer um erro durante a busca no DAO.
     */
    public static Optional<Ferramenta> buscar(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroIdNulo);
        return Ferramenta.buscar(id);
    }

    /**
     * Busca todas as ferramentas cadastradas.
     *
     * @return Uma lista contendo todas as ferramentas cadastradas.
     * @throws ExceptionDAO Se ocorrer um erro durante a busca no DAO.
     */
    public static ArrayList<Ferramenta> buscarTudo() throws ExceptionDAO {
        return Ferramenta.buscarTudo();
    }

    /**
     * Cadastra uma nova ferramenta.
     *
     * @param ferramenta A ferramenta a ser cadastrada.
     * @throws ExceptionDAO Se ocorrer um erro durante a operação no DAO.
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
     *
     * @param nome  O nome da ferramenta.
     * @param marca A marca da ferramenta.
     * @param preco O preço da ferramenta.
     * @throws ExceptionDAO Se ocorrer um erro durante a operação no DAO.
     */
    public static void cadastrar(String nome, String marca, Double preco) throws ExceptionDAO {
        Ferramenta ferramenta = new Ferramenta(nome, marca, preco);
        cadastrar(ferramenta);
    }

    /**
     * Altera uma ferramenta existente.
     *
     * @param ferramenta A ferramenta com as alterações a serem feitas.
     * @throws ExceptionDAO Se ocorrer um erro durante a operação no DAO.
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
     *
     * @param id O ID da ferramenta a ser excluída.
     * @throws ExceptionDAO Se ocorrer um erro durante a operação no DAO.
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
     *
     * @param ferramenta A ferramenta a ser excluída.
     * @throws ExceptionDAO Se ocorrer um erro durante a operação no DAO.
     */
    public static void excluir(Ferramenta ferramenta) throws ExceptionDAO {
        Objects.requireNonNull(ferramenta, erroModeloNulo);
        excluir(ferramenta.getId());
    }

    /**
     * Verifica se uma ferramenta está emprestada.
     *
     * @param id O ID da ferramenta a ser verificada.
     * @return true se a ferramenta estiver emprestada, caso contrário false.
     * @throws ExceptionDAO Se ocorrer um erro durante a operação no DAO.
     */
    public static boolean ferramentaEmprestada(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroIdNulo);
        return Ferramenta.ferramentaEmprestada(id);
    }

    /**
     * Verifica se uma ferramenta está emprestada.
     *
     * @param ferramenta A ferramenta a ser verificada.
     * @return true se a ferramenta estiver emprestada, caso contrário false.
     * @throws ExceptionDAO Se ocorrer um erro durante a operação no DAO.
     */
    public static boolean ferramentaEmprestada(Ferramenta ferramenta) throws ExceptionDAO {
        Objects.requireNonNull(ferramenta, erroModeloNulo);
        return ferramentaEmprestada(ferramenta.getId());
    }

    /**
     * Busca todas as ferramentas disponíveis para empréstimo.
     *
     * @return Uma lista contendo todas as ferramentas disponíveis.
     * @throws ExceptionDAO Se ocorrer um erro durante a busca no DAO.
     */
    public static ArrayList<Ferramenta> buscarFerramentasDisponiveis() throws ExceptionDAO {
        return Ferramenta.buscarFerramentasDisponiveis();
    }

    /**
     * Busca ferramentas pelo nome.
     *
     * @param nome O nome da ferramenta a ser buscada.
     * @return Uma lista contendo todas as ferramentas com o nome especificado.
     * @throws ExceptionDAO Se ocorrer um erro durante a busca no DAO.
     */
    public static ArrayList<Ferramenta> buscarNome(String nome) throws ExceptionDAO {
        Objects.requireNonNull(nome, "O nome da ferramenta não pode ser nulo!");
        return Ferramenta.buscarNome(nome);
    }

    /**
     * Calcula o custo total de todas as ferramentas cadastradas.
     *
     * @return O custo total de todas as ferramentas.
     * @throws ExceptionDAO Se ocorrer um erro durante a obtenção dos dados no DAO.
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
     *
     * @return A quantidade total de ferramentas cadastradas.
     * @throws ExceptionDAO Se ocorrer um erro durante a obtenção dos dados no DAO.
     */
    public static int quantidadeFerramentas() throws ExceptionDAO {
        return Ferramenta.quantidadeFerramentas();
    }
}