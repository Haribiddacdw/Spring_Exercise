package com.example.exception;

/* 
 * InsufficientBalanceException Class 
 * */
 public class InsufficientBalanceException extends Exception{
	String errorMessage;

	public InsufficientBalanceException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return errorMessage;
	}
}
