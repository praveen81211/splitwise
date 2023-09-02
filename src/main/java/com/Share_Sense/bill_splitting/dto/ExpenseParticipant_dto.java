package com.Share_Sense.bill_splitting.dto;

import com.Share_Sense.bill_splitting.entities.Expense;
import com.Share_Sense.bill_splitting.entities.User;

public class ExpenseParticipant_dto {

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
