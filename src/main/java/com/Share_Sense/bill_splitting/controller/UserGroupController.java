package com.Share_Sense.bill_splitting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Share_Sense.bill_splitting.entities.UserGroup;
import com.Share_Sense.bill_splitting.service.Usergroupservice;

@RestController
@RequestMapping("/usergroup")
public class UserGroupController {

	@Autowired
	private Usergroupservice usergroupservice;

	@GetMapping("/usersgroupnames")
	public List<UserGroup> AllUserGroups() {
		return usergroupservice.UserGroups();
	}

}
