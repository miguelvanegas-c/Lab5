package edu.eci.cvds.Labtools.service;

import edu.eci.cvds.Labtools.dto.BookingDTO;

import java.util.List;

public interface QueryService {
    String[] checkAvailability(String date);
    List<BookingDTO> findBookingsByName(String name);
}