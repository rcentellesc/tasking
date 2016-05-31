package es.rcentell.tasking.core.services.exceptions.NotFoundException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ProyectoNotFoundException extends RuntimeException {
    public ProyectoNotFoundException() {
        super();
    }

    public ProyectoNotFoundException(String message) {
        super(message);
    }

    public ProyectoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProyectoNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProyectoNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
