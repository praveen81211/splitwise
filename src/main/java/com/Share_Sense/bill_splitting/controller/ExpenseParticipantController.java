package com.Share_Sense.bill_splitting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Share_Sense.bill_splitting.entities.ExpenseParticipant;
import com.Share_Sense.bill_splitting.service.Expenseparticipant_service;

@RestController
@RequestMapping("/expense_participants")
public class ExpenseParticipantController {

	@Autowired
	private Expenseparticipant_service exppartser;

	@GetMapping
	public List<ExpenseParticipant> AllExpenseParticipants() {
		return exppartser.getAllExpenseParticipants();
	}

	@GetMapping("/{id}")
	public Optional<ExpenseParticipant> getExpenseParticipantById(@PathVariable Long id) {
		return exppartser.getExpenseParticipantById(id);
	}

}
