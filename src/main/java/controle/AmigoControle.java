package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.ExceptionDAO;
import modelo.AmigoModelo;
import util.TextUtil;

public class AmigoControle {

    public static Optional<AmigoModelo> buscar(Integer id) throws ExceptionDAO {
        return AmigoModelo.buscar(id);
    }

    public static ArrayList<AmigoModelo> buscarTudo() throws ExceptionDAO {
        return AmigoModelo.buscarTudo();
    }

    public static boolean cadastrar(String nome, String apelido, String telefone) throws ExceptionDAO {
        if (!TextUtil.isValidTextList(List.of(nome, apelido, telefone))) {
            return false;
        }
        AmigoModelo amigo = new AmigoModelo(nome, apelido, telefone);
        AmigoModelo.cadastrar(amigo);
        return true;
    }
}
