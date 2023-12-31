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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "softdeletionlog")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
