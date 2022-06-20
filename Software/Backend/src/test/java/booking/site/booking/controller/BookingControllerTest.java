package booking.site.booking.controller;

import booking.site.booking.dto.BookingDTO;
import booking.site.booking.service.BookingUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookingController.class)
class BookingControllerTest {

    @MockBean
    BookingUseCase bookingUseCase;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getBooking_shouldReturn200WithBooking_whenFound() throws Exception {
        BookingDTO bookingDTO = BookingDTO.builder()
                .id("12")
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


        when(bookingUseCase.getBookingById("12")).thenReturn(bookingDTO);

        mockMvc.perform(get("/booking/12"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                        {"id":"12","firstName":"Ismail","lastName":"Chbiki","email":"ismail@email.com", "lessonType":"prv","hours":2,"location":"The Hague","date":"2020-01-01","time":"12:00","dateOfBooking":"2020-01-01"}"""));
        verify(bookingUseCase).getBookingById("12");
    }

    @Test
    void getBooking_shouldReturn404Error_whenNotFound() throws Exception {

        BookingDTO bookingDTO = BookingDTO.builder().build();
        when(bookingUseCase.getBookingById("100")).thenReturn(bookingDTO);

        mockMvc.perform(get("/booking/100"))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(bookingUseCase).getBookingById("100");
    }

    @Test
    void getAllBookings_shouldReturn200WithAllBookingsList_WhenNoFilterProvided() throws Exception {
        BookingDTO bookingDTO1 = BookingDTO.builder()
                .id("12")
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

        BookingDTO bookingDTO2 = BookingDTO.builder()
                .id("13")
                .firstName("Walid")
                .lastName("Elabdi")
                .email("walid@email.com")
                .lessonType("prv")
                .hours(2)
                .location("Safi")
                .date("2020-01-01")
                .time("12:00")
                .dateOfBooking("2021-01-01")
                .build();

        List<BookingDTO> bookings = List.of(bookingDTO1, bookingDTO2);

        when(bookingUseCase.getAllBookings()).thenReturn(bookings);

        mockMvc.perform(get("/booking/all-bookings"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                                [
                                {"id":"12","firstName":"Ismail","lastName":"Chbiki","email":"ismail@email.com", "lessonType":"prv","hours":2,"location":"The Hague","date":"2020-01-01","time":"12:00","dateOfBooking":"2020-01-01"},
                                {"id":"13","firstName":"Walid","lastName":"Elabdi","email":"walid@email.com", "lessonType":"prv","hours":2,"location":"Safi","date":"2020-01-01","time":"12:00","dateOfBooking":"2021-01-01"}
                                ]
                            
                        """));

        verify(bookingUseCase).getAllBookings();
    }

//    @Test
//    void createBooking_shouldReturn201_whenRequestIsValid() throws Exception {
//        BookingDTO bookingDTO = BookingDTO.builder()
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
//        when(bookingUseCase.createBooking(bookingDTO))
//                .thenReturn(BookingDTO.builder()
//                        .id("30")
//                        .build());
//
//        mockMvc.perform(post("/booking/book-kite-lesson")
//                        .contentType(APPLICATION_JSON_VALUE)
//                        .content("""
//                                {"firstName":"Ismail","lastName":"Chbiki","email":"ismail@email.com", "lessonType":"prv","hours":2,"location":"The Hague","date":"2020-01-01","time":"12:00","dateOfBooking":"2020-01-01"}
//                                """))
//                .andDo(print())
//                .andExpect(status().isCreated())
//                .andExpect(content().json("""
//                            { "id":  "30"}
//                        """));
//
//        verify(bookingUseCase).createBooking(bookingDTO);
//    }
}