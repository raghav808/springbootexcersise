package com.raghavrs.employee_service.dto;

public class EmployeeDTO {
	private int id;
	private String lastName;
	private String firstname;
	private String employeeRole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public EmployeeDTO(int id, String lastName, String firstname, String employeeRole) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstname = firstname;
		this.employeeRole = employeeRole;
	}

}
