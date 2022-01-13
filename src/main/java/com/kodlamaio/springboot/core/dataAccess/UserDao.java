package com.kodlamaio.springboot.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.springboot.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
	
}
