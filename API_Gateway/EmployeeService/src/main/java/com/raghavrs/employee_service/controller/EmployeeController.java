package com.raghavrs.employee_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.employee_service.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	Environment env;
	
//	@Autowired
//	EmployeeService employeeService;
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/port")
	public String getPortNumber() {
		return "Employee service is running on port = " + env.getProperty("local.server.port");
	}
	
	@GetMapping("/ports")
	public String getAllPortNumbers() {
		return "Employee service is running on port = " + env.getProperty("local.server.port")
		+ " and " + employeeService.getCompanyPortNumber();
	}
	
}
