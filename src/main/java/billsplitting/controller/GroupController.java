package billsplitting.controller;

import java.util.List;

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
import org.springframework.web.server.ResponseStatusException;

import billsplitting.dto.GroupDTO;
import billsplitting.responsedto.ApiResponse;
import billsplitting.service.GroupService;

@RestController
@RequestMapping("/groups")
public class GroupController {

	@Autowired
	private GroupService groupService;

	// @ Get all groups
	@GetMapping("/all")
	public ResponseEntity<ApiResponse<List<GroupDTO>>> getAllGroups() {
		List<GroupDTO> group = groupService.getAllGroups();
		return ResponseEntity.ok(new ApiResponse<>(group, null));
	}

	// @Get group by ID
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<GroupDTO>> getGroupById(@PathVariable Long id) {
		GroupDTO group = groupService.getGroupById(id);
		return ResponseEntity.ok(new ApiResponse<>(group, null));

	}

	// @Create a new group
	@PostMapping("/create")
	public ResponseEntity<ApiResponse<GroupDTO>> newgroup(@RequestBody GroupDTO groupDTO) {
		GroupDTO groupDto = groupService.createGroup(groupDTO);
		return ResponseEntity.ok(new ApiResponse<>(groupDto, null));
	}

	// @ Update an existing group by ID
	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse<GroupDTO>> updateDepartment(@PathVariable Long id,
			@RequestBody GroupDTO updatedDepartment) {
		GroupDTO updatinggroup = groupService.updategroup(id, updatedDepartment);
		return ResponseEntity.ok(new ApiResponse<>(updatinggroup, null));
	}

	// @Delete group by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDepartmentById(@PathVariable Long id) {
		try {
			groupService.deletegroup(id);
			return ResponseEntity.noContent().build();
		} catch (ResponseStatusException e) {
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}
	}
}
