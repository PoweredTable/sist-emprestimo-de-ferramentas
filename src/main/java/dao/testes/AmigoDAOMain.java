package dao.testes;

import dao.AmigoDAO;
import dao.ExceptionDAO;
import modelo.Amigo;

import java.util.ArrayList;
import java.util.Optional;

public class AmigoDAOMain {
    public static void main(String[] args) {
        AmigoDAO amigoDAO = AmigoDAO.getInstance();

        try {
            // Testar cadastrar
            Amigo novoAmigo = new Amigo();
            novoAmigo.setNome("João Silva");
            novoAmigo.setApelido("João");
            novoAmigo.setTelefone("123456789");
            amigoDAO.cadastrar(novoAmigo);
            System.out.println("Amigo cadastrado com sucesso!");

            // Testar buscar
            Optional<Amigo> amigoBuscado = amigoDAO.buscar(novoAmigo.getId());
            if (amigoBuscado.isPresent()) {
                System.out.println("Amigo encontrado: " + amigoBuscado.get().getNome());
            } else {
                System.out.println("Amigo não encontrado.");
            }

            // Testar buscar tudo
            ArrayList<Amigo> todosAmigos = amigoDAO.buscarTudo();
            System.out.println("Lista de todos os amigos:");
            for (Amigo amigo : todosAmigos) {
                System.out.println(amigo.getNome());
            }

            // Testar alterar
            if (amigoBuscado.isPresent()) {
                Amigo amigoParaAlterar = amigoBuscado.get();
                amigoParaAlterar.setNome("João Alterado");
                amigoParaAlterar.setApelido("Joãozinho");
                amigoParaAlterar.setTelefone("987654321");
                int linhasAlteradas = amigoDAO.alterar(amigoParaAlterar);
                if (linhasAlteradas > 0) {
                    System.out.println("Amigo alterado com sucesso!");
                } else {
                    System.out.println("Falha ao alterar amigo.");
                }
            }

            // Testar excluir
            int idParaExcluir = 2; // Certifique-se de que este ID exista para o teste
            int linhasExcluidas = amigoDAO.excluir(idParaExcluir);
            if (linhasExcluidas > 0) {
                System.out.println("Amigo excluído com sucesso!");
            } else {
                System.out.println("Falha ao excluir amigo ou amigo não encontrado.");
            }

            // Testar se amigo possui empréstimo ativo
            boolean possuiEmprestimoAtivo = amigoDAO.amigoPossuiEmprestimoAtivo(1);
            System.out.println("Amigo com ID 1 possui empréstimo ativo? " + (possuiEmprestimoAtivo ? "Sim" : "Não"));

            // Testar buscar maior utilizador
            Optional<Amigo> maiorUtilizador = amigoDAO.buscarMaiorUtilizador();
            if (maiorUtilizador.isPresent()) {
                System.out.println("Maior utilizador: " + maiorUtilizador.get().getNome());
            } else {
                System.out.println("Nenhum maior utilizador encontrado.");
            }

            // Testar buscar por nome
            ArrayList<Amigo> amigosPorNome = amigoDAO.buscarNome("João");
            System.out.println("Amigos encontrados por nome:");
            for (Amigo amigo : amigosPorNome) {
                System.out.println(amigo.getNome());
            }

        } catch (ExceptionDAO e) {
            System.err.println("Erro ao executar operação: " + e.getMessage());
        }
    }
}
