package dao;

/**
 * Classe ExceptionDAO
 * Esta classe representa exceções específicas relacionadas ao DAO (Data Access Object).
 * 
 * @autor caeta
 */
public class ExceptionDAO extends Exception {
    
    /**
     * Construtor da classe ExceptionDAO
     * 
     * @param mensagem A mensagem de erro associada à exceção
     */
    public ExceptionDAO(String mensagem) {
        super(mensagem);
    }
}