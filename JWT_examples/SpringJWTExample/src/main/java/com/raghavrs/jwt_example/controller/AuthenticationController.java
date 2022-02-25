package com.raghavrs.jwt_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raghavrs.jwt_example.config.JwtTokenUtil;
import com.raghavrs.jwt_example.model.User;
import com.raghavrs.jwt_example.model.response.AuthToken;
import com.raghavrs.jwt_example.service.UserService;

@RestController
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@PostMapping("/token")
	public AuthToken generateToke(@RequestParam String user, @RequestParam String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user, password));
		final User dbUser = userService.findUser(user);
		final String token = jwtTokenUtil.generateToken(dbUser);
		return null;
	}
}
