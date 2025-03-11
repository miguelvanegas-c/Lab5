package edu.eci.cvds.Labtools.service;

import edu.eci.cvds.Labtools.dto.BookingDTO;
import edu.eci.cvds.Labtools.model.*;
import edu.eci.cvds.Labtools.repository.MongoUserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BasicQueryServiceTest {
    @MockitoBean
    private MongoUserRepository mongoUserRepository;

    @Autowired
    private BasicQueryService basicQueryService;

    @Test
    public void testQueryWithoutProblems() {
        User user = new BasicUser();
        user.setName("test");
        Lab lab = new Lab();
        lab.setName("Lab 1");
        Booking booking = new Booking();
        booking.setBookingId("1");
        booking.setUser(user);
        booking.setLab(lab);
        booking.setDate("11/02/25 7:00");
        user.addBooking(booking);
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingId(booking.getBookingId());
        bookingDTO.setLabName(lab.getName());
        bookingDTO.setDate(booking.getDate());
        Mockito.when(mongoUserRepository.findByName(Mockito.anyString())).thenReturn(user);
        List<BookingDTO> bookingDTOS = basicQueryService.findBookingsByName(user.getName());
        assertEquals(bookingDTOS.size(), 1);
        assertEquals(bookingDTOS.get(0).getBookingId(), booking.getBookingId());
        assertEquals(bookingDTOS.get(0).getLabName(), lab.getName());
        assertEquals(bookingDTOS.get(0).getDate(), booking.getDate());
    }

    @Test
    public void testQueryIfUserNotExists() {
        try {
            Mockito.when(mongoUserRepository.findByName(Mockito.anyString())).thenReturn(null);
            basicQueryService.findBookingsByName(null);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "No user found");
        }
    }

    @Test
    public void testQueryIfUserIsAnAdmin() {
        User user = new Admin();
        try {
            Mockito.when(mongoUserRepository.findByName(Mockito.anyString())).thenReturn(user);
            basicQueryService.findBookingsByName("3");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "User don't have bookings");
        }
    }

    @Test
    public void testQueryIfUserDontHaveBookings() {
        User user = new BasicUser();
        try {
            Mockito.when(mongoUserRepository.findByName(Mockito.anyString())).thenReturn(user);
            basicQueryService.findBookingsByName("3");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "User don't have bookings");
        }
    }
}
