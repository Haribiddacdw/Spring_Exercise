package com.example.exception;

/* 
 * 
 * InvalidUser Exception Class 
 * */
 
public class InvalidUserException extends Exception{
	String errorMessage;
	public InvalidUserException(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return errorMessage;
	}
}
