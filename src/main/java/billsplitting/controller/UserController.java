package billsplitting.controller;

import java.util.List;

import billsplitting.config.AuthRequest;
import billsplitting.config.JwtService;
import billsplitting.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import billsplitting.dto.UserDTO;
import billsplitting.responsedto.ApiResponse;
import billsplitting.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;


	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<ApiResponse<List<UserDTO>>> Getall() {

		logger.info("Getting all users");

		List<UserDTO> userDTO = userService.getAllUsers();
		return ResponseEntity.ok(new ApiResponse<>(userDTO, null));
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<ApiResponse<UserDTO>> getUserById(@PathVariable Long id) {

		UserDTO userDto = userService.getUserById(id);

		return ResponseEntity.ok(new ApiResponse<>(userDto, null));
	}

//	@PostMapping("/create")
//	public ResponseEntity<ApiResponse<UserDTO>> newUser(@RequestBody UserDTO postRequest) {
//		UserDTO userdto = userService.createusers(postRequest);
//		return ResponseEntity.ok(new ApiResponse<>(userdto, null));
//	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> deleteuserById(@PathVariable Long id) {
		try {
			userService.deleteuserbyid(id);
			return ResponseEntity.noContent().build();
		} catch (ResponseStatusException e) {
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')||hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<ApiResponse<UserDTO>> updateuser(@PathVariable Long id, @RequestBody UserDTO updateduser) {
		UserDTO dto = userService.updateduser(id, updateduser);
		return ResponseEntity.ok(new ApiResponse<>(dto, null));
	}

	@PostMapping("/register")
//	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<ApiResponse<UserDTO>> registerUser(@RequestBody User registrationRequest) {
		UserDTO userdto = userService.registerUser(registrationRequest);
		return ResponseEntity.ok(new ApiResponse<>(userdto, null));
	}

	@GetMapping("/all")
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<ApiResponse<Page<UserDTO>>> getAllUsersWithPagination(
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sortBy) {
		Page<UserDTO> userPage = userService.getAllUsersWithPagination(page, size, sortBy);
		return ResponseEntity.ok(new ApiResponse<>(userPage, null));
	}

	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){

//		authentication for verify the user before generating the token
		Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
		if(authentication.isAuthenticated()){
			return jwtService.generateToken(authRequest.getUsername());
		}
		else {
			throw new UsernameNotFoundException("Invalid user request !");
		}

	}

}
