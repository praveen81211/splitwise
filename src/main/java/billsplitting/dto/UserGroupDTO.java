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



	public Long getGroupId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setJoinedAt(LocalDateTime joinedAt) {
		this.joinedAt = joinedAt;
	}

}
