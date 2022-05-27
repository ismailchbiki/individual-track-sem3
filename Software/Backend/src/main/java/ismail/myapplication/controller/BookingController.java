package ismail.myapplication.controller;

import ismail.myapplication.repository.BookingRepository;
import ismail.myapplication.repository.entity.booking.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {
    final private BookingRepository bookingRepository;

    @RequestMapping("/all-bookings")
    public ResponseEntity<Iterable<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingRepository.findAll());
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable String id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @RequestMapping("/book-kite-lesson")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return ResponseEntity.ok(booking);
    }

    @RequestMapping("/update-booking/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable String id, @RequestBody Booking booking) {
        booking.setId(id);
        bookingRepository.save(booking);
        return ResponseEntity.ok(booking);
    }

    @RequestMapping("/cancel-booking/{id}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable String id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        bookingRepository.delete(booking);
        return ResponseEntity.ok(booking);
    }
}
