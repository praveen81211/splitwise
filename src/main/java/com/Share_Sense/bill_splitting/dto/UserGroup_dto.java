package com.Share_Sense.bill_splitting.dto;

import java.time.LocalDateTime;

import com.Share_Sense.bill_splitting.entities.Group;
import com.Share_Sense.bill_splitting.entities.User;

public class UserGroup_dto {

	private Long userGroupId;

	private User user;

	private Group group;

	private LocalDateTime joinedAt;

	private LocalDateTime leftAt;

	public Long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public LocalDateTime getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(LocalDateTime joinedAt) {
		this.joinedAt = joinedAt;
	}

	public LocalDateTime getLeftAt() {
		return leftAt;
	}

	public void setLeftAt(LocalDateTime leftAt) {
		this.leftAt = leftAt;
	}

}
