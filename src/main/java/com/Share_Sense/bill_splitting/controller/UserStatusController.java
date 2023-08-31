package com.Share_Sense.bill_splitting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Share_Sense.bill_splitting.entities.UserStatus;
import com.Share_Sense.bill_splitting.service.Userstatusservice;

@RestController
@RequestMapping("/userstatus")
public class UserStatusController {

	@Autowired
	private Userstatusservice userstatusservice;

	@GetMapping
	public List<UserStatus> AllUserStatuses() {
		return userstatusservice.getAllUserStatuses();
	}

	@GetMapping("/userstatusby/{id}")
	public Optional<UserStatus> getUserStatusById(@PathVariable Long id) {
		return userstatusservice.getUserStatusById(id);
	}

}
