package com.raghavrs.mybank.customer_service.model.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomerDTO {
	@NotBlank(message = "First name is required")
	private String firstName;

	private String lastName;
	private String gender;

	@NotBlank(message = "Email is required")
	@Email
	private String email;

	@NotNull(message = "Phone number is required")
	private Long phone;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

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

	public CustomerDTO(@NotBlank(message = "First name is required") String firstName, String lastName, String gender,
			@NotBlank(message = "Email is required") @Email String email,
			@NotBlank(message = "Phone number is required") Long phone, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
	}

	public CustomerDTO() {
		super();
	}
	
	
}
