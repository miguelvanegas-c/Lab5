package edu.eci.cvds.Labtools.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "bookings")
public class Booking {

    @Id
    private String bookingId;
    private String date;
    private User user;
    private Lab lab;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }
}
