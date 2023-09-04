package com.Share_Sense.bill_splitting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Share_Sense.bill_splitting.dto.Users_dto;
import com.Share_Sense.bill_splitting.entities.User;
import com.Share_Sense.bill_splitting.globalException.BusinessException;
import com.Share_Sense.bill_splitting.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Get all users
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// Get user by ID
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
		try {
			User user = userService.getUserById(id);

			if (user != null) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (BusinessException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody Users_dto userDto) {
		User user = mapUserDtoToUser(userDto);

		// Call the service method to create the user
		User savedUser = userService.createUser(user);

		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	// Map Users_dto to User entity
	private User mapUserDtoToUser(Users_dto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setCreatedAt(userDto.getCreatedAt());
		user.setUpdatedAt(userDto.getUpdatedAt());
		user.setActive(userDto.isActive());
		user.setDeleted(userDto.isDeleted());

		return user;
	}

	// Delete user by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		boolean deleted = userService.deleteUser(id);

		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
