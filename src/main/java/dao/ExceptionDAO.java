package dao;

/**
 * Classe ExceptionDAO
 */
public class ExceptionDAO extends Exception {
    
    /**
     * Construtor da classe ExceptionDAO
     */
    public ExceptionDAO(String mensagem) {
        super(mensagem);
    }
}