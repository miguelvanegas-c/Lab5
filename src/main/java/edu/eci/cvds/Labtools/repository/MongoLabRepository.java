package edu.eci.cvds.Labtools.repository;

import edu.eci.cvds.Labtools.model.Lab;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MongoLabRepository extends MongoRepository<Lab, String> {


    Lab findByName(String name);
}
