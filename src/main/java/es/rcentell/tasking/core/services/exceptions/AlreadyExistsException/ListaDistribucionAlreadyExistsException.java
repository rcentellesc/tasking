package es.rcentell.tasking.core.services.exceptions.AlreadyExistsException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ListaDistribucionAlreadyExistsException extends RuntimeException {
    public ListaDistribucionAlreadyExistsException() {
        super();
    }

    public ListaDistribucionAlreadyExistsException(String message) {
        super(message);
    }

    public ListaDistribucionAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListaDistribucionAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected ListaDistribucionAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
