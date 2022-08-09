package com.zee.zee5app.exceptions;

public class InvalidNameException extends Exception {
	
	public InvalidNameException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
