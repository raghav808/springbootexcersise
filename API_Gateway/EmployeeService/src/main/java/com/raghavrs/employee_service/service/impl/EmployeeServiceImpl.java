package com.raghavrs.employee_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.employee_service.feignclient.CompanyServiceClient;
import com.raghavrs.employee_service.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private CompanyServiceClient companyServiceClient;
	
	@Override
	public String getCompanyPortNumber() {
		return companyServiceClient.getPortNumber();
	}

}
