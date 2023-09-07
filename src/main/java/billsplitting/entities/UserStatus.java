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
@Table(name = "userstatus")
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

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public User getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(User userstatus) {
		this.userstatus = userstatus;
	}

	public LocalDateTime getStatusChangeDatetime() {
		return statusChangeDatetime;
	}

	public void setStatusChangeDatetime(LocalDateTime statusChangeDatetime) {
		this.statusChangeDatetime = statusChangeDatetime;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "UserStatus [statusId=" + statusId + ", userstatus=" + userstatus + ", statusChangeDatetime="
				+ statusChangeDatetime + ", isActive=" + isActive + "]";
	}

}
