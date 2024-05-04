package dao;

import java.util.ArrayList;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(Integer id) throws ExceptionDAO;

    ArrayList<T> getAll() throws ExceptionDAO;

    void create(T t) throws ExceptionDAO;

    void update(T t) throws ExceptionDAO;

    void delete(Integer id) throws ExceptionDAO;
}