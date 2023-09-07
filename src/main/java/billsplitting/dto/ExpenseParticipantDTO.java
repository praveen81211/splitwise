package billsplitting.dto;

import billsplitting.entities.Expense;
import billsplitting.entities.User;

public class ExpenseParticipantDTO {

	private Long expenseParticipantId;

	private Expense expense;

	private User userparticipant;

	private Double shareAmount;

	public Long getExpenseParticipantId() {
		return expenseParticipantId;
	}

	public void setExpenseParticipantId(Long expenseParticipantId) {
		this.expenseParticipantId = expenseParticipantId;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	public User getUserparticipant() {
		return userparticipant;
	}

	public void setUserparticipant(User userparticipant) {
		this.userparticipant = userparticipant;
	}

	public Double getShareAmount() {
		return shareAmount;
	}

	public void setShareAmount(Double shareAmount) {
		this.shareAmount = shareAmount;
	}
}
