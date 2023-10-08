package com.Share_Sense.bill_splitting;

import billsplitting.controller.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.server.ResponseStatusException;
import billsplitting.config.AuthRequest;
import billsplitting.config.JwtService;
import billsplitting.dto.UserDTO;
import billsplitting.entities.User;
import billsplitting.responsedto.ApiResponse;
import billsplitting.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class Usertest {

    @Mock
    private UserService userService;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetall() {
        List<UserDTO> userList = new ArrayList<>();
        // Populate userList with test data
        when(userService.getAllUsers()).thenReturn(userList);

        ResponseEntity<ApiResponse<List<UserDTO>>> response = userController.Getall();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userList, response.getBody().getData());
    }

    @Test
    void testGetUserById() {
        Long userId = 1L;
        UserDTO userDto = new UserDTO();
        // Set up the mock behavior
        when(userService.getUserById(userId)).thenReturn(userDto);

        ResponseEntity<ApiResponse<UserDTO>> response = userController.getUserById(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDto, response.getBody().getData());
    }

    @Test
    void testDeleteuserById() {
        Long userId = 1L;
        // Set up the mock behavior
        doNothing().when(userService).deleteuserbyid(userId);

        ResponseEntity<String> response = userController.deleteuserById(userId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testDeleteuserByIdUserNotFound() {
        Long userId = 1L;
        // Set up the mock behavior
        doThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found with ID: " + userId))
                .when(userService).deleteuserbyid(userId);

        assertThrows(ResponseStatusException.class, () -> userController.deleteuserById(userId));
    }

    @Test
    void testUpdateuser() {
        Long userId = 1L;
        UserDTO updatedUserDto = new UserDTO();
        // Set up the mock behavior
        when(userService.updateduser(userId, updatedUserDto)).thenReturn(updatedUserDto);

        ResponseEntity<ApiResponse<UserDTO>> response = userController.updateuser(userId, updatedUserDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedUserDto, response.getBody().getData());
    }

    @Test
    void testRegisterUser() {
        User registrationRequest = new User();
        UserDTO registeredUserDto = new UserDTO();
        // Set up the mock behavior
        when(userService.registerUser(registrationRequest)).thenReturn(registeredUserDto);

        ResponseEntity<ApiResponse<UserDTO>> response = userController.registerUser(registrationRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(registeredUserDto, response.getBody().getData());
    }

    @Test
    void testGetAllUsersWithPagination() {
        int page = 0;
        int size = 10;
        String sortBy = "id";
        Page<UserDTO> userPage = mock(Page.class);
        // Set up the mock behavior
        when(userService.getAllUsersWithPagination(page, size, sortBy)).thenReturn(userPage);

        ResponseEntity<ApiResponse<Page<UserDTO>>> response = userController.getAllUsersWithPagination(page, size, sortBy);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userPage, response.getBody().getData());
    }

    @Test
    void testAuthenticateAndGetToken() {
        AuthRequest authRequest = new AuthRequest();
        String token = "testToken";
        // Set up the mock behavior
        when(authenticationManager.authenticate(any())).thenReturn(null);
        when(jwtService.generateToken(anyString())).thenReturn(token);

        String response = userController.authenticateAndGetToken(authRequest);

        assertEquals(token, response);
    }
}
