package demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Olga on 03/11/2015.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EquipoException extends RuntimeException {
    public EquipoException(String error) {

        super(error);
    }
}
