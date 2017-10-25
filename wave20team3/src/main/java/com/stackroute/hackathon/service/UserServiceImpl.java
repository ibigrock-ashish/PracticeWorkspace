package com.stackroute.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.hackathon.domain.User;
import com.stackroute.hackathon.exception.UserAlreadyExistException;
import com.stackroute.hackathon.exception.UserDoesNotExistException;
import com.stackroute.hackathon.repository.UserRepository;
@Component
public class UserServiceImpl implements UserService
{

	@Autowired
	UserRepository userrepository;
	
	@Override
	public User create(User user) throws UserAlreadyExistException {
	User existeduser=userrepository.findOne(user.getId());
	if(existeduser != null) {
		throw new UserAlreadyExistException("User Already exist");
	}else {
	User created = userrepository.save(user);
		return created;
	}
	}

	@Override
	public String update(User user) throws UserDoesNotExistException {
		User existeduser=userrepository.findOne(user.getId());
		if(existeduser == null )
		{
			throw new UserDoesNotExistException("User does not exist");
		}else {
		//User update = userrepository.save(user);
		return "User Updated Successfully";
		}
	}

	@Override
	public String delete(User user) {
		 userrepository.delete(user);
		return "Data Deleted Successfully";
	}

	@Override
	public List<User> getAllUsers() {
		
		
		return (List<User>) userrepository.findAll();
	}

	@Override
	public User getById(int id) {
		User user=userrepository.findOne(id);
		return user;
	}

	
}
