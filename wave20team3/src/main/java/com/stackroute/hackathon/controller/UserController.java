package com.stackroute.hackathon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.hackathon.domain.User;
import com.stackroute.hackathon.exception.UsernameAndEmailIdIsRequiredException;
import com.stackroute.hackathon.service.UserService;

@RestController
public class UserController 
{
	@Autowired
	UserService userservice;
	
	@RequestMapping(method=RequestMethod.GET , value="/getall")
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> user=userservice.getAllUsers();
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/create")
	public ResponseEntity<String> create(@RequestBody User user) throws Exception
	{
		if(user.getName().isEmpty()||user.getEmail().isEmpty()) {
			throw new UsernameAndEmailIdIsRequiredException("User name and EmailId is mandatory to create user profile");
		}else {
		userservice.create(user);
		String create= "Users saved Successfully";
		return ResponseEntity.ok(create);
		}
	}

	@RequestMapping(method=RequestMethod.DELETE , value="/delete" , produces="text/plain")
	public ResponseEntity<String> delete(User user)
	{
		String deleteStatus=userservice.delete(user);
		return ResponseEntity.ok(deleteStatus);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/update", produces="text/plain")
	public ResponseEntity<String> update(User user) throws Exception
	{
		String updateStatus=userservice.update(user);
		return ResponseEntity.ok("User Updated Successfully");
	}
}
