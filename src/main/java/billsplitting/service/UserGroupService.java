package billsplitting.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import billsplitting.dto.UserGroupDTO;
import billsplitting.entities.UserGroup;
import billsplitting.repository.UserGroupRepository;

@Service
public class UserGroupService {

	@Autowired
	private UserGroupRepository userGroupRepository;

	@Autowired
	private ModelMapper modelMapper;

	// Create a new user group
	public UserGroup createUserGroup(UserGroupDTO userGroupDTO) {
		UserGroup userGroup = modelMapper.map(userGroupDTO, UserGroup.class);
		return userGroupRepository.save(userGroup);
	}

	// Get user group by ID
	public Optional<UserGroup> getUserGroupById(Long id) {
		return userGroupRepository.findById(id);
	}

	// Get all user groups
	public List<UserGroup> getAllUserGroups() {
		return userGroupRepository.findAll();
	}

	// Update an existing user group
	public UserGroup updateUserGroup(UserGroup updatedUserGroup) {
		return userGroupRepository.save(updatedUserGroup);
	}

	// Delete user group by ID
	public boolean deleteUserGroup(Long id) {
		if (userGroupRepository.existsById(id)) {
			userGroupRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
