package controle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import dao.ExceptionDAO;
import modelo.Amigo;
import util.TextUtil;

/**
 * Classe de controle para operações relacionadas aos amigos.
 */
public class AmigoControle {

    private static final String erroMsgModeloNulo = "O objeto 'amigo' não pode ser nulo!";
    private static final String erroMsgIdNulo = "O Id do objeto 'amigo' não pode ser nulo!";

    private AmigoControle() {

    }

    /**
     * Busca um amigo pelo ID.
     */
    public static Optional<Amigo> buscar(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroMsgIdNulo);
        return Amigo.buscar(id);
    }

    /**
     * Busca todos os amigos.
     */
    public static ArrayList<Amigo> buscarTudo() throws ExceptionDAO {
        return Amigo.buscarTudo();
    }

    /**
     * Cadastra um novo amigo.
     */
    public static void cadastrar(Amigo amigo) throws ExceptionDAO {
        Objects.requireNonNull(amigo, erroMsgModeloNulo);
        if (!TextUtil.isValidText(amigo.getNome())) {
            throw new ExceptionDAO("Nome do amigo inválido!");
        }
        if (!TextUtil.isValidText(amigo.getTelefone())) {
            throw new ExceptionDAO("Telefone do amigo inválido!");
        }
        Amigo.cadastrar(amigo);
    }

    /**
     * Cadastra um novo amigo a partir dos dados fornecidos.
     */
    public static void cadastrar(String nome, String apelido, String telefone) throws ExceptionDAO {
        Amigo amigo = new Amigo(nome, apelido, telefone);
        cadastrar(amigo);
    }

    /**
     * Altera os dados de um amigo.
     */
    public static void alterar(Amigo amigo) throws ExceptionDAO {
        Objects.requireNonNull(amigo, erroMsgModeloNulo);
        Integer id = amigo.getId();
        Objects.requireNonNull(id, erroMsgIdNulo);
        int rowsAffected = Amigo.alterar(amigo);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("O amigo '" + id + "' não foi excluído pois não existe!");
        }
    }

    /**
     * Exclui um amigo pelo ID.
     */
    public static void excluir(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroMsgIdNulo);
        int rowsAffected = Amigo.excluir(id);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("O amigo '" + id + "' não foi excluído pois não existe!");
        }
    }

    /**
     * Exclui um amigo.
     */
    public static void excluir(Amigo amigo) throws ExceptionDAO {
        Objects.requireNonNull(amigo, erroMsgModeloNulo);
        excluir(amigo.getId());
    }

    /**
     * Verifica se um amigo possui empréstimo ativo.
     */
    public static boolean amigoPossuiEmprestimoAtivo(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroMsgIdNulo);
        return Amigo.amigoPossuiEmprestimoAtivo(id);
    }

    /**
     * Verifica se um amigo possui empréstimo ativo.
     */
    public static boolean amigoPossuiEmprestimoAtivo(Amigo amigo) throws ExceptionDAO {
        Objects.requireNonNull(amigo, erroMsgModeloNulo);
        return amigoPossuiEmprestimoAtivo(amigo.getId());
    }

    /**
     * Busca amigos pelo nome.
     */
    public static ArrayList<Amigo> buscarNome(String nome) throws ExceptionDAO {
        Objects.requireNonNull(nome, "O nome do amigo não pode ser nulo!");
        return Amigo.buscarNome(nome);
    }

    /**
     * Busca o amigo que mais realizou empréstimos.
     */
    public static Optional<Amigo> buscarMaiorUtilizador() throws ExceptionDAO {
        return Amigo.buscarMaiorUtilizador();
    }

    /**
     * Obtém a quantidade total de amigos cadastrados.
     */
    public static int quantidadeAmigos() throws ExceptionDAO {
        return Amigo.quantidadeAmigos();
    }
}