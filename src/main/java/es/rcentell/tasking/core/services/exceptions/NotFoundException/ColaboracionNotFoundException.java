package es.rcentell.tasking.core.services.exceptions.NotFoundException;

/**
 * Created by Rcentell on 30/05/2016.
 */
public class ColaboracionNotFoundException extends RuntimeException {
    public ColaboracionNotFoundException() {
        super();
    }

    public ColaboracionNotFoundException(String message) {
        super(message);
    }

    public ColaboracionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ColaboracionNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ColaboracionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
