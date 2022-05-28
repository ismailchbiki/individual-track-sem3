package ismail.myapplication.repository.entity.booking;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "booking")
public class Booking {
    @Id
    @Field(name = "Id")
    private String id;

    @Field(name = "First name")
    private String firstName;

    @Field(name = "Last name")
    private String lastName;

    @Field(name = "Email")
    private String email;

    @Field(name = "Lesson type")
    private String lessonType;

    @Field(name = "Hours")
    private Integer hours;

    @Field(name = "Location")
    private String location;

    @Field(name = "Date")
    private Date date;

    @Field(name = "Time")
    private Date time;

    @Field(name = "Date of booking")
    private Date dateOfBooking;

    public Booking(String firstName,
                   String lastName,
                   String email,
                   String lessonType,
                   Integer hours,
                   String location,
                   Date date,
                   Date time,
                   Date dateOfBooking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.lessonType = lessonType;
        this.hours = hours;
        this.location = location;
        this.date = date;
        this.time = time;
        this.dateOfBooking = dateOfBooking;
    }
}
