package com.raghavrs.jwt_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.jwt_example.model.request.UserDTO;
import com.raghavrs.jwt_example.service.UserService;

@RestController
public class RegistrationControoler {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public String addUser(@RequestBody UserDTO user) {
		return userService.addUser(user);
	}

}
