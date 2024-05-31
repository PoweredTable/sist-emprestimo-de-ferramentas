package dao;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Interface que define os métodos básicos de um DAO (Data Access Object).
 *
 * @param <T> O tipo de objeto que o DAO manipula.
 */
public interface DAO<T> {

    /**
     * Busca um objeto pelo ID.
     *
     * @param id ID do objeto a ser buscado.
     * @return Optional contendo o objeto encontrado ou vazio se não encontrado.
     * @throws ExceptionDAO Exceção lançada pela camada DAO.
     */
    Optional<T> buscar(Integer id) throws ExceptionDAO;

    /**
     * Busca todos os objetos.
     *
     * @return Lista de todos os objetos.
     * @throws ExceptionDAO Exceção lançada pela camada DAO.
     */
    ArrayList<T> buscarTudo() throws ExceptionDAO;

    /**
     * Cadastra um novo objeto.
     *
     * @param t Objeto a ser cadastrado.
     * @throws ExceptionDAO Exceção lançada pela camada DAO.
     */
    void cadastrar(T t) throws ExceptionDAO;

    /**
     * Altera um objeto existente.
     *
     * @param t Objeto a ser alterado.
     * @return Número de linhas afetadas.
     * @throws ExceptionDAO Exceção lançada pela camada DAO.
     */
    int alterar(T t) throws ExceptionDAO;

    /**
     * Exclui um objeto pelo ID.
     *
     * @param id ID do objeto a ser excluído.
     * @return Número de linhas afetadas.
     * @throws ExceptionDAO Exceção lançada pela camada DAO.
     */
    int excluir(Integer id) throws ExceptionDAO;
}