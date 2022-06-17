package bookingSite.service.booking;

import bookingSite.dto.booking.BookingDTO;
import bookingSite.repository.entity.booking.Booking;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BookingDTOConverter {
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
