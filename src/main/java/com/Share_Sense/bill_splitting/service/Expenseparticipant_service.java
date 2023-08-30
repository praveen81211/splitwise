package com.Share_Sense.bill_splitting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Share_Sense.bill_splitting.entities.ExpenseParticipant;
import com.Share_Sense.bill_splitting.repository.ExpenseParticipantRepository;

@Service
public class Expenseparticipant_service {

	@Autowired
	ExpenseParticipantRepository exppartirepo;

	public List<ExpenseParticipant> getAllExpenseParticipants() {
		return exppartirepo.findAll();
	}

	public Optional<ExpenseParticipant> getExpenseParticipantById(Long id) {
		return exppartirepo.findById(id);
	}

}
