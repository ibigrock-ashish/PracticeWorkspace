package com.stackroute.hackathon.service;

import com.stackroute.hackathon.domain.User;
import com.stackroute.hackathon.exception.UserAlreadyExistException;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface UserService 
{
	
	public User create(User user) throws Exception;
	public String update(User user) throws Exception;
	public String delete(User user);
	public List<User> getAllUsers();
	public User getById(int id);
}
