package billsplitting.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "expenseparticipant")
public class ExpenseParticipant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expense_participant_id")
	private Long expenseParticipantId;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "expense_id")
	private Expense expense;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private User userparticipant;

	@Column(name = "share_amount", nullable = false)
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

	@Override
	public String toString() {
		return "ExpenseParticipant [expenseParticipantId=" + expenseParticipantId + ", expense=" + expense
				+ ", userparticipant=" + userparticipant + ", shareAmount=" + shareAmount + "]";
	}

}
