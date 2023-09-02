package com.Share_Sense.bill_splitting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Share_Sense.bill_splitting.entities.Expense;
import com.Share_Sense.bill_splitting.service.Expenseservice;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

	@Autowired
	private Expenseservice expenseservice;

	@GetMapping
	public List<Expense> AllExpenses() {
		return expenseservice.getAllExpenses();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
		Optional<Expense> expenseOptional = expenseservice.getExpenseById(id);

		if (expenseOptional.isPresent()) {
			Expense expense = expenseOptional.get();
			return ResponseEntity.ok(expense);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
		Expense createdExpense = expenseservice.createExpense(expense);

		if (createdExpense != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
