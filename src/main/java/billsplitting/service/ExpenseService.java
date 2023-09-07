package billsplitting.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import billsplitting.dto.ExpenseDTO;
import billsplitting.entities.Expense;
import billsplitting.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	private ModelMapper modelMapper;

	// Create a new expense
	public Expense createExpense(ExpenseDTO expenseDTO) {
		Expense expense = modelMapper.map(expenseDTO, Expense.class);
		return expenseRepository.save(expense);
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
