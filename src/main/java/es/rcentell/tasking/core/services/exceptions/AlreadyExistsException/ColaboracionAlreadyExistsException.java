package es.rcentell.tasking.core.services.exceptions.AlreadyExistsException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ColaboracionAlreadyExistsException extends RuntimeException {
    public ColaboracionAlreadyExistsException() {
        super();
    }

    public ColaboracionAlreadyExistsException(String message) {
        super(message);
    }

    public ColaboracionAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ColaboracionAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected ColaboracionAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
