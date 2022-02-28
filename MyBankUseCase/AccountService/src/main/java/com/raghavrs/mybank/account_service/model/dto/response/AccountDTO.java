package com.raghavrs.mybank.account_service.model.dto.response;

import java.math.BigDecimal;

public class AccountDTO {

	private Long accountNumber;
	private BigDecimal accountBalance;
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	public AccountDTO(Long accountNumber, BigDecimal accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}
	public AccountDTO() {
		super();
	}
}
