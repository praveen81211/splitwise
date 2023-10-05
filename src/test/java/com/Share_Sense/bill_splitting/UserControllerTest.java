package com.Share_Sense.bill_splitting;

import billsplitting.controller.UserController;
import billsplitting.dto.UserDTO;
import billsplitting.responsedto.ApiResponse;
import billsplitting.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

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
