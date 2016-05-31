package es.rcentell.tasking.core.services.exceptions.AlreadyExistsException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ComentarioAlreadyExistsException extends RuntimeException {
    public ComentarioAlreadyExistsException() {
        super();
    }

    public ComentarioAlreadyExistsException(String message) {
        super(message);
    }

    public ComentarioAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComentarioAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected ComentarioAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
