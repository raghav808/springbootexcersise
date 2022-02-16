package com.raghavrs.company_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.company_service.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	Environment env;
	
	@Autowired
	CompanyService companyService;

	@GetMapping("/port")
	public String getPortNumber() {
		return "Company service is running on port = " + env.getProperty("local.server.port");
	}
	
	@GetMapping("/{index}")
	public String getRolles(@PathVariable int index) {
		return companyService.getRoles(index);
	}

}
