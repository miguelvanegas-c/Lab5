package edu.eci.cvds.Labtools.service;

import edu.eci.cvds.Labtools.LabToolsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class BasicEmailVerificationServiceTest {
    @Autowired
    private BasicEmailVerificationService basicEmailVerificationService;
    @Test
    void testVerificationOfAGoodEmail() {
        try {
            assertTrue(basicEmailVerificationService.emailFormatVerification("test@mail.escuelaing.edu.co"));
        } catch (LabToolsException e) {
            fail();
        }
    }
    @Test
    void testThrowTheCorrectExceptionBecauseTextIsNotAnEmail() {
        try{
            basicEmailVerificationService.emailFormatVerification("test");
        }catch(LabToolsException e){
            assertTrue(e.getMessage().contains("The text entered is not an email."));
        }
    }

    @Test
    void testThrowTheCorrectExceptionBecauseEmailDomainIsIncorrect() {
        try{
            basicEmailVerificationService.emailFormatVerification("test@gmail.com");
        }catch (LabToolsException e){
            assertTrue(e.getMessage().contains("The domain of the email is incorrect."));
        }
    }

    @Test
    void testThrowTheCorrectExceptionBecauseEmailIsVoid() {
        try{
            basicEmailVerificationService.emailFormatVerification("");
        }catch (LabToolsException e){
            assertTrue(e.getMessage().contains("Enter a email."));
        }
    }

}
