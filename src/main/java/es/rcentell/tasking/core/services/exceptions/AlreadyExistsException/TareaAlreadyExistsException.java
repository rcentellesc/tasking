package es.rcentell.tasking.core.services.exceptions.AlreadyExistsException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class TareaAlreadyExistsException extends RuntimeException {
    public TareaAlreadyExistsException() {
        super();
    }

    public TareaAlreadyExistsException(String message) {
        super(message);
    }

    public TareaAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TareaAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected TareaAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
