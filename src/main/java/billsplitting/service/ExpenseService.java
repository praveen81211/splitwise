package billsplitting.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import billsplitting.customexception.ResourceNotFoundException;
import billsplitting.dto.ExpenseDTO;
import billsplitting.entities.Expense;
import billsplitting.entities.Group;
import billsplitting.entities.User;
import billsplitting.repository.ExpenseRepository;
import billsplitting.repository.GroupRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Autowired
	private GroupRepository groupRepository;

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

//	applying the expenses to the group

public ExpenseDTO applyExpenseToGroupMembers(Long groupId, BigDecimal amount, String description) {
	// Retrieve the group by its ID
	Group group = groupRepository.findById(groupId)
			.orElseThrow(() -> new ResourceNotFoundException("Group not found with ID: " + groupId));

	// Create a new Expense entity
	Expense exp = new Expense();
	exp.setGroup(group);
	exp.setAmount(amount);
	exp.setDescription(description); // Set the description here

	// Save the group to update the expenses
	Expense expenses =expenseRepository.save(exp);
	return modelMapper.map(expenses,ExpenseDTO.class);
}

	// Apply expenses to group members
//	public void applyExpenseToGroupMembers(Long groupId, BigDecimal amount) {
//		// Find the group by ID
//		Group = groupRepository.findById(groupId)
//				.orElseThrow(() -> new ResourceNotFoundException("Group not found with ID: " + groupId));
//
//		// Get the list of users in the group
//		List<User> groupMembers = group.getMembers();
//		if (groupMembers == null || groupMembers.isEmpty()) {
//			throw new ResourceNotFoundException("No members found in the group.");
//		}
//
//		// Calculate the equal share for each member
//		BigDecimal share = amount.divide(BigDecimal.valueOf(groupMembers.size()), 2, RoundingMode.HALF_UP);
//
//		// Apply the expense to each member
//		for (User member : groupMembers) {
//			Expense expense = new Expense();
//			expense.setAmount(share);
//			expense.setUser(member);
//			expense.setGroup(group);
//			expense.setExpenseDate(LocalDateTime.now());
//
//			// Save the Expense entity and map it to an ExpenseDTO
//			Expense savedExpense = expenseRepository.save(expense);
//			modelMapper.map(savedExpense, ExpenseDTO.class);
//		}
//	}
}
