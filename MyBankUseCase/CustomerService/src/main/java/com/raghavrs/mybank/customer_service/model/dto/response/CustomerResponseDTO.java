package com.raghavrs.mybank.customer_service.model.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerResponseDTO {
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private Long phone;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	private LocalDateTime whenCreated;
	
	List<AccountDTO> addedAccount;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDateTime getWhenCreated() {
		return whenCreated;
	}

	public void setWhenCreated(LocalDateTime whenCreated) {
		this.whenCreated = whenCreated;
	}

	public List<AccountDTO> getAddedAccount() {
		return addedAccount;
	}

	public void setAddedAccount(List<AccountDTO> addedAccount) {
		this.addedAccount = addedAccount;
	}
	
	
}
