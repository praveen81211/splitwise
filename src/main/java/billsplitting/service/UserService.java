package billsplitting.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import billsplitting.dto.UserDTO;
import billsplitting.entities.User;
import billsplitting.globalException.BusinessException;
import billsplitting.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	// Get all users
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Get user by ID
	public User getUserById(Long id) {
		if (id < 1) {
			throw new BusinessException("Enter a positive value for ID.");
		}
		Optional<User> userOptional = userRepository.findById(id);
		return userOptional.orElseThrow(() -> new BusinessException("User not found."));
	}

	// Create user
	public User createUser(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		return userRepository.save(user);
	}

	// Delete user by ID
	public boolean deleteUser(Long id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		throw new BusinessException("User not found.");
	}

	// 7. Pagination
	public Page<Object> findUserwithPagination(int offset, int pageSize) {
		Page<User> pageOfUser = userRepository.findAll(PageRequest.of(offset, pageSize));
		ModelMapper mapper;
		List<UserDTO> dtoList = pageOfUser.getContent().stream().map(user -> mapper.map(user, UserDTO.class))
				.collect(Collectors.toList());
		return pageOfUser.map(user -> mapper.map(user, UserDTO.class));

	}
}
