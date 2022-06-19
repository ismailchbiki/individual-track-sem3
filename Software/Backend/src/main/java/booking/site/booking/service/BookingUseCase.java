package booking.site.booking.service;

import booking.site.booking.dto.BookingDTO;

import java.util.List;

public interface BookingUseCase {
    BookingDTO createBooking(BookingDTO booking);

    void updateBooking(String id, BookingDTO booking);

    void deleteBooking(String id);

    BookingDTO getBookingById(String id);

    List<BookingDTO> getAllBookings();
}
