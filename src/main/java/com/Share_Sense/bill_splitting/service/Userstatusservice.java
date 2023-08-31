package com.Share_Sense.bill_splitting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Share_Sense.bill_splitting.entities.UserStatus;
import com.Share_Sense.bill_splitting.repository.UserStatusRepository;

@Service
public class Userstatusservice {

	@Autowired
	private UserStatusRepository userStatusRepo;

	public List<UserStatus> getAllUserStatuses() {
		return userStatusRepo.findAll();
	}

	public Optional<UserStatus> getUserStatusById(Long id) {
		return userStatusRepo.findById(id);
	}
}
