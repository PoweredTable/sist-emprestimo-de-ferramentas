package controle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import dao.ExceptionDAO;
import modelo.Amigo;
import util.TextUtil;

public class AmigoControle {

    public static Optional<Amigo> buscar(Integer id) throws ExceptionDAO {
        return Amigo.buscar(id);
    }

    public static ArrayList<Amigo> buscarTudo() throws ExceptionDAO {
        return Amigo.buscarTudo();
    }

    public static boolean cadastrar(String nome, String apelido, String telefone) throws ExceptionDAO {
        if (!TextUtil.isValidTextList(List.of(nome, apelido, telefone))) {
            return false;
        }
        Amigo amigo = new Amigo(nome, apelido, telefone);
        Amigo.cadastrar(amigo);
        return true;
    }

    public static boolean amigoPossuiEmprestimoAtivo(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, "O Id do modelo 'Amigo' não pode ser nulo!");
        return Amigo.amigoPossuiEmprestimoAtivo(id);
    }
}
