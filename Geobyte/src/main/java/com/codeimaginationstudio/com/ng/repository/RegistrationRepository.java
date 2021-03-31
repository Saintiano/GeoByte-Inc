package com.codeimaginationstudio.com.ng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeimaginationstudio.com.ng.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer>{
	
	//find user by email because there is no pre-created findUserByEmailId
	public User findByEmailId(String emailId);

}
