package billsplitting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import billsplitting.entities.User;
import billsplitting.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import billsplitting.customexception.ResourceNotFoundException;
import billsplitting.dto.GroupDTO;
import billsplitting.entities.Group;
import billsplitting.repository.GroupRepository;
//import billsplitting.repository.UserRepository;

@Service
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelmapper;

	@Autowired
	private UserRepository userRepository;

	// @Get all groups
	public List<GroupDTO> getAllGroups() {
		List<Group> group = groupRepository.findAll();
		List<GroupDTO> listofgroup = new ArrayList<>();

		for (Group grouplist : group) {
			GroupDTO groupdto = modelmapper.map(grouplist, GroupDTO.class);
			listofgroup.add(groupdto);
		}

		return listofgroup;
	}

	// @ Get group by ID
	public GroupDTO getGroupById(Long id) {
		Optional<Group> optional = groupRepository.findById(id);

		if (optional.isPresent()) {
			Group group = optional.get();
			GroupDTO dto = modelmapper.map(group, GroupDTO.class);

			return dto;
		} else {
			throw new ResourceNotFoundException("the id is not present here:" + id);
		}
	}

	// Create a new group
	public GroupDTO createGroup(GroupDTO groupDTO) {
		// Get the user by ID from the userRepository
		User creator = userRepository.findById(groupDTO.getCreatedByUser())
				.orElseThrow(() -> new IllegalArgumentException("Invalid creator ID"));

		// Create a new group entity and set its createdByUser
		Group group = modelmapper.map(groupDTO, Group.class);
		group.setCreatedByUser(creator);


		// Additional logic, such as generating a unique group ID, if needed

		// Save the group to the groupRepository
		Group savedGroup = groupRepository.save(group);

		// Map the saved group back to a DTO and return it
		return modelmapper.map(savedGroup, GroupDTO.class);
	}

	// @Update an existing group
	public GroupDTO updategroup(Long id, GroupDTO updatedGroup) {
		Optional<Group> optinal = groupRepository.findById(id);
		if (optinal.isPresent()) {
			Group existingGroup = optinal.get();
			modelmapper.map(updatedGroup, existingGroup);
			Group updatedEntity = groupRepository.save(existingGroup);
			GroupDTO updatedDto = modelmapper.map(updatedEntity, GroupDTO.class);
			return updatedDto;
		} else {
			throw new ResourceNotFoundException("BankDetails not found with ID: " + id);
		}
	}

	// @ Delete group by ID
	public void deletegroup(Long id) {

		if (!groupRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "BankDetails not found with ID: " + id);
		}
		groupRepository.deleteById(id);
	}

}
