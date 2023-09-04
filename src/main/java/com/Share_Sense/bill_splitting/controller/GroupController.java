package com.Share_Sense.bill_splitting.controller;

import java.util.List;

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

import com.Share_Sense.bill_splitting.dto.Group_dto;
import com.Share_Sense.bill_splitting.entities.Group;
import com.Share_Sense.bill_splitting.service.GroupService;

@RestController
@RequestMapping("/groups")
public class GroupController {

	@Autowired
	private GroupService groupService;

	// Get all groups
	@GetMapping("/all")
	public List<Group> getAllGroups() {
		return groupService.getAllGroups();
	}

	// Get group by ID
	@GetMapping("/{id}")
	public ResponseEntity<Group> getGroupById(@PathVariable Long id) {
		Group group = groupService.getGroupById(id).orElse(null);

		if (group != null) {
			return new ResponseEntity<>(group, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/create")
	public Group createGroup(@RequestBody Group_dto newGroupDto) {

		Group grp = groupService.createGroup(newGroupDto);

		return grp;
	}

	// Update an existing group by ID
	@PutMapping("/update/{id}")
	public ResponseEntity<Group> updateGroup(@PathVariable Long id, @RequestBody Group updatedGroup) {
		Group existingGroup = groupService.updateGroup(updatedGroup);

		if (existingGroup != null) {

			existingGroup.setGroupName(updatedGroup.getGroupName());
			// Update other properties as needed

			Group savedGroup = groupService.updateGroup(existingGroup);
			return new ResponseEntity<>(savedGroup, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Delete group by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Group> deleteGroup(@PathVariable Long id) {
		Group groupToDelete = groupService.deleteGroup(id);

		if (groupToDelete != null) {
			groupService.deleteGroup(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
