package edu.eci.cvds.Labtools.service;

import edu.eci.cvds.Labtools.LabToolsException;

public interface EmailVerificationService {
    boolean emailFormatVerification(String email) throws LabToolsException;
}
