package com.zee.zee5app.exceptions;

public class InvalidIdException extends Exception {
//	should have tostring and super call
	
	public InvalidIdException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
