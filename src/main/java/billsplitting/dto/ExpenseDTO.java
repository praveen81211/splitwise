package billsplitting.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import billsplitting.entities.Group;
import billsplitting.entities.User;

public class ExpenseDTO {

	private Long expenseId;
	private BigDecimal amount;
	private String description;
	private User payerUser;
	private Group group;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private boolean deleted;

	public Long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
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
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
