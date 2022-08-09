package com.zee.zee5app.dto;

//import java.sql.Date;
import java.time.LocalDate;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
//@ToString(exclude = "userId")
//@AllArgsConstructor
public class User{ //implements Comparable<User> {
	
	static {
		System.out.println("hello static block");
	}
	{
		System.out.println("ini block");
	}
	public User() {
		// TODO Auto-generated constructor stub
		System.out.println("edc");
	}
	
	
	
	
	public User(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}




	public User(String userId, String firstName, String lastName, String email, LocalDate doj, LocalDate dob,
			boolean active) {
//		super();
		this(userId, firstName, lastName, email, doj, dob);
		this.active = active;
	}




	public User(String userId, String firstName, String lastName, String email, LocalDate doj, LocalDate dob) {
//		super();
		this(firstName, lastName, email);
		this.userId = userId;
		
		this.doj = doj;
		this.dob = dob;
	}




	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate doj;
	private LocalDate dob;
	private boolean active;
	
	
//	for comparable
//	@Override
//	public int compareTo(Object o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
	
	
//	for comparable<User>
//	@Override
//	public int compareTo(User o) {
//		// TODO Auto-generated method stub
//		return this.userId.compareTo(o.userId);
////		return 0;
//	}




	
}


