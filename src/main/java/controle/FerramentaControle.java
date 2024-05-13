package controle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import dao.ExceptionDAO;
import modelo.Ferramenta;
import util.TextUtil;

public class FerramentaControle {

    public static void checkModelo(Ferramenta ferramenta) throws ExceptionDAO {
        Objects.requireNonNull(ferramenta);
        if (!TextUtil.isValidText(ferramenta.getNome())) {
            throw new ExceptionDAO("Nome da ferramenta inválido!");
        }
        if (!TextUtil.isValidText(ferramenta.getMarca())) {
            throw new ExceptionDAO("Nome da ferramenta inválido!");
        }
    }

    public static Optional<Ferramenta> buscar(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id);
        return Ferramenta.buscar(id);
    }

    public static ArrayList<Ferramenta> buscarTudo() throws ExceptionDAO {
        return Ferramenta.buscarTudo();
    }

    public static void cadastrar(String nome, String marca, Double preco) throws ExceptionDAO {
        Ferramenta ferramenta = new Ferramenta(nome, marca, preco);
        cadastrar(ferramenta);
    }

    public static void cadastrar(Ferramenta ferramenta) throws ExceptionDAO {
        checkModelo(ferramenta);
        Ferramenta.cadastrar(ferramenta);
    }

    public static void alterar(Ferramenta ferramenta) throws ExceptionDAO {
        checkModelo(ferramenta);
        Integer id = ferramenta.getId();
        Objects.requireNonNull(id, "O Id do modelo 'Ferramenta' não pode ser nulo!");
        int rowsAffected = Ferramenta.alterar(ferramenta);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("A ferramenta '" + id + "' não foi alterada pois não existe!");
        }
    }

    public static void excluir(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, "O Id do modelo 'Ferramenta' não pode ser nulo!");
        int rowsAffected = Ferramenta.excluir(id);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("A ferramenta '" + id + "' não foi excluída pois não existe!");
        }
    }

    public static void excluir(Ferramenta ferramenta) throws ExceptionDAO {
        excluir(ferramenta.getId());
    }

    public static Double getCustoTotal() throws ExceptionDAO {
        ArrayList<Ferramenta> ferramentas = buscarTudo();
        Double soma = 0.0;
        for (Ferramenta ferramenta : ferramentas) {
            soma += ferramenta.getPreco();
        }
        return soma;
    }
}
