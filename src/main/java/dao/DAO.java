package dao;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Interface que define os métodos básicos de um DAO (Data Access Object).
 */
public interface DAO<T> {

    /**
     * Busca um objeto pelo ID.
     */
    Optional<T> buscar(Integer id) throws ExceptionDAO;

    /**
     * Busca todos os objetos.
     */
    ArrayList<T> buscarTudo() throws ExceptionDAO;

    /**
     * Cadastra um novo objeto.
     */
    void cadastrar(T t) throws ExceptionDAO;

    /**
     * Altera um objeto existente.
     */
    int alterar(T t) throws ExceptionDAO;

    /**
     * Exclui um objeto pelo ID.
     */
    int excluir(Integer id) throws ExceptionDAO;
}