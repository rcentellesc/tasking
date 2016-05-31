package es.rcentell.tasking.core.services.exceptions.AlreadyExistsException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class RolAlreadyExistsException extends RuntimeException {
    public RolAlreadyExistsException() {
        super();
    }

    public RolAlreadyExistsException(String message) {
        super(message);
    }

    public RolAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public RolAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected RolAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
