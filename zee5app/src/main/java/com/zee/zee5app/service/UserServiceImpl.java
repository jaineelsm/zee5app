package com.zee.zee5app.service;

import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;
import com.zee.zee5app.repo.UserRepo;
import com.zee.zee5app.repo.UserRepoImpl;

public class UserServiceImpl implements UserService {
	
private UserRepo repo = UserRepoImpl.getInstance();
	
	
	private  UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserService userService;
	
	public static UserService getInstance() {
		// userRepo object
		
		if(userService == null) {
			userService = new UserServiceImpl();
			
		}
		
		return userService;
	}
	
	

	@Override
	public User insertUser(User user) throws UnableToGenerateIdException {
		// TODO Auto-generated method stub
//		return null;
		return repo.insertUser(user);
	}

	@Override
	public User updateUser(String userId, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User[] getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> getUserById(String userId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public String deleteUserById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
