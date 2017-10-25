package com.wipro.SpringRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.wipro.SpringRest.domain.User;
import com.wipro.SpringRest.exceptions.UserAlreadyExistException;
import com.wipro.SpringRest.exceptions.UserDoesNotExistException;
import com.wipro.SpringRest.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService 
{

	@Autowired
	UserRepository userRepository;
	// Creating a user Profile.
	
	
	@Override
	public User createProfile(User user) throws UserAlreadyExistException {
		User existeduser=userRepository.findOne(user.getId());
		if(existeduser != null )
		{
			throw new UserAlreadyExistException("User Already exist");
		}
		else {
		User createdProfile=userRepository.save(user);
		return createdProfile;
		}
	}
	// Updating user Profile.
		
	@Override
	public String updateProfile(User user) throws UserDoesNotExistException {
		
		User existeduser=userRepository.findOne(user.getId());
		if(existeduser == null )
		{
			throw new UserDoesNotExistException("User does not exist");
		}
		else {
		userRepository.save(user);
		return "Successfully user updated";
	}
	}
	// Deleting User Profile.
			

	@Override
	public String deleteProfile(User user) {
		
		userRepository.delete(user);
		return "User profile deleted";
	}
	// Get all users using List.
			

	@Override
	public List<User> getAll() {
		
		return (List<User>) userRepository.findAll();
		
	}
	// Get user by giving ID.
	@Override
	public User getById(int id) {
		 User user=userRepository.findOne(id);
		return user;

	}
}
