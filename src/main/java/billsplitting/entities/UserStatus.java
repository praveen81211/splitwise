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
@Table(name = "userstatus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
	private Long statusId;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private User userstatus;

	@Column(name = "status_change_datetime")
	private LocalDateTime statusChangeDatetime;

	@Column(name = "is_active")
	private boolean isActive;

}
