package com.Share_Sense.bill_splitting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Share_Sense.bill_splitting.entities.UserGroup;
import com.Share_Sense.bill_splitting.repository.UserGroupRepository;

@Service
public class Usergroupservice {

	@Autowired
	UserGroupRepository usergrouprepo;

	public List<UserGroup> UserGroups() {
		return usergrouprepo.findAll();
	}

}
