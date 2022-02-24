package com.raghavrs.j8samples.file_utility;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer employeeId;
	private String employeeName;
	private String gender;
	private String designation;
	private LocalDate dateOfBirth;
	private LocalDateTime doj;

	public Employee(Integer employeeId, String employeeName, String gender, String designation, 
			LocalDate dateOfBirth, LocalDateTime doj) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.gender = gender;
		this.designation = designation;
		this.dateOfBirth = dateOfBirth;
		this.doj = doj;
	}

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

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", gender=" + gender
				+ ", designation=" + designation + ", dateOfBirth=" + dateOfBirth + ", doj=" + doj + "]";
	}


}
