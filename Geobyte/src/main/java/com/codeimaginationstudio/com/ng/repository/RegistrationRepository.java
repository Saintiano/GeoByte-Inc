package com.codeimaginationstudio.com.ng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeimaginationstudio.com.ng.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer>{
	
	//find user by email because there is no pre-created findUserByEmailId in repo
	public User findByEmailId(String emailId);
	
	//find user by email and password because there is no pre-created findUserByEmailId in repo
		public User findByEmailIdAndPassword(String emailId, String password);

}
