package com.raghavrs.mybank.mpay_service.model.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FundTransferWithPhoneDTO {

	@Min(value = 1,message = "Amount should be greater than 1")
	private BigDecimal amount;
	
	@NotNull(message = "From Number is required")
	private Long fromNumber;
	
	@NotNull(message = "To Number is required")
	private Long toNumber;
	private String comments;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

//	public LocalDateTime getTransactionDate() {
//		return transactionDate;
//	}
//
//	public void setTransactionDate(LocalDateTime transactionDate) {
//		this.transactionDate = transactionDate;
//	}

	public FundTransferWithPhoneDTO(@Min(value = 1, message = "Amount should be greater than 1") BigDecimal amount,
			@NotNull(message = "From Account is required") Long fromNumber,
			@NotNull(message = "To Account is required") Long toNumber, String comments
			//@PastOrPresent LocalDateTime transactionDate
			) {
		super();
		this.amount = amount;
		this.fromNumber = fromNumber;
		this.toNumber = toNumber;
		this.comments = comments;
//		this.transactionDate = transactionDate;
	}

	public FundTransferWithPhoneDTO() {
		super();
	}
	
	
}
