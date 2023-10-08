package com.Share_Sense.bill_splitting;

import billsplitting.controller.UserController;
import billsplitting.dto.UserDTO;
import billsplitting.entities.User;
import billsplitting.repository.UserRepository;
import billsplitting.responsedto.ApiResponse;
import billsplitting.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;



    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers(){
        List<UserDTO> users=new ArrayList<>();
        when(userService.getAllUsers()).thenReturn(users);

        ResponseEntity<ApiResponse<List<UserDTO>>> response = userController.Getall();

        verify(userService, times(1)).getAllUsers();
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() != null;
        assert response.getBody().getData() == users;
    }





}
