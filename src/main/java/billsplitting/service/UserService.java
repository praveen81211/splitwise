package billsplitting.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import billsplitting.dto.UserDTO;
import billsplitting.entities.User;
import billsplitting.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	// @Get all users
	public List<UserDTO> getAllusers() {
		List<User> user = userRepository.findAll();
		return user.stream().map(User -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
	}

	// @Get user by ID
	public UserDTO getUserById(Long id) {
		Optional<User> optionalUserDTO = userRepository.findById(id);
		if (optionalUserDTO.isPresent()) {
			User user = optionalUserDTO.get();
			UserDTO DTO = modelMapper.map(user, UserDTO.class);
			return DTO;
		} else {
			throw new NoSuchElementException("department not found with id:" + id);
		}
	}

	// Create user
	public UserDTO createusers(UserDTO createRequest) {
		User user = modelMapper.map(createRequest, User.class);
		User savedBankDetails = userRepository.save(user);
		UserDTO savedDto = modelMapper.map(savedBankDetails, UserDTO.class);
		return savedDto;
	}

	// @ Delete user by ID
	public void deleteuserbyid(Long id) {

		if (!userRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found with ID: " + id);
		}
		userRepository.deleteById(id);
	}

	// 7. Pagination
	public Page<Object> findUserwithPagination(int offset, int pageSize) {
		Page<User> pageOfUser = userRepository.findAll(PageRequest.of(offset, pageSize));
		ModelMapper modelMapper = null;
		List<UserDTO> dtoList = pageOfUser.getContent().stream().map(user -> modelMapper.map(user, UserDTO.class))
				.collect(Collectors.toList());
		return pageOfUser.map(user -> modelMapper.map(user, UserDTO.class));

	}
}
