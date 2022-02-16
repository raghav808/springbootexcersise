package com.raghavrs.employee_service.dto.response;

public class EmployeesDTO {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EmployeesDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
