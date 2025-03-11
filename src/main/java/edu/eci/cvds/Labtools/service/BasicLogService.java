package edu.eci.cvds.Labtools.service;

import edu.eci.cvds.Labtools.LabToolsException;
import edu.eci.cvds.Labtools.dto.UserDTO;
import edu.eci.cvds.Labtools.dto.UserRegisterDTO;
import edu.eci.cvds.Labtools.model.User;
import edu.eci.cvds.Labtools.repository.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BasicLogService implements LogService {
    @Autowired
    private HashService hashService;
    @Autowired
    private MongoUserRepository mongoUserRepository;

    public UserDTO userLog(UserRegisterDTO userRegisterDTO) throws LabToolsException {
        Optional<User> user = mongoUserRepository.findByEmail(userRegisterDTO.getEmail());
        if (user.isEmpty()) {
            throw new LabToolsException(LabToolsException.User_Not_Exist);
        }
        User userDB = user.get();
        if(!hashService.checkPassword(userRegisterDTO.getPassword(), userDB.getPassword())){
            throw new LabToolsException(LabToolsException.Incorrect_Password);
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setName(userDB.getName());
        userDTO.setRol(userDB.getRol());
        mongoUserRepository.save(userDB);
        return userDTO;
    }

}
