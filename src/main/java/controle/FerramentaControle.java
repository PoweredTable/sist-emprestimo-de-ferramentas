package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.ExceptionDAO;
import modelo.FerramentaModelo;
import util.TextUtil;

public class FerramentaControle {

    public static Optional<FerramentaModelo> buscar(Integer id) throws ExceptionDAO {
        return FerramentaModelo.buscar(id);
    }

    public static ArrayList<FerramentaModelo> buscarTudo() throws ExceptionDAO {
        return FerramentaModelo.buscarTudo();
    }

    public static boolean cadastrar(String nome, String marca, Double preco) throws ExceptionDAO {
        if (!TextUtil.isValidTextList(List.of(nome, marca))) {
            return false;
        }
        FerramentaModelo ferramenta = new FerramentaModelo(nome, marca, preco);
        FerramentaModelo.cadastrar(ferramenta);
        return true;
    }
}
