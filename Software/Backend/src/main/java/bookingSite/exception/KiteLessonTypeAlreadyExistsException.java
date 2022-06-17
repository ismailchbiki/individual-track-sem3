package bookingSite.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class KiteLessonTypeAlreadyExistsException extends ResponseStatusException {
    public KiteLessonTypeAlreadyExistsException() {
        super(HttpStatus.BAD_REQUEST, "KITE_LESSON_TYPE_ALREADY_EXISTS");
    }
}