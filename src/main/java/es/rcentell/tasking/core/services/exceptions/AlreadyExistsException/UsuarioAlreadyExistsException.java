package es.rcentell.tasking.core.services.exceptions.AlreadyExistsException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class UsuarioAlreadyExistsException extends RuntimeException {
    public UsuarioAlreadyExistsException() {
        super();
    }

    public UsuarioAlreadyExistsException(String message) {
        super(message);
    }

    public UsuarioAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsuarioAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected UsuarioAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
