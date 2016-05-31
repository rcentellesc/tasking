package es.rcentell.tasking.core.services.exceptions.NotFoundException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ListaDistribucionNotFoundException extends RuntimeException {
    public ListaDistribucionNotFoundException() {
        super();
    }

    public ListaDistribucionNotFoundException(String message) {
        super(message);
    }

    public ListaDistribucionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListaDistribucionNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ListaDistribucionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
