package com.raghavrs.jwt_example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.jwt_example.model.response.ResponseUserDTO;
import com.raghavrs.jwt_example.service.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users/")
	public List<ResponseUserDTO> getAllUsers(){
		return userService.getAllUsers();
	}

}
