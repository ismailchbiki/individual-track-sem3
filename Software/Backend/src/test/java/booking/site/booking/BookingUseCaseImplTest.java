package booking.site.booking;

import booking.site.booking.dto.BookingDTO;
import booking.site.booking.entity.Booking;
import booking.site.booking.repository.BookingRepository;
import booking.site.booking.service.BookingUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingUseCaseImplTest {

    @Mock
    private BookingRepository bookingRepositoryMock;

    @InjectMocks
    private BookingUseCaseImpl bookingUseCaseImpl;

    @Test
    void shouldMakeNewBooking() {
        Booking expectedBookingToSaveEntity = Booking.builder()
                .firstName("Ismail")
                .lastName("Chbiki")
                .email("ismail@email.com")
                .lessonType("prv")
                .hours(2)
                .location("The Hague")
                .date("2020-01-01")
                .time("12:00")
                .dateOfBooking("2020-01-01")
                .build();

        Booking savedBooking = Booking.builder()
                .id("66")
                .firstName("Ismail")
                .lastName("Chbiki")
                .email("ismail@email.com")
                .lessonType("prv")
                .hours(2)
                .location("The Hague")
                .date("2020-01-01")
                .time("12:00")
                .dateOfBooking("2020-01-01")
                .build();

        when(bookingRepositoryMock.save(expectedBookingToSaveEntity)).thenReturn(savedBooking);

        BookingDTO bookingRRequestDTO = BookingDTO.builder()
                .firstName("Ismail")
                .lastName("Chbiki")
                .email("ismail@email.com")
                .lessonType("prv")
                .hours(2)
                .location("The Hague")
                .date("2020-01-01")
                .time("12:00")
                .dateOfBooking("2020-01-01")
                .build();

        BookingDTO actualResponse = bookingUseCaseImpl.createBooking(bookingRRequestDTO);

        BookingDTO expectedResponse = BookingDTO.builder()
                .id("66")
                .build();
        assertEquals(expectedResponse, actualResponse);
        verify(bookingRepositoryMock).save(expectedBookingToSaveEntity);
    }
}