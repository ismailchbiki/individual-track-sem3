//package booking.site.booking.repository;
//
//import booking.site.booking.entity.Booking;
//import lombok.AllArgsConstructor;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import javax.persistence.EntityManager;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//@AllArgsConstructor
//class BookingRepositoryTest {
//
//    private EntityManager entityManager;
//
//    private BookingRepository bookingRepository;
//
//    @Test
//    void save_shouldSaveBookingWithAllFields() {
//        //create object
//        Booking booking = Booking.builder()
//                .firstName("Ismail")
//                .lastName("Chbiki")
//                .email("ismail@email.com")
//                .lessonType("prv")
//                .hours(2)
//                .location("The Hague")
//                .date("2020-01-01")
//                .time("12:00")
//                .dateOfBooking("2020-01-01")
//                .build();
//
//        //save object
//        Booking savedBooking = bookingRepository.save(booking);
//        //check object is saved
//        assertNotNull(savedBooking.getId());
//        //get object
//        savedBooking = entityManager.find(Booking.class, savedBooking.getId());
//        Booking expectedBooking = Booking.builder()
//                .id(savedBooking.getId())
//                .firstName(savedBooking.getFirstName())
//                .lastName(savedBooking.getLastName())
//                .email(savedBooking.getEmail())
//                .lessonType(savedBooking.getLessonType())
//                .hours(savedBooking.getHours())
//                .location(savedBooking.getLocation())
//                .date(savedBooking.getDate())
//                .time(savedBooking.getTime())
//                .dateOfBooking(savedBooking.getDateOfBooking())
//                .build();
//
//        //assert
//        assertThat(savedBooking)
//                .usingRecursiveComparison()
//                .ignoringExpectedNullFields()
//                .isEqualTo(expectedBooking);
//    }
//}