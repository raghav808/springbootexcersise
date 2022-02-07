package com.raghavrs.bankapp.dto.request;

import java.math.BigDecimal;

public class FundTransferDTO {

	private BigDecimal amount;
	private Long fromAccount;
	private Long toAccount;
	private String comments;

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

	public FundTransferDTO(BigDecimal amount, Long fromAccount, Long toAccount, String comments) {
		super();
		this.amount = amount;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.comments = comments;
	}

	public FundTransferDTO() {
		super();
	}

}
