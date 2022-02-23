package com.raghavrs.j8samples.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.raghavrs.j8samples.model.Employee;

public interface EmployeeService {
//	public List<Employee> getAllCustomers();
	public List<Employee> getTopOldCustomers();
	public List<Employee> getList();
	public List<Employee> getListPostJoined(LocalDateTime joiningDate);
	public List<LocalDate> getWorkingDays(LocalDate startDate, LocalDate endDate);
	public List<LocalDate> getNextWeekWorkingDays(LocalDate startDate);
	public Map<String, List<Employee>> getManagerAndOthers();
	public List<Employee> getEmployeeExperienced();
}
