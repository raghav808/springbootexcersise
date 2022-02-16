package com.raghavrs.employee_service.service;

import java.util.List;

import com.raghavrs.employee_service.dto.EmployeeDTO;
import com.raghavrs.employee_service.dto.response.EmployeesDTO;

public interface EmployeeService {

	String getCompanyPortNumber();

	List<EmployeesDTO> getEmployees();

	EmployeeDTO getEmployee(int index);

	EmployeeDTO addEmployee(int id, String firstName, String lastName);

}
