package dao;

import java.util.ArrayList;
import java.util.Optional;

import modelo.FerramentaModelo;

public class FerramentaDAO implements Dao<FerramentaModelo> {

    public Optional<FerramentaModelo> get(Integer id) throws ExceptionDAO {
        return Optional.empty();
    }

    public ArrayList<FerramentaModelo> getAll() throws ExceptionDAO {
        return new ArrayList<>();
    }

    public void create(FerramentaModelo ferramenta) throws ExceptionDAO {

    }

    public void update(FerramentaModelo ferramenta) throws ExceptionDAO {

    }

    public void delete(Integer ferramenta) throws ExceptionDAO {

    }
}
