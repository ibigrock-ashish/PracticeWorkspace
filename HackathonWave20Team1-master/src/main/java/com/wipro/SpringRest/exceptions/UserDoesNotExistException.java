package com.wipro.SpringRest.exceptions;

public class UserDoesNotExistException extends Exception{
	public UserDoesNotExistException(String message)
	{
		super(message);
	}

}
