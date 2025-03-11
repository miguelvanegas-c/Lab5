package edu.eci.cvds.Labtools.controller;


import edu.eci.cvds.Labtools.LabToolsException;
import edu.eci.cvds.Labtools.dto.UserDTO;
import edu.eci.cvds.Labtools.dto.UserRegisterDTO;
import edu.eci.cvds.Labtools.service.BasicLogService;
import edu.eci.cvds.Labtools.service.HashService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HashService hashService;

    @MockitoBean
    private BasicLogService basicLogService;


    @Test
    public void testEmailVerificationWithAGoodEmail() throws Exception {
        mockMvc.perform(get("/log")
                        .param("email", "test@mail.escuelaing.edu.co"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    public void testEmailVerificationWithBadEmail() throws Exception {
        mockMvc.perform(get("/log")
                        .param("email", "test@gmail.com"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testLogUserThatExistInDataBase() throws Exception {
        String password = hashService.passwordHashsing("123");
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setEmail("test@mail.escuelaing.edu.co");
        userRegisterDTO.setPassword(password);
        UserDTO mockUserDTO = new UserDTO();
        mockUserDTO.setRol(true);
        mockUserDTO.setName("test");

        Mockito.when(basicLogService.userLog(Mockito.any(UserRegisterDTO.class))).thenReturn(mockUserDTO);

        mockMvc.perform(post("/log")
                        .contentType("application/json")
                        .content("{\"email\": \"test@mail.escuelaing.edu.co\"" +
                                ",\"password\": \"123\" }"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\": \"test\"" +
                        ",\"rol\": true }"));
    }

    @Test
    public void testLogUserThatNotExistInDataBase() throws Exception {
        String password = hashService.passwordHashsing("123");
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setEmail("test@mail.escuelaing.edu.co");
        userRegisterDTO.setPassword(password);

        Mockito.when(basicLogService.userLog(Mockito.any(UserRegisterDTO.class))).thenThrow(new LabToolsException(LabToolsException.User_Not_Exist));

        mockMvc.perform(post("/log")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"test@mail.escuelaing.edu.co\", \"password\": \"123\" }"))
                .andExpect(status().isBadRequest());
    }
}
