package booking.site.service.booking;

import booking.site.dto.booking.BookingDTO;

import java.util.List;

public interface BookingUseCase {
    BookingDTO createBooking(BookingDTO booking);

    void updateBooking(String id, BookingDTO booking);

    void deleteBooking(String id);

    BookingDTO getBookingById(String id);

    List<BookingDTO> getAllBookings();
}
