package es.rcentell.tasking.core.services.exceptions.NotFoundException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class SubtareaNotFoundException extends RuntimeException {
    public SubtareaNotFoundException() {
        super();
    }

    public SubtareaNotFoundException(String message) {
        super(message);
    }

    public SubtareaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubtareaNotFoundException(Throwable cause) {
        super(cause);
    }

    protected SubtareaNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
