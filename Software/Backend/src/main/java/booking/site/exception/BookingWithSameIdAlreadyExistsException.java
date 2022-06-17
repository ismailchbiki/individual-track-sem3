package booking.site.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BookingWithSameIdAlreadyExistsException extends ResponseStatusException {
    public BookingWithSameIdAlreadyExistsException() {
        super(HttpStatus.BAD_REQUEST, "BOOKING_WITH_SAME_ID_ALREADY_EXISTS");
    }
}
