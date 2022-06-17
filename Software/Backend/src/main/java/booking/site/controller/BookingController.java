package booking.site.controller;

import booking.site.dto.book.BookingDTO;
import booking.site.service.book.BookingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingUseCase bookingUseCase;

    @RequestMapping("/all-bookings")
    public ResponseEntity<Iterable<BookingDTO>> getAllBookings() {
        return ResponseEntity.ok(bookingUseCase.getAllBookings());
    }

    @RequestMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable String id) {

        BookingDTO bookingDTO = bookingUseCase.getBookingById(id);

        if (!ObjectUtils.isEmpty(bookingDTO)) {
            return ResponseEntity.ok().body(bookingDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @RequestMapping("/book-kite-lesson")
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {

        Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String dateOfBooking = formatter.format(new Date());

        bookingDTO.setDateOfBooking(dateOfBooking);

        BookingDTO responseBooking = bookingUseCase.createBooking(bookingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBooking);
    }

    @RequestMapping("/update-booking/{id}")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable String id, @RequestBody BookingDTO bookingDTO) {
        bookingDTO.setId(id);
        bookingUseCase.createBooking(bookingDTO);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping("/cancel-booking/{id}")
    public ResponseEntity<BookingDTO> deleteBooking(@PathVariable String id) {
        bookingUseCase.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
