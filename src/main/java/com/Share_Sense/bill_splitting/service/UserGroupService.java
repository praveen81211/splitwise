package com.Share_Sense.bill_splitting.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Share_Sense.bill_splitting.dto.UserGroup_dto;
import com.Share_Sense.bill_splitting.entities.UserGroup;
import com.Share_Sense.bill_splitting.repository.UserGroupRepository;

@Service
public class UserGroupService {

	@Autowired
	private UserGroupRepository userGroupRepository;
	@Autowired
	private ModelMapper modelmapper;

	// Create a new user group
	public UserGroup createUserGroup(UserGroup_dto usergroup) {
		UserGroup user = modelmapper.map(usergroup, UserGroup.class);
		return user;
	}

	// Get user group by ID
	public Optional<UserGroup> getUserGroupById(Long id) {
		return userGroupRepository.findById(id);
	}

	// Get all user groups
	public List<UserGroup> getAllUserGroups() {
		return userGroupRepository.findAll();
	}

	// Update an existing user group
	public UserGroup updateUserGroup(UserGroup updatedUserGroup) {
		return userGroupRepository.save(updatedUserGroup);
	}

	// Delete user group by ID
	public boolean deleteUserGroup(Long id) {
		if (userGroupRepository.existsById(id)) {
			userGroupRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
