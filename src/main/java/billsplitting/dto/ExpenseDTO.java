package billsplitting.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import billsplitting.entities.Group;
import billsplitting.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {

	private Long expenseId;
	private BigDecimal amount;
	private String description;
	private User payerUser;
	private Group group;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private boolean isdeleted;


}
