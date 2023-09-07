package billsplitting.entities;

import java.time.LocalDateTime;

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
@Table(name = "softdeletionlog")
public class SoftDeletionLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "deletion_id")
	private Long deletionId;

	@Column(name = "table_name", nullable = false)
	private String tableName;

	@Column(name = "record_id", nullable = false)
	private Long recordId;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "deleted_by_user_id")
	private User deletedByUser;

	@Column(name = "deleted_at")
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

	@Override
	public String toString() {
		return "SoftDeletionLog [deletionId=" + deletionId + ", tableName=" + tableName + ", recordId=" + recordId
				+ ", deletedByUser=" + deletedByUser + ", deletedAt=" + deletedAt + "]";
	}

}
