package billsplitting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import billsplitting.dto.UserDTO;
import billsplitting.responsedto.ApiResponse;
import billsplitting.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<ApiResponse<List<UserDTO>>> Getall() {

		List<UserDTO> userDTO = userService.getAllusers();
		return ResponseEntity.ok(new ApiResponse<>(userDTO, null));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<UserDTO>> getUserById(@PathVariable Long id) {

		UserDTO userDTO = userService.getUserById(id);

		return ResponseEntity.ok(new ApiResponse<>(userDTO, null));
	}

	@PostMapping("/create")
	public ResponseEntity<ApiResponse<UserDTO>> newUser(@RequestBody UserDTO postRequest) {
		UserDTO userdto = userService.createusers(postRequest);
		return ResponseEntity.ok(new ApiResponse<>(userdto, null));
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<String> deleteuserById(@PathVariable Long id) {
		try {
			userService.deleteuserbyid(id);
			return ResponseEntity.noContent().build();
		} catch (ResponseStatusException e) {
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}
	}
}
