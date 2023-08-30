package com.Share_Sense.bill_splitting.entities;

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
@Table(name = "Settlement")
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

	public Long getSettlementId() {
		return settlementId;
	}

	public void setSettlementId(Long settlementId) {
		this.settlementId = settlementId;
	}

	public User getPayerUser() {
		return payerUser;
	}

	public void setPayerUser(User payerUser) {
		this.payerUser = payerUser;
	}

	public User getReceiverUser() {
		return receiverUser;
	}

	public void setReceiverUser(User receiverUser) {
		this.receiverUser = receiverUser;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Settlement [settlementId=" + settlementId + ", payerUser=" + payerUser + ", receiverUser="
				+ receiverUser + ", amount=" + amount + ", createdAt=" + createdAt + ", isDeleted=" + isDeleted + "]";
	}

}
