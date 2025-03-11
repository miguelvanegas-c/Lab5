package edu.eci.cvds.Labtools.service;

public interface HashService {

    String passwordHashsing(String password);
    boolean checkPassword(String password,String hashedPassword);
}

