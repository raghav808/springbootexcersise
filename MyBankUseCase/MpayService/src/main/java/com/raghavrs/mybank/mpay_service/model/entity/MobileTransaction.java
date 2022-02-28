package com.raghavrs.mybank.mpay_service.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class MobileTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private BigDecimal amount;
	private String transactionNumber;

	private Long fromNumber;
	private Long toNumber;
	private String comments;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@CreatedDate
	private LocalDateTime transactionDate;
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
	
	public Long getFromNumber() {
		return fromNumber;
	}
	public void setFromNumber(Long fromNumber) {
		this.fromNumber = fromNumber;
	}
	public Long getToNumber() {
		return toNumber;
	}
	public void setToNumber(Long toNumber) {
		this.toNumber = toNumber;
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
	
	public MobileTransaction(Long id, BigDecimal amount, String transactionNumber, Long fromNumber, Long toNumber,
			String comments, LocalDateTime transactionDate) {
		super();
		this.id = id;
		this.amount = amount;
		this.transactionNumber = transactionNumber;
		this.fromNumber = fromNumber;
		this.toNumber = toNumber;
		this.comments = comments;
		this.transactionDate = transactionDate;
	}
	public MobileTransaction() {
		super();
	}
	
	
}
