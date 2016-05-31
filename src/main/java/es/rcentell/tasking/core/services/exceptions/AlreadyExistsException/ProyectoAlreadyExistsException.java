package es.rcentell.tasking.core.services.exceptions.AlreadyExistsException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ProyectoAlreadyExistsException extends RuntimeException {
    public ProyectoAlreadyExistsException() {
        super();
    }

    public ProyectoAlreadyExistsException(String message) {
        super(message);
    }

    public ProyectoAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProyectoAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected ProyectoAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
