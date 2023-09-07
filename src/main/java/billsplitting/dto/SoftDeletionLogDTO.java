package billsplitting.dto;

import java.time.LocalDateTime;

import billsplitting.entities.User;

public class SoftDeletionLogDTO {

	private Long deletionId;

	private String tableName;

	private Long recordId;

	private User deletedByUser;

	private LocalDateTime deletedAt;

	public Long getDeletionId() {
		return deletionId;
	}

	public void setDeletionId(Long deletionId) {
		this.deletionId = deletionId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public User getDeletedByUser() {
		return deletedByUser;
	}

	public void setDeletedByUser(User deletedByUser) {
		this.deletedByUser = deletedByUser;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

}
