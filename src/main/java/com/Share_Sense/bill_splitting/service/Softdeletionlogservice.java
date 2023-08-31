package com.Share_Sense.bill_splitting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Share_Sense.bill_splitting.entities.SoftDeletionLog;
import com.Share_Sense.bill_splitting.repository.SoftDeletionLogRepository;

@Service
public class Softdeletionlogservice {

	@Autowired
	SoftDeletionLogRepository softdeletionlogrepo;

	public List<SoftDeletionLog> getAllSoftDeletionLogs() {
		return softdeletionlogrepo.findAll();
	}
}
