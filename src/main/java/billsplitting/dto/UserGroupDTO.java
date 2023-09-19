package billsplitting.dto;

import java.time.LocalDateTime;

import billsplitting.entities.Group;
import billsplitting.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGroupDTO {

	private Long userGroupId;

	private User user;

	private Group group;

	private LocalDateTime joinedAt;

	private LocalDateTime leftAt;




}
