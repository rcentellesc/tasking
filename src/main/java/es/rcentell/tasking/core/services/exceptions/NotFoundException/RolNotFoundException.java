package es.rcentell.tasking.core.services.exceptions.NotFoundException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class RolNotFoundException extends RuntimeException {
    public RolNotFoundException() {
        super();
    }

    public RolNotFoundException(String message) {
        super(message);
    }

    public RolNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RolNotFoundException(Throwable cause) {
        super(cause);
    }

    protected RolNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
