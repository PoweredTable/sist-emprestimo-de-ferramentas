package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.ExceptionDAO;
import modelo.Ferramenta;
import util.TextUtil;

public class FerramentaControle {

    public static Optional<Ferramenta> buscar(Integer id) throws ExceptionDAO {
        return Ferramenta.buscar(id);
    }

    public static ArrayList<Ferramenta> buscarTudo() throws ExceptionDAO {
        return Ferramenta.buscarTudo();
    }

    public static boolean cadastrar(String nome, String marca, Double preco) throws ExceptionDAO {
        if (!TextUtil.isValidTextList(List.of(nome, marca))) {
            return false;
        }
        Ferramenta ferramenta = new Ferramenta(nome, marca, preco);
        Ferramenta.cadastrar(ferramenta);
        return true;
    }
}
