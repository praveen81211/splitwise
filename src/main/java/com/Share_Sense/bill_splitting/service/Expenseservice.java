package com.Share_Sense.bill_splitting.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Share_Sense.bill_splitting.entities.Expense;
import com.Share_Sense.bill_splitting.repository.ExpenseRepository;

@Service
public class Expenseservice {

	@Autowired
	ExpenseRepository expenserepo;

	public List<Expense> getAllExpenses() {
		return expenserepo.findAll();
	}

	public Optional<Expense> getExpenseById(Long id) {
		return expenserepo.findById(id);
	}

	public Expense createExpense(@RequestBody Expense expense) {
		// Set necessary fields before saving
		LocalDateTime now = LocalDateTime.now(); // Current timestamp

		expense.setCreatedAt(now);
		expense.setUpdatedAt(now);
		expense.setDeleted(false); // Assuming the default value for isDeleted is false

		Expense savedExpense = expenserepo.save(expense);
		return savedExpense;
	}
}