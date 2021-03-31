package com.codeimaginationstudio.com.ng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeimaginationstudio.com.ng.model.User;
import com.codeimaginationstudio.com.ng.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	//create a url that will be called on a particular method for registration
	@GetMapping("/registeruser")
	
	
	//method to create user
	public User registerUser(@RequestBody User user) {
		
		
		//get emailid in the database and store in a string 
		String tempEmailId = user.getEmailId();
		
		//check if email already exist
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			
		}
		
		//save user to database
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
		
		
	}
	

}
