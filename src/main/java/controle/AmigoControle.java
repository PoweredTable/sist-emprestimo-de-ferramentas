package controle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import dao.ExceptionDAO;
import modelo.Amigo;
import util.TextUtil;

public class AmigoControle {

    public static void checkModelo(Amigo amigo) throws ExceptionDAO {
        Objects.requireNonNull(amigo);
        if (!TextUtil.isValidText(amigo.getNome())) {
            throw new ExceptionDAO("Nome do amigo inválido!");
        }
        if (!TextUtil.isValidText(amigo.getApelido())) {
            throw new ExceptionDAO("Apelido do amigo inválido!");
        }
        if (!TextUtil.isValidText(amigo.getTelefone())) {
            throw new ExceptionDAO("Telefone do amigo inválido!");
        }
    }

    public static Optional<Amigo> buscar(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, "O Id do modelo 'Amigo' não pode ser nulo!");
        return Amigo.buscar(id);
    }

    public static ArrayList<Amigo> buscarTudo() throws ExceptionDAO {
        return Amigo.buscarTudo();
    }

    public static void cadastrar(String nome, String apelido, String telefone) throws ExceptionDAO {
        Amigo amigo = new Amigo(nome, apelido, telefone);
        cadastrar(amigo);
    }

    public static void cadastrar(Amigo amigo) throws ExceptionDAO {
        checkModelo(amigo);
        Amigo.cadastrar(amigo);
    }

    public static void alterar(Amigo amigo) throws ExceptionDAO {
        checkModelo(amigo);
        Integer id = amigo.getId();
        Objects.requireNonNull(id, "O Id do modelo 'Amigo' não pode ser nulo!");
        int rowsAffected = Amigo.alterar(amigo);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("O amigo '" + id + "' não foi excluído pois não existe!");
        }
    }

    public static void excluir(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, "O Id do modelo 'Amigo' não pode ser nulo!");
        int rowsAffected = Amigo.excluir(id);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("O amigo '" + id + "' não foi excluído pois não existe!");
        }
    }

    public static void excluir(Amigo amigo) throws ExceptionDAO {
        excluir(amigo.getId());
    }

    public static boolean amigoPossuiEmprestimoAtivo(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, "O Id do modelo 'Amigo' não pode ser nulo!");
        return Amigo.amigoPossuiEmprestimoAtivo(id);
    }
}
