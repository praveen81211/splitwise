package billsplitting.dto;

import java.time.LocalDateTime;

import billsplitting.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoftDeletionLogDTO {

	private Long deletionId;

	private String tableName;

	private Long recordId;

	private User deletedByUser;

	private LocalDateTime deletedAt;



}
