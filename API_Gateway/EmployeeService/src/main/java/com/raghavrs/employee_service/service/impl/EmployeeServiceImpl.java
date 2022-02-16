package com.raghavrs.employee_service.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghavrs.employee_service.dto.EmployeeDTO;
import com.raghavrs.employee_service.dto.response.EmployeesDTO;
import com.raghavrs.employee_service.feignclient.CompanyServiceClient;
import com.raghavrs.employee_service.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	static Map<Integer, EmployeeDTO> employees = new HashMap<>();
	
	static {
		EmployeeDTO employee = new EmployeeDTO(101, "LastName1", "FirstName1", null);
		employees.put(101, employee);
		employee = new EmployeeDTO(102, "LastName2", "FirstName2", null);
		employees.put(102, employee);
		employee = new EmployeeDTO(103, "LastName3", "FirstName3", null);
		employees.put(103, employee);
		employee = new EmployeeDTO(104, "LastName4", "FirstName4", null);
		employees.put(104, employee);
		employee = new EmployeeDTO(105, "LastName5", "FirstName5", null);
		employees.put(105, employee);
		employee = new EmployeeDTO(106, "LastName6", "FirstName6", null);
		employees.put(106, employee);
		employee = new EmployeeDTO(107, "LastName7", "FirstName7", null);
		employees.put(107, employee);
		employee = new EmployeeDTO(108, "LastName8", "FirstName8", null);
		employees.put(108, employee);
	}

	@Autowired
	private CompanyServiceClient companyServiceClient;
	
	@Override
	public String getCompanyPortNumber() {
		return companyServiceClient.getPortNumber();
	}

	@Override
	public List<EmployeesDTO> getEmployees() {
		return employees.values().stream()
				.map(emp -> new EmployeesDTO(emp.getId(), emp.getLastName() + ", " + emp.getFirstname()))
				.collect(Collectors.toList());
//		return new ArrayList<>((employees.values()).);
//		return null;
	}

	@Override
	public EmployeeDTO getEmployee(int index) {
		if (employees.containsKey(index)) {
			employees.get(index).setEmployeeRole(companyServiceClient.getRole(index));
			return employees.get(index);
		}
		return null;
	}

	@Override
	public EmployeeDTO addEmployee(int id, String firstName, String lastName) {
		employees.put(id, new EmployeeDTO(id, lastName, firstName, companyServiceClient.getRole(id)));
		return employees.get(id);
	}

	
}
