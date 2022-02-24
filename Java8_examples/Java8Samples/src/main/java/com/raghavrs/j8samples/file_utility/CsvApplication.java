package com.raghavrs.j8samples.file_utility;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class CsvApplication {
	
	static List<Employee> employees = new ArrayList<>();
	private static final String filepath = "D:\\flatfile\\employees.csv";

	static {
		employees.add(new Employee(100, "Test Emp", "Male", "Manager", LocalDate.of(1999, 2, 2),
				LocalDateTime.of(2009, 1, 2, 12, 30)));
		employees.add(new Employee(101, "Test Emp1", "Female", "Manager", LocalDate.of(2000, 4, 12),
				LocalDateTime.of(2009, 1, 2, 11, 00)));
		employees.add(new Employee(102, "Test Emp2", "Male", "Technical Lead", LocalDate.of(1998, 12, 11),
				LocalDateTime.of(2016, 10, 10, 9, 30)));
		employees.add(new Employee(103, "Test Emp3", "Male", "Lead Engineer", LocalDate.of(1996, 6, 22),
				LocalDateTime.of(2010, 6, 1, 10, 00)));
		employees.add(new Employee(104, "Test Emp4", "Female", "Technical Lead", LocalDate.of(1999, 9, 8),
				LocalDateTime.of(2010, 1, 2, 12, 30)));
		employees.add(new Employee(105, "Test Emp5", "Male", "Lead Engineer", LocalDate.of(1999, 10, 10),
				LocalDateTime.of(2012, 1, 2, 12, 30)));
		employees.add(new Employee(106, "Test Emp6", "Male", "Manager", LocalDate.of(1999, 2, 12),
				LocalDateTime.of(2010, 1, 2, 12, 30)));
		employees.add(new Employee(107, "Test Emp7", "Male", "Technical Lead", LocalDate.of(1999, 2, 2),
				LocalDateTime.of(2011, 1, 2, 12, 30)));
		employees.add(new Employee(108, "Test Emp8", "Male", "Technical Lead", LocalDate.of(1999, 7, 18),
				LocalDateTime.of(2013, 12, 12, 11, 00)));
		employees.add(new Employee(109, "Test Emp9", "Female", "Manager", LocalDate.of(2000, 1, 1),
				LocalDateTime.of(2020, 5, 16, 13, 30)));
	}

	public static void mainMethod() {
		try {
			  
            FileWriter writer = new 
                       FileWriter(filepath);

            ColumnPositionMappingStrategy<Employee> mappingStrategy = new ColumnPositionMappingStrategy<>();
            mappingStrategy.setType(Employee.class);
            // Arrange column name as provided in below array.
            String[] columns = new String[] 
                    { "employeeId", "employeeName", "gender", "designation", "dateOfBirth", "doj" };
            mappingStrategy.setColumnMapping(columns);
  
            // Creating StatefulBeanToCsv object
            StatefulBeanToCsvBuilder<Employee> builder=
                        new StatefulBeanToCsvBuilder<Employee>(writer);
            StatefulBeanToCsv<Employee> beanWriter = 
          builder.withMappingStrategy(mappingStrategy).build();
  
            // Write list to StatefulBeanToCsv object
            beanWriter.write(employees);
  
            // closing the writer object
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}

}
