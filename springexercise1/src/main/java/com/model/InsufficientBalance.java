package com.model;

public class InsufficientBalance extends Exception {
    
	
	private String messsage;
	
	public InsufficientBalance(String string) {
		 messsage = string;
	}

	@Override
	public String toString() {
		return "InsufficientBalance [messsage=" + messsage + "]";
	}
    
	
}
