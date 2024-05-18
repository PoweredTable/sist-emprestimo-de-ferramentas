package controle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import dao.ExceptionDAO;
import modelo.Ferramenta;
import util.TextUtil;

public class FerramentaControle {

    private static final String erroModeloNulo = "O objeto 'ferramenta' não pode ser nulo!";
    private static final String erroIdNulo = "O Id do objeto 'ferramenta' não pode ser nulo!";

    private FerramentaControle() {

    }

    public static Optional<Ferramenta> buscar(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroIdNulo);
        return Ferramenta.buscar(id);
    }

    public static ArrayList<Ferramenta> buscarTudo() throws ExceptionDAO {
        return Ferramenta.buscarTudo();
    }

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

    public static void cadastrar(String nome, String marca, Double preco) throws ExceptionDAO {
        Ferramenta ferramenta = new Ferramenta(nome, marca, preco);
        cadastrar(ferramenta);
    }

    public static void alterar(Ferramenta ferramenta) throws ExceptionDAO {
        Objects.requireNonNull(ferramenta, erroModeloNulo);
        Integer id = ferramenta.getId();
        Objects.requireNonNull(id, erroIdNulo);
        int rowsAffected = Ferramenta.alterar(ferramenta);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("A ferramenta '" + id + "' não foi alterada pois não existe!");
        }
    }

    public static void excluir(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroIdNulo);
        int rowsAffected = Ferramenta.excluir(id);
        if (rowsAffected == 0) {
            throw new ExceptionDAO("A ferramenta '" + id + "' não foi excluída pois não existe!");
        }
    }

    public static void excluir(Ferramenta ferramenta) throws ExceptionDAO {
        Objects.requireNonNull(ferramenta, erroModeloNulo);
        excluir(ferramenta.getId());
    }

    public static boolean ferramentaEmprestada(Integer id) throws ExceptionDAO {
        Objects.requireNonNull(id, erroIdNulo);
        return Ferramenta.ferramentaEmprestada(id);
    }

    public static boolean ferramentaEmprestada(Ferramenta ferramenta) throws ExceptionDAO {
        Objects.requireNonNull(ferramenta, erroModeloNulo);
        return ferramentaEmprestada(ferramenta.getId());
    }

    public static ArrayList<Ferramenta> buscarFerramentasDisponiveis() throws ExceptionDAO {
        return Ferramenta.buscarFerramentasDisponiveis();
    }

    public static ArrayList<Ferramenta> buscarNome(String nome) throws ExceptionDAO, NullPointerException {
        Objects.requireNonNull(nome, "O nome da ferramenta não pode ser nulo!");
        return Ferramenta.buscarNome(nome);
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