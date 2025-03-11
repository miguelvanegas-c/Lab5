package edu.eci.cvds.Labtools.service;

import com.lambdaworks.crypto.SCryptUtil;
import org.springframework.stereotype.Service;



@Service
public class BasicHashService implements HashService {

    public String passwordHashsing(String password) {
        return SCryptUtil.scrypt(password,16384, 8, 1);
    }

    public boolean checkPassword(String password,String hashedPassword) {
        return SCryptUtil.check(password, hashedPassword);
    }


}
