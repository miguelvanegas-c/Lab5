package edu.eci.cvds.Labtools.service;

import edu.eci.cvds.Labtools.LabToolsException;
import edu.eci.cvds.Labtools.dto.UserDTO;
import edu.eci.cvds.Labtools.dto.UserRegisterDTO;

public interface LogService {

    UserDTO userLog(UserRegisterDTO userRegisterDTO) throws LabToolsException;

}