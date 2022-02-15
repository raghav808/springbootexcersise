package com.raghavrs.company_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
	
	@Autowired
	Environment env;

	@GetMapping("/port")
	public String getPortNumber() {
		return "Company service is running on port = " + env.getProperty("local.server.port");
	}

}
