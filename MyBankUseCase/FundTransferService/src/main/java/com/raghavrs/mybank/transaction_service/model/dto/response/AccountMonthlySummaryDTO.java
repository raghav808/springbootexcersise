package com.raghavrs.mybank.transaction_service.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AccountMonthlySummaryDTO {

	private String transactionNumber;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime transactionDate;
	private BigDecimal amount;
	private String transactionType;
	private Long otherAccount;
	public String getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Long getOtherAccount() {
		return otherAccount;
	}
	public void setOtherAccount(Long otherAccount) {
		this.otherAccount = otherAccount;
	}
	public AccountMonthlySummaryDTO(String transactionNumber, LocalDateTime transactionDate, BigDecimal amount,
			String transactionType, Long otherAccount) {
		super();
		this.transactionNumber = transactionNumber;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionType = transactionType;
		this.otherAccount = otherAccount;
	}
	public AccountMonthlySummaryDTO() {
		super();
	}
}
