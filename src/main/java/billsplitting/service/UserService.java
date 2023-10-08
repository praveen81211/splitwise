package billsplitting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import billsplitting.customexception.RegistrationException;
import billsplitting.customexception.ResourceNotFoundException;
import billsplitting.dto.UserDTO;
import billsplitting.entities.User;
//import billsplitting.repository.GroupRepository;
import billsplitting.repository.UserRepository;

@Service
public class UserService {




	@Autowired
	private UserRepository userRepository;



	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// @Get all users
	public List<UserDTO> getAllUsers() {

		List<User> user = userRepository.findAll();
		List<UserDTO> listener = new ArrayList<>();

		for (User userslist : user) {
			UserDTO userdto = modelMapper.map(userslist, UserDTO.class);
			listener.add(userdto);
		}

		return listener;
	}

	// @Get user by ID
	public UserDTO getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			UserDTO userDto = modelMapper.map(user, UserDTO.class);
			return userDto;
		} else {
			throw new NoSuchElementException("user not found with id:" + id);
		}
	}

	// Create user
	public UserDTO createusers(UserDTO createRequest) {
		User user = modelMapper.map(createRequest, User.class);
		User savedUser = userRepository.save(user);
		UserDTO savedDto = modelMapper.map(savedUser, UserDTO.class);
		return savedDto;
	}

	// @ Delete user by ID
	public void deleteuserbyid(Long id) {

		if (!userRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found with ID: " + id);
		}
		userRepository.deleteById(id);
	}

//	update user

	public UserDTO updateduser(Long id, UserDTO updateduser) {
		Optional<User> optionaluser = userRepository.findById(id);
		if (optionaluser.isPresent()) {
			User existinguser = optionaluser.get();
			modelMapper.map(updateduser, existinguser);
			User updatedEntity = userRepository.save(existinguser);
			UserDTO updatedDto = modelMapper.map(updatedEntity, UserDTO.class);
			return updatedDto;
		} else {
			throw new ResourceNotFoundException("user not found with ID: " + id);
		}
	}

//	registration of user into splitwiseapplication

	public UserDTO registerUser(User registrationRequest) {
		// Check if the email is already registered
		if (userRepository.findByEmail(registrationRequest.getEmail()).isPresent()) {
			throw new RegistrationException("Email is already registered");
		}

		User user = modelMapper.map(registrationRequest, User.class);
		// Encrypt the user's password
		user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
		User savedUser = userRepository.save(user);
		UserDTO savedDto = modelMapper.map(savedUser, UserDTO.class);
		return savedDto;
	}

//	pagination with sorting

	public Page<UserDTO> getAllUsersWithPagination(int page, int size, String sortBy) {
		Pageable pageable;

		if (sortBy != null && !sortBy.isEmpty()) {
			if (sortBy.equals("asc")) {
				pageable = PageRequest.of(page, size, Sort.by("username").ascending());
			} else if (sortBy.equals("desc")) {
				pageable = PageRequest.of(page, size, Sort.by("username").descending());
			} else {
				pageable = PageRequest.of(page, size);
			}
		} else {
			pageable = PageRequest.of(page, size);
		}

		Page<User> userPage = userRepository.findAll(pageable);
		return userPage.map(user -> modelMapper.map(user, UserDTO.class));
	}



}
