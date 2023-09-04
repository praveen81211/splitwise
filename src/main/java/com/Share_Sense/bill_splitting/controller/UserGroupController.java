package com.Share_Sense.bill_splitting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Share_Sense.bill_splitting.dto.UserGroup_dto;
import com.Share_Sense.bill_splitting.entities.UserGroup;
import com.Share_Sense.bill_splitting.service.UserGroupService;

@RestController
@RequestMapping("/usergroups")
public class UserGroupController {

	@Autowired
	private UserGroupService userGroupService;

	// Get all user groups
	@GetMapping("/all")
	public List<UserGroup> getAllUserGroups() {
		return userGroupService.getAllUserGroups();
	}

	// Get user group by ID
	@GetMapping("/{id}")
	public ResponseEntity<UserGroup> getUserGroupById(@PathVariable Long id) {
		Optional<UserGroup> userGroupOptional = userGroupService.getUserGroupById(id);

		if (userGroupOptional.isPresent()) {
			UserGroup userGroup = userGroupOptional.get();
			return ResponseEntity.ok(userGroup);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Create a new user group
	@PostMapping("/create")
	public UserGroup createUserGroup(@RequestBody UserGroup_dto usergroup) {
		UserGroup savedUserGroup = userGroupService.createUserGroup(usergroup);
		return savedUserGroup;
	}

	// Update an existing user group by ID
	@PutMapping("/update/{id}")
	public ResponseEntity<UserGroup> updateUserGroup(@PathVariable Long id, @RequestBody UserGroup updatedUserGroup) {
		Optional<UserGroup> existingUserGroupOptional = userGroupService.getUserGroupById(id);

		if (existingUserGroupOptional.isPresent()) {
			UserGroup existingUserGroup = existingUserGroupOptional.get();

			UserGroup savedUserGroup = userGroupService.updateUserGroup(existingUserGroup);
			return ResponseEntity.ok(savedUserGroup);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete user group by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUserGroup(@PathVariable Long id) {
		boolean deleted = userGroupService.deleteUserGroup(id);

		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
