package com.raghavrs.company_service.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.raghavrs.company_service.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	static List<String> employeeRoles = new ArrayList<>();

	static {
		employeeRoles.add("Manager");
		employeeRoles.add("Asst Manager");
		employeeRoles.add("Senior Lead");
		employeeRoles.add("Lead");
		employeeRoles.add("Senior Engg");
		employeeRoles.add("Engg");
		employeeRoles.add("Asst Engg");
		employeeRoles.add("Trainee");
		employeeRoles.add("Asst Trainee");
	}

	@Override
	public String getRoles(int index) {
		return employeeRoles.get(index%8);
	}
}
