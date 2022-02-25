package com.raghavrs.jwt_example.service;

import java.util.List;

import com.raghavrs.jwt_example.model.User;
import com.raghavrs.jwt_example.model.request.UserDTO;
import com.raghavrs.jwt_example.model.response.ResponseUserDTO;

public interface UserService {

	String addUser(UserDTO user);

	List<ResponseUserDTO> getAllUsers();

	User findUser(String user);

}
