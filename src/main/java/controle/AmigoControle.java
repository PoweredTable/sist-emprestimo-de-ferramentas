package controle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import dao.ExceptionDAO;
import modelo.Amigo;
import util.TextUtil;

public class AmigoControle {

    private static final String erroMsgModeloNulo = "O objeto 'amigo' não pode ser nulo!";
    private static final String erroMsgIdNulo = "O Id do objeto 'amigo' não pode ser nulo!";

    private AmigoControle() {

    }

    public static Optional<Amigo> buscar(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroMsgIdNulo);
        return Amigo.buscar(id);
    }

    public static ArrayList<Amigo> buscarTudo() throws ExceptionDAO {
        return Amigo.buscarTudo();
    }

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

    public static void cadastrar(String nome, String apelido, String telefone) throws ExceptionDAO {
        Amigo amigo = new Amigo(nome, apelido, telefone);
        cadastrar(amigo);
    }

    public static void alterar(Amigo amigo) throws ExceptionDAO {
        Objects.requireNonNull(amigo, erroMsgModeloNulo);
        Integer id = amigo.getId();
        Objects.requireNonNull(id, erroMsgIdNulo);
        int rowsAffected = Amigo.alterar(amigo);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("O amigo '" + id + "' não foi excluído pois não existe!");
        }
    }

    public static void excluir(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroMsgIdNulo);
        int rowsAffected = Amigo.excluir(id);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("O amigo '" + id + "' não foi excluído pois não existe!");
        }
    }

    public static void excluir(Amigo amigo) throws ExceptionDAO {
        Objects.requireNonNull(amigo, erroMsgModeloNulo);
        excluir(amigo.getId());
    }

    public static boolean amigoPossuiEmprestimoAtivo(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroMsgIdNulo);
        return Amigo.amigoPossuiEmprestimoAtivo(id);
    }

    public static boolean amigoPossuiEmprestimoAtivo(Amigo amigo) throws ExceptionDAO {
        Objects.requireNonNull(amigo, erroMsgModeloNulo);
        return amigoPossuiEmprestimoAtivo(amigo.getId());
    }

    public static ArrayList<Amigo> buscarNome(String nome) throws ExceptionDAO {
        Objects.requireNonNull(nome, "O nome do amigo não pode ser nulo!");
        return Amigo.buscarNome(nome);
    }

    public static Optional<Amigo> buscarMaiorUtilizador() throws ExceptionDAO {
        return Amigo.buscarMaiorUtilizador();
    }

    public static int quantidadeAmigos() throws ExceptionDAO {
        return Amigo.quantidadeAmigos();
    }
}
