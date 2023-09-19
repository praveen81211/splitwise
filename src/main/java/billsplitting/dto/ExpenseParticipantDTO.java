package billsplitting.dto;

import billsplitting.entities.Expense;
import billsplitting.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseParticipantDTO {

	private Long expenseParticipantId;

	private Expense expense;

	private User userparticipant;

	private BigDecimal shareAmount;


}
