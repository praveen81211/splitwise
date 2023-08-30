package com.Share_Sense.bill_splitting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Share_Sense.bill_splitting.entities.UserStatus;
import com.Share_Sense.bill_splitting.repository.UserStatusRepository;

@RestController

public class UserStatusController {

	@Autowired
	private UserStatusRepository userStatusRepo;

	@GetMapping
	public List<UserStatus> getAllUserStatuses() {
		return userStatusRepo.findAll();
	}

	@GetMapping("/userstatusby/{id}")
	public Optional<UserStatus> getUserStatusById(@PathVariable Long id) {
		return userStatusRepo.findById(id);
	}

}
