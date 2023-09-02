package com.Share_Sense.bill_splitting.dto;

import java.time.LocalDateTime;

import com.Share_Sense.bill_splitting.entities.User;

public class Settlement_dto {

	private Long settlementId;

	private User payerUser;

	private User receiverUser;

	private Double amount;

	private LocalDateTime createdAt;

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

}
