package billsplitting.controller;

import java.util.List;

import billsplitting.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

	// Create a new group -----------------------------------------------------------------------------------------
	@PostMapping("/create a new group")
	public ResponseEntity<GroupDTO> createGroup(
			@RequestParam("groupName") String groupName,
			@RequestParam ("createdByUser") Long createdByUser ){ // Match the parameter name with the DTO

		// Check if groupName is not empty
		if (groupName == null || groupName.trim().isEmpty()) {
			return ResponseEntity.badRequest().body(null) ;
		}
		GroupDTO groupDTO = new GroupDTO();
		groupDTO.setGroupName(groupName);
		groupDTO.setCreatedByUser(createdByUser); // Match the setter with the DTO

		GroupDTO responseDTO = groupService.createGroup(groupDTO);
		return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
	}



//	 @ Update an existing group by ID  
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
