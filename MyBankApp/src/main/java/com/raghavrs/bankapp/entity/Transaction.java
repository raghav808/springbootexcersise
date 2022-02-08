package com.raghavrs.bankapp.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private BigDecimal amount;
	private String transactionNumber;

	private Long fromAccount;
	private Long toAccount;
	private String comments;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate transactionDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
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

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Transaction() {
		super();
	}

	public Transaction(Long id, BigDecimal amount, String transactionNumber, Long fromAccount, Long toAccount,
			String comments, LocalDate transactionDate) {
		super();
		this.id = id;
		this.amount = amount;
		this.transactionNumber = transactionNumber;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.comments = comments;
		this.transactionDate = transactionDate;
	}

}
