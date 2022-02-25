package com.raghavrs.jwt_example.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.raghavrs.jwt_example.model.User;
import com.raghavrs.jwt_example.model.request.UserDTO;
import com.raghavrs.jwt_example.model.response.ResponseUserDTO;
import com.raghavrs.jwt_example.repository.UserRepository;
import com.raghavrs.jwt_example.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService{

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder cryptPasswordEncoder;
	
	
	@Override
	public String addUser(UserDTO user) {
		User dbUser = new User();
		user.setPassword(cryptPasswordEncoder.encode(user.getPassword()));
		BeanUtils.copyProperties(user, dbUser);
		repository.save(dbUser);
		return "Added successfully";
	}

	@Override
	public List<ResponseUserDTO> getAllUsers() {
		return repository.findAll().stream().map(dbUser -> {
			ResponseUserDTO user = new ResponseUserDTO();
			BeanUtils.copyProperties(dbUser, user);
			return user;
		}).collect(Collectors.toList());
	}

	@Override
	public User findUser(String user) {
		return repository.findByUsername(user).orElseThrow();
//		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Invalid username or password."));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

}
