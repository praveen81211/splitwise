package billsplitting.service;

import java.util.List;
import java.util.Optional;

import billsplitting.repository.GroupRepository;
import billsplitting.repository.UserRepository;
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
	private UserRepository userRepository;

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


//	split bill ----------------------------------------------------------------------------------------------------------------------------------


//	public Expense splitBill(Long groupId, Long userId, String description, double amount) {
//		Group group = groupRepository.findById(groupId)
//				.orElseThrow(() -> new IllegalArgumentException("Group not found"));
//
//		User payer = userRepository.findById(userId)
//				.orElseThrow(() -> new IllegalArgumentException("Payer not found"));
//
//		List<User> groupMembers = userRepository.findByGroupId(groupId);
//		int numMembers = groupMembers.size();
//		double individualShare = amount / numMembers;
//
//		Expense bill = new Expense();
//		bill.setGroup(group);
//		bill.setPayer(user);
//		bill.setDescription(description);
//		bill.setAmount(amount);
//		billRepository.save(bill);
//
//		for (user member : groupMembers) {
//			if (!member.equals(user)) {
//				Expense shareBill = new Expense();
//				shareBill.setGroup(group);
//				shareBill.setPayer(payer);
//				shareBill.setDescription(description);
//				shareBill.setAmount(individualShare);
//				ExpenseRepository.save(shareBill);
//			}
//		}
//
//		return bill;
//	}
}

