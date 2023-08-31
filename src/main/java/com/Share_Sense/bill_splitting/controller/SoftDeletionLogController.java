package com.Share_Sense.bill_splitting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Share_Sense.bill_splitting.entities.SoftDeletionLog;
import com.Share_Sense.bill_splitting.service.Softdeletionlogservice;

@RestController
@RequestMapping("/soft-deletion-logs")
public class SoftDeletionLogController {

	@Autowired
	private Softdeletionlogservice softdeletionlogservice;

	@GetMapping
	public List<SoftDeletionLog> AllSoftDeletionLogs() {
		return softdeletionlogservice.getAllSoftDeletionLogs();
	}

}
