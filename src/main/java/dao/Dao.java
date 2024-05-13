package dao;

import java.util.ArrayList;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> buscar(Integer id) throws ExceptionDAO;

    ArrayList<T> buscarTudo() throws ExceptionDAO;

    void cadastrar(T t) throws ExceptionDAO;

    int alterar(T t) throws ExceptionDAO;

    int excluir(Integer id) throws ExceptionDAO;
}