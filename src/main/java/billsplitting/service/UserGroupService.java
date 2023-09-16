package billsplitting.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import billsplitting.customexception.ResourceNotFoundException;
import billsplitting.dto.UserGroupDTO;
import billsplitting.entities.Group;
import billsplitting.entities.User;
import billsplitting.entities.UserGroup;
import billsplitting.repository.GroupRepository;
import billsplitting.repository.UserGroupRepository;
import billsplitting.repository.UserRepository;

@Service
public class UserGroupService {

	@Autowired
	private UserGroupRepository userGroupRepository;

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private UserRepository userRepository;

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

	// Add a user to a group
	public UserGroupDTO addUserToGroup(UserGroupDTO userGroupDTO) {
		Long groupId = userGroupDTO.getGroupId();
		Long userId = userGroupDTO.getUserId();

		// Check if the group and user exist
		Group group = groupRepository.findById(groupId)
				.orElseThrow(() -> new ResourceNotFoundException("Group not found with ID: " + groupId));

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

		// Create a UserGroup entity and set the group, user, and joinedAt timestamp
		UserGroup userGroup = new UserGroup();
		userGroup.setGroup(group);
		userGroup.setUser(user);
		userGroup.setJoinedAt(LocalDateTime.now());

		// Save the UserGroup entity
		userGroup = userGroupRepository.save(userGroup);

		// Convert UserGroup entity to UserGroupDTO using modelmapper
		return modelMapper.map(userGroup, UserGroupDTO.class);
	}

}
