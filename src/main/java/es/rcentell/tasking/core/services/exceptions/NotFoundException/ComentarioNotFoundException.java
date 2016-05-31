package es.rcentell.tasking.core.services.exceptions.NotFoundException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ComentarioNotFoundException extends RuntimeException {
    public ComentarioNotFoundException() {
        super();
    }

    public ComentarioNotFoundException(String message) {
        super(message);
    }

    public ComentarioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComentarioNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ComentarioNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
