package booking.site.service.book;

import booking.site.dto.book.BookingDTO;
import booking.site.exception.InvalidBookingException;
import booking.site.exception.ResourceNotFoundException;
import booking.site.repository.BookingRepository;
import booking.site.repository.entity.booking.Booking;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor/*(onConstructor = @__(@Lazy))*/
public class BookingUseCaseImpl implements BookingUseCase {

    private final BookingRepository bookingRepository;

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking bookingEntity = Booking.builder()
                .firstName(bookingDTO.getFirstName())
                .lastName(bookingDTO.getLastName())
                .email(bookingDTO.getEmail())
                .lessonType(bookingDTO.getLessonType())
                .hours(bookingDTO.getHours())
                .location(bookingDTO.getLocation())
                .date(bookingDTO.getDate())
                .time(bookingDTO.getTime())
                .dateOfBooking(bookingDTO.getDateOfBooking())
                .build();

        Booking savedBooking = bookingRepository.save(bookingEntity);

        return BookingDTO.builder()
                .id(savedBooking.getId())
                .build();
    }

    @Override
    public void updateBooking(String id, BookingDTO bookingDTO) {
        Optional<Booking> existingOptionalBooking = bookingRepository.findById(id);
        if (existingOptionalBooking.isEmpty()) {
            throw new InvalidBookingException("BOOKING_ID_INVALID");
        }

        Booking booking = existingOptionalBooking.get();
        updateFields(bookingDTO, booking);
    }

    private void updateFields(BookingDTO bookingDTO, Booking booking) {

        booking.setFirstName(bookingDTO.getFirstName());
        booking.setLastName(bookingDTO.getLastName());
        booking.setEmail(bookingDTO.getEmail());
        booking.setDateOfBooking(bookingDTO.getDateOfBooking());
        booking.setDate(bookingDTO.getDate());
        booking.setTime(bookingDTO.getTime());
        booking.setLocation(bookingDTO.getLocation());
        booking.setHours(bookingDTO.getHours());
        booking.setLessonType(bookingDTO.getLessonType());

        bookingRepository.save(booking);
    }


    @Override
    public void deleteBooking(String id) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking with this id:" + id + " doesn't exist."));
        bookingRepository.deleteById(existingBooking.getId());
    }

    @Override
    public BookingDTO getBookingById(String id) {
        BookingDTO bookingDTO = new BookingDTO();
        log.info("Fetching booking by id {}", id);
        Booking booking = bookingRepository.findById(id).orElse(null);

        if (booking != null) {
            bookingDTO = BookingDTO.builder()
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
        return bookingDTO;
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        log.info("Fetching all bookings");
        return bookingRepository.findAll()
                .stream()
                .map(BookingDTOConverter::convertEntityToDTO)
                .toList();
    }
}

