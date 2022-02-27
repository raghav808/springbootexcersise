package com.raghavrs.mybank.customer_service.model.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FundTransferDTO {

	@Min(value = 1,message = "Amount should be greater than 1")
	private BigDecimal amount;
	
	@NotNull(message = "From Account is required")
	private Long fromAccount;
	
	@NotNull(message = "To Account is required")
	private Long toAccount;
	private String comments;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@PastOrPresent
	private LocalDateTime transactionDate;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Long getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Long getToAccount() {
		return toAccount;
	}

	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public FundTransferDTO(@Min(value = 1, message = "Amount should be greater than 1") BigDecimal amount,
			@NotNull(message = "From Account is required") Long fromAccount,
			@NotNull(message = "To Account is required") Long toAccount, String comments,
			@PastOrPresent LocalDateTime transactionDate) {
		super();
		this.amount = amount;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.comments = comments;
		this.transactionDate = transactionDate;
	}

	public FundTransferDTO() {
		super();
	}

	@Override
	public String toString() {
		return "FundTransferDTO [amount=" + amount + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount
				+ ", comments=" + comments + ", transactionDate=" + transactionDate + "]";
	}

	
}