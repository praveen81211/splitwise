package com.Share_Sense.bill_splitting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Share_Sense.bill_splitting.entities.Group;
import com.Share_Sense.bill_splitting.repository.GroupRepository;

@RestController

public class GroupController {

	@Autowired
	private GroupRepository groupRepository;

	@GetMapping("/groupsnames")
	public List<Group> getAllGroups() {
		return groupRepository.findAll();
	}

}
