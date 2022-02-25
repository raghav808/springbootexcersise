package com.raghavrs.jwt_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.raghavrs.jwt_example.config.JwtAuthFilter;

@SpringBootApplication
public class SpringJwtExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtExampleApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JwtAuthFilter authTokenFilterBean() {
		return new JwtAuthFilter();
	}
	
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}

}
