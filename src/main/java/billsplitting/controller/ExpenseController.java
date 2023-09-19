package billsplitting.controller;

import java.math.BigDecimal;
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

import billsplitting.dto.ExpenseDTO;
import billsplitting.entities.Expense;
import billsplitting.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	// Get all expenses
	@GetMapping
	public List<Expense> getAllExpenses() {
		return expenseService.getAllExpenses();
	}

	// Get expense by ID
	@GetMapping("/{id}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
		Optional<Expense> expenseOptional = expenseService.getExpenseById(id);

		if (expenseOptional.isPresent()) {
			Expense expense = expenseOptional.get();
			return ResponseEntity.ok(expense);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Create a new expense
	@PostMapping
	public ResponseEntity<Expense> createExpense(@RequestBody ExpenseDTO expenseDTO) {
		Expense createdExpense = expenseService.createExpense(expenseDTO);
		return ResponseEntity.ok(createdExpense);
	}

	// Update an existing expense by ID
	@PutMapping("/{id}")
	public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense updatedExpense) {
		Optional<Expense> expenseOptional = expenseService.getExpenseById(id);

		if (expenseOptional.isPresent()) {
			Expense existingExpense = expenseOptional.get();
			// Set updated properties here, if needed
			Expense savedExpense = expenseService.updateExpense(existingExpense);
			return ResponseEntity.ok(savedExpense);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Delete expense by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
		boolean deleted = expenseService.deleteExpense(id);

		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}


	// Endpoint to apply expenses to group members
	@PostMapping("/applyExpenseToGroup/{groupId}/{amount}/{description}")
	public ResponseEntity<String> applyExpenseToGroupMembers(
			@PathVariable Long groupId,
			@PathVariable BigDecimal amount,
			@PathVariable String description) {
		expenseService.applyExpenseToGroupMembers(groupId, amount, description);
		return ResponseEntity.status(HttpStatus.CREATED).body("Expense applied to group members successfully.");
	}
	// Endpoint to apply expenses to group members
//	@PostMapping("/applyExpenseToGroup/{groupId}/{amount}")
//	public ResponseEntity<String> applyExpenseToGroupMembers(@PathVariable Long groupId,
//			@PathVariable BigDecimal amount) {
//		expenseService.applyExpenseToGroupMembers(groupId, amount);
//		return ResponseEntity.status(HttpStatus.CREATED).body("Expense applied to group members successfully.");
//	}

}