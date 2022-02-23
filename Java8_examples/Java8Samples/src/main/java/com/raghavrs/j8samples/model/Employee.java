package com.raghavrs.j8samples.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {

	private Integer employeeId;
	private String employeeName;
	private String gender;
	private String designation;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateOfBirth;
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime doj;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDateTime getDoj() {
		return doj;
	}

	public void setDoj(LocalDateTime doj) {
		this.doj = doj;
	}

	public Employee(Integer employeeId, String employeeName, String gender, String designation, LocalDate dateOfBirth,
			LocalDateTime doj) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.gender = gender;
		this.designation = designation;
		this.dateOfBirth = dateOfBirth;
		this.doj = doj;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", gender=" + gender
				+ ", designation=" + designation + ", dateOfBirth=" + dateOfBirth + ", doj=" + doj + "]";
	}

	public String isManager() {
		return this.getDesignation().equals("Manager") ? "Manager" : "Regular";
	}
}
