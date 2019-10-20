package arsw.bloodymoney.exceptions;

/**
 * Exception Class PersistenceException that defines
 * all the exceptions of the project
 * @author Pedro Mayorga
 * @version 1.0
 * @since 2019-09-23
 */
public class ProjectException extends Exception{

    public static final String EXCEPTIONS = "";
    
    /**
     * Creates a new instance of <code>InitiativeBankException</code> without
     * detail message.
     */
    public ProjectException() {
    }
    
    /**
     * Constructs an instance of <code>PersistenceException</code> with the
     * specified detail message.     *
     * @param message the detail message.
     */
    public ProjectException(String message) {
        super(message);
    }
    
    public ProjectException(Throwable error) {
        super(error);
    }
    
    public ProjectException(String message, Throwable error){
        super(message, error);
    }
    
    public ProjectException(String message, ProjectException exception) {
        super(message);
    }
    
}


