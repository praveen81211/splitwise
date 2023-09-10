package billsplitting.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import billsplitting.customexception.ResourceNotFoundException;
import billsplitting.dto.GroupDTO;
import billsplitting.entities.Group;
import billsplitting.repository.GroupRepository;

@Service
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private ModelMapper modelmapper;

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

	// @ Create a new group
	public GroupDTO createGroup(GroupDTO creategroup) {

		Group grp = modelmapper.map(creategroup, Group.class);
		Group group = groupRepository.save(grp);
		GroupDTO dto = modelmapper.map(group, GroupDTO.class);

		return dto;
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
