package edu.eci.cvds.Labtools.repository;


import edu.eci.cvds.Labtools.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MongoBookingRepository extends MongoRepository<Booking, String> {

}
