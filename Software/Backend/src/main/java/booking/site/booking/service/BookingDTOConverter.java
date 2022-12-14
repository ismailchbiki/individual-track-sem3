package booking.site.booking.service;

import booking.site.annotation.Generated;
import booking.site.booking.dto.BookingDTO;
import booking.site.booking.entity.Booking;

@Generated
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
