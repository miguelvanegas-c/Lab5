package edu.eci.cvds.Labtools.service;

import edu.eci.cvds.Labtools.LabToolsException;
import org.springframework.stereotype.Service;

@Service
public class BasicEmailVerificationService implements EmailVerificationService {
    private String domain = "mail.escuelaing.edu.co";
    public boolean emailFormatVerification(String email) throws LabToolsException {
        if(email.isEmpty()){
            throw new LabToolsException(LabToolsException.Void_Email);
        }
        if(!email.contains("@")){
            throw new LabToolsException(LabToolsException.Email_Not_Found);
        }
        if(!email.endsWith(domain)){
            throw new LabToolsException(LabToolsException.Email_Domain_Not_Found );
        }
        return true;
    }
}
