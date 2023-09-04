package com.Share_Sense.bill_splitting.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Share_Sense.bill_splitting.dto.Expense_dto;
import com.Share_Sense.bill_splitting.entities.Expense;
import com.Share_Sense.bill_splitting.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	private ModelMapper modelmapper;

	// Create a new expense
	public Expense createExpense(Expense_dto exp2) {
		// Assuming that ModelMapper is correctly configured
		Expense exp = modelmapper.map(exp2, Expense.class);
		return expenseRepository.save(exp);
	}

	// Get expense by ID
	public Optional<Expense> getExpenseById(Long id) {
		return expenseRepository.findById(id);
	}

	// Get all expenses
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}

	// Update an existing expense
	public Expense updateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}

	// Delete expense by ID
	public boolean deleteExpense(Long id) {
		if (expenseRepository.existsById(id)) {
			expenseRepository.deleteById(id);
			return true;
		}
		return false;
	}
}