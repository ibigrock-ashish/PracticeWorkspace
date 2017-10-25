package com.wipro.SpringRest.exceptions;

public class UserAlreadyExistException extends Exception{
	public UserAlreadyExistException(String message)
	{
		super(message);
	}

}
