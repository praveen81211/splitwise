package com.Share_Sense.bill_splitting.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Share_Sense.bill_splitting.dto.Group_dto;
import com.Share_Sense.bill_splitting.entities.Group;
import com.Share_Sense.bill_splitting.repository.GroupRepository;

@Service
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private ModelMapper modelmapper;

	// Create a new group
	public Group createGroup(Group_dto group) {

		Group grp = modelmapper.map(group, Group.class);

		return groupRepository.save(grp);
	}

	// Get group by ID
	public Optional<Group> getGroupById(Long id) {
		return groupRepository.findById(id);
	}

	// Get all groups
	public List<Group> getAllGroups() {
		return groupRepository.findAll();
	}

	// Update an existing group
	public Group updateGroup(Group group) {
		return groupRepository.save(group);
	}

	// Delete group by ID
	public Group deleteGroup(Long id) {
		groupRepository.deleteById(id);
		return null;
	}
}
