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

import com.Share_Sense.bill_splitting.entities.Expense;
import com.Share_Sense.bill_splitting.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseservice;

	// Get all expenses
	@GetMapping
	public List<Expense> getAllExpenses() {
		return expenseservice.getAllExpenses();
	}

	// Get expense by ID
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

	// Create a new expense
	@PostMapping
	public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
		Expense createdExpense = expenseservice.createExpense(expense);

		if (createdExpense != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// Update an existing expense by ID
	@PutMapping("/{id}")
	public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense updatedExpense) {
		Optional<Expense> expenseOptional = expenseservice.getExpenseById(id);

		if (expenseOptional.isPresent()) {
			// Update the properties of the existing expense with the provided data
			// Example: Expense existingExpense = expenseOptional.get();
			// existingExpense.setName(updatedExpense.getName());
			// Update other properties as needed

			Expense savedExpense = expenseservice.updateExpense(updatedExpense);
			return ResponseEntity.ok(savedExpense);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete expense by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
		boolean deleted = expenseservice.deleteExpense(id);

		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
