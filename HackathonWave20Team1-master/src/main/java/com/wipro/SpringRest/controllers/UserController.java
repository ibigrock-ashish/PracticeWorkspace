package com.wipro.SpringRest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.SpringRest.domain.User;
import com.wipro.SpringRest.exceptions.UsernameAndEmailIdIsRequiredException;
import com.wipro.SpringRest.service.UserService;

@RestController
@RequestMapping("/v1.0/UserProfile/user")
public class UserController {
	@Autowired
	UserService userService;
	//when we pass GET Request from we with specified path in Request mapping,this method will get executed
	 @RequestMapping(method=RequestMethod.GET)
	   public ResponseEntity<List<User>> getAllUsers()
		{
		  	List<User> users=userService.getAll();
			return ResponseEntity.ok(users);
		}
	  
	//when we pass POST Request from we with specified path in Request mapping,this method will get executed
	  @RequestMapping(method=RequestMethod.POST)
	  public ResponseEntity<User> createUser(@RequestBody User user) throws Exception 
	  {
		  if(user.getName().isEmpty()||user.getEmailId().isEmpty())
		  {
			  throw new UsernameAndEmailIdIsRequiredException("User name and EmailId is mandatory to create user profile");
		  }
		  else {
			  
			  User savedUser=userService.createProfile(user);
		        return ResponseEntity.ok(savedUser);
		  }
	      
	  	}
	  
	//when we pass PUT Request from we with specified path in Request mapping,this method will get executed
	  @RequestMapping(method=RequestMethod.PUT)
	  public ResponseEntity<String> updateUser(@RequestBody User user) throws Exception  {
	  
		  String status=userService.updateProfile(user);
		  return ResponseEntity.ok("Successfully user updated");
	 }
	  
	//when we pass DELETE Request from we with specified path in Request mapping,this method will get executed
	  @RequestMapping(method=RequestMethod.DELETE)
	  public ResponseEntity<String> deleteUser(@RequestBody User user)  {
		  String status=userService.deleteProfile(user);
		  return ResponseEntity.ok(status);
		  
	   
	  }
	//when we pass GET Request from we with specified path in Request mapping by id,this method will get executed
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
		public ResponseEntity<User> getUserById(@PathVariable int id)  {
			User user=userService.getById(id);
			
			return ResponseEntity.ok(user);
		
		}
	}

	


