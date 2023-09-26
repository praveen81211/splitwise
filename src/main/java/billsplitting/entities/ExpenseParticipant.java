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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "\"expenseparticipant\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseParticipant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Expense_participant_id")
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
	private BigDecimal shareAmount;

}
