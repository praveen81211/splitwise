package com.Share_Sense.bill_splitting.controller;

import java.util.List;

//import org.apache.catalina.User;
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

import com.Share_Sense.bill_splitting.entities.User;
import com.Share_Sense.bill_splitting.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userservice;

	@GetMapping("/username")
	public List<User> AllUsers() {
		return userservice.getAllUsers();
	}

	@GetMapping("/userby/{id}")
	public ResponseEntity<User> UserById(@PathVariable Long id) {
		User userOptional = userservice.getUserById(id);

		return new ResponseEntity<>(userOptional, HttpStatus.OK);
	}

	@PostMapping("/create/users")
	public ResponseEntity<User> User(@RequestBody User newUser) {

		newUser.setCreatedAt(LocalDateTime.now());
		newUser.setUpdatedAt(LocalDateTime.now());
		newUser.setActive(true);
		newUser.setDeleted(false);
		return userservice.createUser(newUser);
		User savedUser = userservice.createUser(newUser)
	return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteby/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		return userservice.deleteUser(id);
	}

}
