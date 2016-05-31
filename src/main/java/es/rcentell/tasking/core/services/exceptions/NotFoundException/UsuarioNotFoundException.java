package es.rcentell.tasking.core.services.exceptions.NotFoundException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException() {
        super();
    }

    public UsuarioNotFoundException(String message) {
        super(message);
    }

    public UsuarioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsuarioNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UsuarioNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
