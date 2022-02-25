package com.raghavrs.jwt_example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghavrs.jwt_example.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String user);

}
