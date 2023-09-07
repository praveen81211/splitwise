package billsplitting.controller;

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

import billsplitting.dto.GroupDTO;
import billsplitting.entities.Group;
import billsplitting.service.GroupService;

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
			return ResponseEntity.ok(group);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Create a new group
	@PostMapping("/create")
	public ResponseEntity<Group> createGroup(@RequestBody GroupDTO newGroupDto) {
		Group createdGroup = groupService.createGroup(newGroupDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdGroup);
	}

	// Update an existing group by ID
	@PutMapping("/update/{id}")
	public ResponseEntity<Group> updateGroup(@PathVariable Long id, @RequestBody Group updatedGroup) {
		Group existingGroup = groupService.getGroupById(id).orElse(null);

		if (existingGroup != null) {
			existingGroup.setGroupName(updatedGroup.getGroupName());
			Group savedGroup = groupService.updateGroup(existingGroup);
			return ResponseEntity.ok(savedGroup);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete group by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
		Group deleted = groupService.deleteGroup(id);

		if (deleted != null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
