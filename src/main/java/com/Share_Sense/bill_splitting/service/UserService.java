package com.Share_Sense.bill_splitting.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Share_Sense.bill_splitting.entities.User;
import com.Share_Sense.bill_splitting.globalException.BusinessException;
import com.Share_Sense.bill_splitting.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userrepo;

	public List<User> getAllUsers() {
		return userrepo.findAll();
	}

	public User getUserById(Long id) {
		if (id < 1) {
			throw new BusinessException("enter +ve value");
		}
		Optional<User> userOptional = userrepo.findById(id);
		User user = userOptional.get();
		return user;
	}

	public ResponseEntity<User> createUser(User newUser) {

		newUser.setCreatedAt(LocalDateTime.now());
		newUser.setUpdatedAt(LocalDateTime.now());
		newUser.setActive(true);
		newUser.setDeleted(false);

		User savedUser = userrepo.save(newUser);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	public ResponseEntity<Void> deleteUser(Long id) {
		if (userrepo.existsById(id)) {
			userrepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
