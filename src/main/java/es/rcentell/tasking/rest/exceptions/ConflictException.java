package es.rcentell.tasking.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Rcentell on 30/05/2016.
 */
@ResponseStatus(value= HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
    public ConflictException() {
    }

    public ConflictException(Throwable cause) {
        super(cause);
    }

}
