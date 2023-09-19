package billsplitting.dto;

import java.time.LocalDateTime;

import billsplitting.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SettlementDTO {

	private Long settlementId;

	private User payerUser;

	private User receiverUser;

	private Double amount;

	private LocalDateTime createdAt;

	private boolean isDeleted;



}
