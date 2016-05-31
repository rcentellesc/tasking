package es.rcentell.tasking.core.services.exceptions.AlreadyExistsException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class SubtareaAlreadyExistsException extends RuntimeException {
    public SubtareaAlreadyExistsException() {
        super();
    }

    public SubtareaAlreadyExistsException(String message) {
        super(message);
    }

    public SubtareaAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubtareaAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected SubtareaAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
