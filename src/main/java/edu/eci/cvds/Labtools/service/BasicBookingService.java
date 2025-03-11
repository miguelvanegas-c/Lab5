package edu.eci.cvds.Labtools.service;

import edu.eci.cvds.Labtools.dto.CreateBookingDTO;
import edu.eci.cvds.Labtools.model.Booking;
import edu.eci.cvds.Labtools.repository.MongoBookingRepository;
import edu.eci.cvds.Labtools.repository.MongoLabRepository;
import edu.eci.cvds.Labtools.repository.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BasicBookingService implements BookingService{

    @Autowired
    private MongoBookingRepository bookingRepository;

    @Autowired
    private MongoUserRepository userRepository;

    @Autowired
    private MongoLabRepository labRepository;


    public Booking createBooking(CreateBookingDTO createBookingDTO) {
        Booking booking = new Booking();
        booking.setUser(userRepository.findByName(createBookingDTO.userName));

        var lab = labRepository.findByName(createBookingDTO.labName);
        if (lab == null) {
            throw new IllegalArgumentException("Laboratorio no encontrado");
        }
        booking.setLab(lab);

        booking.setDate(createBookingDTO.date);
        booking.setBookingId(UUID.randomUUID().toString());

        System.out.println("booking created");
        bookingRepository.save(booking);



        return booking;
    }



    public boolean deleteBooking(String bookingId) {
        return false;
    }
}
