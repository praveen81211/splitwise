package com.Share_Sense.bill_splitting.dto;

import java.time.LocalDateTime;

import com.Share_Sense.bill_splitting.entities.Group;
import com.Share_Sense.bill_splitting.entities.User;

public class Expense_dto {

	private Long expenseId;

	private Double amount;

	private String description;

	private User payerUser;

	private Group group;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	private boolean isDeleted;

	public Long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getPayerUser() {
		return payerUser;
	}

	public void setPayerUser(User payerUser) {
		this.payerUser = payerUser;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
