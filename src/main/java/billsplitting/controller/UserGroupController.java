package billsplitting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import billsplitting.dto.UserGroupDTO;
import billsplitting.entities.UserGroup;
import billsplitting.service.UserGroupService;
import jakarta.validation.Valid;

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
	public ResponseEntity<UserGroup> createUserGroup(@RequestBody UserGroupDTO userGroupDTO) {
		UserGroup savedUserGroup = userGroupService.createUserGroup(userGroupDTO);
		return ResponseEntity.ok(savedUserGroup);
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

	// Endpoint to add a user to a group
	@PostMapping("/addUserToGroup")
	public ResponseEntity<UserGroupDTO> addUserToGroup(@Valid @RequestBody UserGroupDTO userGroupDTO) {
		UserGroupDTO addedUserGroup = userGroupService.addUserToGroup(userGroupDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedUserGroup);
	}
}
