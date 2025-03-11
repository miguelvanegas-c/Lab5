package edu.eci.cvds.Labtools.service;

import edu.eci.cvds.Labtools.dto.BookingDTO;
import edu.eci.cvds.Labtools.model.Booking;
import edu.eci.cvds.Labtools.model.User;
import edu.eci.cvds.Labtools.repository.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasicQueryService implements QueryService {
    @Autowired
    private MongoUserRepository userRepository;

    public String[] checkAvailability(String date) {
        return null;
    }

    public List<BookingDTO> findBookingsByName(String name){
        User user = userRepository.findByName(name);
        validateUser(user);
        List<Booking> bookings = user.getBookings();
        List<BookingDTO> bookingDTOs = new ArrayList<BookingDTO>();
        for(Booking booking : bookings){
            BookingDTO bookingDTO = new BookingDTO();
            bookingDTO.setDate(booking.getDate());
            bookingDTO.setBookingId(booking.getBookingId());
            bookingDTO.setLabName(booking.getLab().getName());
            bookingDTOs.add(bookingDTO);
        }
        return bookingDTOs;
    }

    private void validateUser(User user) {

        if(user==null){
            throw new IllegalArgumentException("No user found");
        }
        if(!user.getRol() || user.getBookings().isEmpty()){
            throw new IllegalArgumentException("User don't have bookings");
        }

    }
}