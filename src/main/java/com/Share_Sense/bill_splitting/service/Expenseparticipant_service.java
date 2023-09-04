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
	private ExpenseParticipantRepository expenseParticipantRepository;

	// Create a new expense participant
	public ExpenseParticipant createExpenseParticipant(ExpenseParticipant expenseParticipant) {
		return expenseParticipantRepository.save(expenseParticipant);
	}

	// Get expense participant by ID
	public Optional<ExpenseParticipant> getExpenseParticipantById(Long id) {
		return expenseParticipantRepository.findById(id);
	}

	// Get all expense participants
	public List<ExpenseParticipant> getAllExpenseParticipants() {
		return expenseParticipantRepository.findAll();
	}

	// Update an existing expense participant
	public ExpenseParticipant updateExpenseParticipant(ExpenseParticipant expenseParticipant) {
		return expenseParticipantRepository.save(expenseParticipant);
	}

	// Delete expense participant by ID
	public boolean deleteExpenseParticipant(Long id) {
		if (expenseParticipantRepository.existsById(id)) {
			expenseParticipantRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
