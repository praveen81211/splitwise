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
@Table(name = "Settlement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Settlement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "settlement_id")
	private Long settlementId;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "payer_user_id")
	private User payerUser;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "receiver_user_id")
	private User receiverUser;

	@Column(name = "amount", nullable = false)
	private Double amount;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "is_deleted")
	private boolean isDeleted;

}
