package booking.site.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String lessonType;
    private Integer hours;
    private String location;
    private String date;
    private String time;
    private String dateOfBooking;
}
