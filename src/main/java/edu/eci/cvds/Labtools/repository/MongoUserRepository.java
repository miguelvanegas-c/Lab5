package edu.eci.cvds.Labtools.repository;

import edu.eci.cvds.Labtools.model.Booking;
import edu.eci.cvds.Labtools.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MongoUserRepository extends MongoRepository<User, String> {


    Optional<User> findByEmail(String email);

    User findByName(String name);

}