package com.Share_Sense.bill_splitting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Share_Sense.bill_splitting.entities.Group;
import com.Share_Sense.bill_splitting.repository.GroupRepository;

@Service
public class Groupservice {

	@Autowired
	GroupRepository grouprepo;

	public List<Group> getAllGroups() {
		return grouprepo.findAll();
	}

}
