package com.codeimaginationstudio.com.ng.controller;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeimaginationstudio.com.ng.model.User;
import com.codeimaginationstudio.com.ng.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	//to handle exception message
	public class BusinessException extends WebApplicationException {
	     public BusinessException(Response.Status status, String message) {
	         super(Response.status(status)
	             .entity(message).type(MediaType.TEXT_PLAIN).build());
	     }
	}
	
	//create a url that will be called from angular 8 on a particular method for registration
	@PostMapping("/registeruser")
	
	
	//method to create user
	public User registerUser(@RequestBody User user) throws Exception  {
		
		
		//get emailId in the database and store in a string 
		String tempEmailId = user.getEmailId();
		
		//check if email already exist if not save to database
		//checking if temporary email is empty and not equal to null
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			
			//checking 
			User userObj = service.fetchUsersByEmailId(tempEmailId);
			
			//if userObj is not null
			if(userObj != null) {
				
				try {
					
					throw new Exception("user with "+tempEmailId +" is already existing");
					
				}catch(Exception e){
					
					throw new BusinessException(Response.Status.NOT_FOUND,"products does not exist.");
					
				}
				
				
			
				
			}
			
		}
		
		//save user to database
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
		
		
	}
	
	//method for login
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		
		//retrieve email of user and password from database
		String tempEmailId = user.getEmailId();
		String tempPassword = user.getPassword();
		
		//created user object to get response from service since its a user object
		User userObj = null;
		
		//check if user with email and password is in database, then login
		if(tempEmailId != null && tempPassword != null) {
			//fetch user email and password and compare
			userObj = service.fetchUsersByEmailIdAndPassword(tempEmailId, tempPassword);
		}
		//check if user is not present in the database
		if(userObj == null) {
			
			throw new Exception("Bad Credentials");
			
		}
		
		return userObj;
		
	}
	

}
