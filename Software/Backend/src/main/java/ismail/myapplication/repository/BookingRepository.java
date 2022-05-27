package ismail.myapplication.repository;

import ismail.myapplication.repository.entity.booking.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
