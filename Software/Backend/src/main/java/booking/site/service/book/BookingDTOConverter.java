package booking.site.service.book;

import booking.site.dto.book.BookingDTO;
import booking.site.repository.entity.booking.Booking;

public class BookingDTOConverter {

    private BookingDTOConverter() {
    }

    public static BookingDTO convertEntityToDTO(Booking booking) {
        return BookingDTO.builder()
                .id(booking.getId())
                .firstName(booking.getFirstName())
                .lastName(booking.getLastName())
                .email(booking.getEmail())
                .lessonType(booking.getLessonType())
                .hours(booking.getHours())
                .location(booking.getLocation())
                .date(booking.getDate())
                .time(booking.getTime())
                .dateOfBooking(booking.getDateOfBooking())
                .build();
    }
}
