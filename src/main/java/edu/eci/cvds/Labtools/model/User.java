package edu.eci.cvds.Labtools.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "users")
public abstract class User {

    @Id
    protected String userId;
    protected String name;
    protected String email;
    protected String password;
    protected boolean logged;
    protected List<Booking> bookings = new ArrayList<>();
    protected boolean rol;

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void deleteBooking(String bookingId) {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public boolean getRol() {
        return rol;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }


}