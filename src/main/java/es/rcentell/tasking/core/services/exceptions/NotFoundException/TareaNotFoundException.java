package es.rcentell.tasking.core.services.exceptions.NotFoundException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class TareaNotFoundException extends RuntimeException {
    public TareaNotFoundException() {
        super();
    }

    public TareaNotFoundException(String message) {
        super(message);
    }

    public TareaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TareaNotFoundException(Throwable cause) {
        super(cause);
    }

    protected TareaNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
