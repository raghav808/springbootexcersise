
package com.raghavrs.j8samples.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.j8samples.model.Employee;
import com.raghavrs.j8samples.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/old-5-employees")
	public List<Employee> geTop5tist(){
		return employeeService.getTopOldCustomers();
	}
	
	@GetMapping("/employees-joined-after")
	public List<Employee> getEmployeesPostTo(@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss") LocalDateTime joiningDate){
		return employeeService.getListPostJoined(joiningDate);
	}

	
	@GetMapping("/manager-and-others")
	public Map<String, List<Employee>> getManagerAndOthers(){
		return employeeService.getManagerAndOthers();
	}
	
	@GetMapping("/techleads-above7-exp")
	public List<Employee> getTechLeadsMoreThan7Years(){
		return employeeService.getEmployeeExperienced();
	}
	
	@GetMapping("/working-days")
	public List<LocalDate> workingDaysBetween(@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate startDate,
			@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate endDate){
		return employeeService.getWorkingDays(startDate, endDate);
	}
	
	@GetMapping("/next-week-working-days")
	public List<LocalDate> nextWeekWorkingDays(@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate fromDate){
		return employeeService.getNextWeekWorkingDays(fromDate);
	}
	
	@GetMapping
	public List<Employee> getist() {
		return employeeService.getList();
//		return "Success";
	}
}
