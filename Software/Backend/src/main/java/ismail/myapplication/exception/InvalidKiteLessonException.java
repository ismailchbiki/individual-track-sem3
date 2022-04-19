package ismail.myapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidKiteLessonException extends ResponseStatusException {
    public InvalidKiteLessonException(String errorCode) {
        super(HttpStatus.BAD_REQUEST, errorCode);
    }
}


