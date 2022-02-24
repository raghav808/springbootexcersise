package com.raghavrs.j8samples.service.impl;

import java.io.FileReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.raghavrs.j8samples.model.Employee;
import com.raghavrs.j8samples.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final String filepath = "D:\\flatfile\\employees.csv";
	static List<Employee> employees = new ArrayList<Employee>();

	static {
		try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
			employees = reader.readAll().stream().map(emps -> {
				Employee e = new Employee(Integer.valueOf(emps[0]), emps[1], emps[2], emps[3], LocalDate.parse(emps[4]),
						LocalDateTime.parse(emps[5]));
				return e;
			}).toList();
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	@Override
	public List<Employee> getTopOldCustomers() {
		return employees.stream().sorted(Comparator.comparing(Employee::getDoj)).limit(5).collect(Collectors.toList());
	}

	@Override
	public List<Employee> getListPostJoined(LocalDateTime joiningDate) {
		return employees.stream().filter(e -> e.getDoj().isAfter(joiningDate) || e.getDoj().isEqual(joiningDate))
				.toList();
	}

	@Override
	public List<LocalDate> getWorkingDays(LocalDate startDate, LocalDate endDate) {

		if (startDate == null || endDate == null) {
			System.out.println("dates are required");
			return null;
		}

		Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
				|| date.getDayOfWeek() == DayOfWeek.SUNDAY;

		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

		return Stream.iterate(startDate, date -> date.plusDays(1)).limit(daysBetween).filter(isWeekend.negate())
				.collect(Collectors.toList());
	}

	@Override
	public List<LocalDate> getNextWeekWorkingDays() {
		LocalDate nextMonday = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
		long daysBetween = ChronoUnit.DAYS.between(nextMonday,
				nextMonday.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)));

		return Stream.iterate(nextMonday, date -> date.plusDays(1)).limit(daysBetween).collect(Collectors.toList());
	}

	@Override
	public Map<String, List<Employee>> getManagerAndOthers() {
		return employees.stream().collect(Collectors.groupingBy(Employee::isManager, Collectors.toList()));
	}

	@Override
	public List<Employee> getEmployeeExperienced() {	
		
		LocalDateTime now = LocalDateTime.now();
		Predicate<Employee> isGreaterThan7Yr = e -> ChronoUnit.YEARS.between(e.getDoj(), now) > 10;
		Predicate<Employee> isTechLead = e -> e.getDesignation().equals("Technical Lead");
		return employees.stream()
				.filter(isTechLead.and(isGreaterThan7Yr))
//				.filter(emp -> emp.getDesignation().equals("Technical Lead"))
//				.filter(emp -> ChronoUnit.YEARS.between(emp.getDoj(), LocalDate.now()) > 7)
				.collect(Collectors.toList());
	}
	
	
	
	@Override
	public List<Employee> getList() {
//		Map<String, Map<String, List<Employee>>> mass = employees.stream().collect(
//		Collectors.groupingBy(Employee::getEmployeeType, Collectors.groupingBy(Employee::getDesignation)));

//employees.stream()
//.collect(Collectors.groupingBy(
//		Employee::isManager,
//           Collectors.mapping(Employee::getEmployeeName, Collectors.toList())));
////		Collectors.groupingBy(Employee::getDesignation));
//System.out.println(ttt.toString());
		return employees;
	}

}
