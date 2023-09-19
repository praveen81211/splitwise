package billsplitting.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import jakarta.transaction.Transactional;
import billsplitting.entities.ExpenseParticipant;
import billsplitting.repository.ExpenseParticipantRepository;
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
	private ExpenseParticipantRepository expenseParticipantRepository;

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

//	 Apply expenses to group members
public List<ExpenseParticipant> splitExpenseEquallyAmongGroupMembers(Long expenseId) {
	Optional<Expense> expenseOptional = expenseRepository.findById(expenseId);

	if (expenseOptional.isPresent()) {
		Expense expense = expenseOptional.get();

		// Find the group associated with the expense
		Group group = expense.getGroup();

		// Get the list of users in the group
		List<User> groupMembers = group.getMembers();

		if (groupMembers == null || groupMembers.isEmpty()) {
			throw new ResourceNotFoundException("No members found in the group.");
		}

		// Calculate the equal share for each member
		BigDecimal share = expense.getAmount().divide(BigDecimal.valueOf(groupMembers.size()), 2, RoundingMode.HALF_UP);

		// Create a list to store ExpenseParticipant entities
		List<ExpenseParticipant> expenseParticipants = new ArrayList<>();

		// Apply the expense to each member and add them to the list
		for (User member : groupMembers) {
			// Create a new ExpenseParticipant entity
			ExpenseParticipant expenseParticipant = new ExpenseParticipant();
			expenseParticipant.setExpense(expense);
			expenseParticipant.setUserparticipant(member);
			expenseParticipant.setShareAmount(share);

			// Save the ExpenseParticipant entity and add it to the list
			expenseParticipantRepository.save(expenseParticipant);
			expenseParticipants.add(expenseParticipant);
		}

		return expenseParticipants; // Return the list of ExpenseParticipant entities
	} else {
		throw new ResourceNotFoundException("Expense not found with ID: " + expenseId);
	}
}
}

