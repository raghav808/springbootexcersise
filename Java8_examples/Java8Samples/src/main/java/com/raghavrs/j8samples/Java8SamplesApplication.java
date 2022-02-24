package com.raghavrs.j8samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.raghavrs.j8samples.file_utility.CsvApplication;

@SpringBootApplication
public class Java8SamplesApplication {

	public static void main(String[] args) {
		CsvApplication.mainMethod();
		SpringApplication.run(Java8SamplesApplication.class, args);
	}

}
