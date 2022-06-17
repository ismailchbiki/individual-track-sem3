package booking.site.repository;

import booking.site.repository.entity.booking.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
    boolean existsById(String id);
}
