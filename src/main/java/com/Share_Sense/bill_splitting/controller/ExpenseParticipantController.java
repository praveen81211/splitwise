package com.Share_Sense.bill_splitting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Share_Sense.bill_splitting.entities.ExpenseParticipant;
import com.Share_Sense.bill_splitting.service.Expenseparticipant_service;

@RestController
@RequestMapping("/expense_participants")
public class ExpenseParticipantController {

	@Autowired
	private Expenseparticipant_service expenseParticipantService;

	// Get all expense participants
	@GetMapping
	public List<ExpenseParticipant> getAllExpenseParticipants() {
		return expenseParticipantService.getAllExpenseParticipants();
	}

	// Get expense participant by ID
	@GetMapping("/{id}")
	public ResponseEntity<ExpenseParticipant> getExpenseParticipantById(@PathVariable Long id) {
		Optional<ExpenseParticipant> expenseParticipantOptional = expenseParticipantService
				.getExpenseParticipantById(id);

		if (expenseParticipantOptional.isPresent()) {
			ExpenseParticipant expenseParticipant = expenseParticipantOptional.get();
			return ResponseEntity.ok(expenseParticipant);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Create a new expense participant
	@PostMapping
	public ResponseEntity<ExpenseParticipant> createExpenseParticipant(
			@RequestBody ExpenseParticipant expenseParticipant) {
		ExpenseParticipant createdExpenseParticipant = expenseParticipantService
				.createExpenseParticipant(expenseParticipant);

		if (createdExpenseParticipant != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdExpenseParticipant);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// Update an existing expense participant by ID
	@PutMapping("/{id}")
	public ResponseEntity<ExpenseParticipant> updateExpenseParticipant(@PathVariable Long id,
			@RequestBody ExpenseParticipant updatedExpenseParticipant) {
		Optional<ExpenseParticipant> expenseParticipantOptional = expenseParticipantService
				.getExpenseParticipantById(id);

		if (expenseParticipantOptional.isPresent()) {

			ExpenseParticipant savedExpenseParticipant = expenseParticipantService
					.updateExpenseParticipant(updatedExpenseParticipant);
			return ResponseEntity.ok(savedExpenseParticipant);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete expense participant by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExpenseParticipant(@PathVariable Long id) {
		boolean deleted = expenseParticipantService.deleteExpenseParticipant(id);

		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
