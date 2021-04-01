package com.codeimaginationstudio.com.ng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeimaginationstudio.com.ng.model.User;
import com.codeimaginationstudio.com.ng.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	//saving the users information to the database
	public User saveUser(User user) {
		
		return repo.save(user);
		
	}
	
	//fetch user email
	public User fetchUsersByEmailId(String email) {
		
		return repo.findByEmailId(email);
		
	}
	
	//fetch user email and password
	public User fetchUsersByEmailIdAndPassword(String email, String password) {
			
		return repo.findByEmailIdAndPassword(email, password);
			
	}

}
