package com.Share_Sense.bill_splitting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Optional<Expense> ExpenseById(@PathVariable Long id) {
		return expenseservice.getExpenseById(id);
	}

	@PostMapping
	public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
		return expenseservice.createExpense(expense);
	}

}
