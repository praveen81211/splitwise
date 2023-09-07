package billsplitting.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "[User]")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@OneToMany(mappedBy = "createdByUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Group> createdGroups = new ArrayList<>();

	@OneToMany(mappedBy = "payerUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Expense> expenses = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<UserGroup> userGroups = new ArrayList<>();

	@OneToMany(mappedBy = "deletedByUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<SoftDeletionLog> deletionLogs = new ArrayList<>();

	@OneToMany(mappedBy = "payerUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Settlement> sentSettlements = new ArrayList<>();

	@OneToMany(mappedBy = "receiverUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Settlement> receivedSettlements = new ArrayList<>();

	@OneToMany(mappedBy = "userstatus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<UserStatus> userStatuses = new ArrayList<>();

	@OneToMany(mappedBy = "userparticipant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ExpenseParticipant> expenseParticipants = new ArrayList<>();
	// ... (getters and setters)

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<Group> getCreatedGroups() {
		return createdGroups;
	}

	public void setCreatedGroups(List<Group> createdGroups) {
		this.createdGroups = createdGroups;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public List<UserGroup> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}

	public List<SoftDeletionLog> getDeletionLogs() {
		return deletionLogs;
	}

	public void setDeletionLogs(List<SoftDeletionLog> deletionLogs) {
		this.deletionLogs = deletionLogs;
	}

	public List<Settlement> getSentSettlements() {
		return sentSettlements;
	}

	public void setSentSettlements(List<Settlement> sentSettlements) {
		this.sentSettlements = sentSettlements;
	}

	public List<Settlement> getReceivedSettlements() {
		return receivedSettlements;
	}

	public void setReceivedSettlements(List<Settlement> receivedSettlements) {
		this.receivedSettlements = receivedSettlements;
	}

	public List<UserStatus> getUserStatuses() {
		return userStatuses;
	}

	public void setUserStatuses(List<UserStatus> userStatuses) {
		this.userStatuses = userStatuses;
	}

	public List<ExpenseParticipant> getExpenseParticipants() {
		return expenseParticipants;
	}

	public void setExpenseParticipants(List<ExpenseParticipant> expenseParticipants) {
		this.expenseParticipants = expenseParticipants;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", isActive=" + isActive + ", isDeleted="
				+ isDeleted + ", createdGroups=" + createdGroups + ", expenses=" + expenses + ", userGroups="
				+ userGroups + ", deletionLogs=" + deletionLogs + ", sentSettlements=" + sentSettlements
				+ ", receivedSettlements=" + receivedSettlements + ", userStatuses=" + userStatuses
				+ ", expenseParticipants=" + expenseParticipants + "]";
	}

}
