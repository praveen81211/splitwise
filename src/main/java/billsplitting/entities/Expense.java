package billsplitting.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Expense")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expense_id")
	private Long expenseId;

	@Column(name = "amount", nullable = false)
	private Double amount;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "payer_user_id")
	private User payerUser;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "group_id")
	private Group group;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@OneToMany(mappedBy = "expense", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ExpenseParticipant> participants = new ArrayList<>();

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

	public List<ExpenseParticipant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ExpenseParticipant> participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", amount=" + amount + ", description=" + description
				+ ", payerUser=" + payerUser + ", group=" + group + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", isDeleted=" + isDeleted + ", participants=" + participants + "]";
	}

}
