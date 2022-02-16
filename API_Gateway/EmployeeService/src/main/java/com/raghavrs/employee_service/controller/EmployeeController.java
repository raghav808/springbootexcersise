package com.raghavrs.employee_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.employee_service.dto.EmployeeDTO;
import com.raghavrs.employee_service.dto.response.EmployeesDTO;
import com.raghavrs.employee_service.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	Environment env;
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/port")
	public String getPortNumber() {
		return "Employee service is running on port = " + env.getProperty("local.server.port");
	}
	
	@GetMapping("/ports")
	public String getAllPortNumbers() {
		String message = "Employee service is running on port = " + env.getProperty("local.server.port");
		
		try {
			message = message + " and " + employeeService.getCompanyPortNumber();
		}catch(Exception ex) {
			message = message + " and " + "Company port is not available";
		}
		return message;
	}
	
	@GetMapping("/")
	public List<EmployeesDTO> getAllEmployees() {
		return employeeService.getEmployees();
	}
	
	@GetMapping("/{index}")
	public EmployeeDTO getEmployee(@PathVariable int index) {
		return employeeService.getEmployee(index);
	}
	
	@PostMapping("/")
	public EmployeeDTO addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int id) {
		return employeeService.addEmployee(id, firstName, lastName);
	}
}
