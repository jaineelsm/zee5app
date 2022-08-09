package com.zee.zee5app.repo;

import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;

public interface UserRepo {
	public User insertUser(User user) throws UnableToGenerateIdException;
	public User updateUser(String userId, User user);
	public String deleteUser(String userId) throws NoDataFoundException;
	public Optional<User[]> getAllUsers();
	public Optional<User> getUserById(String userId);
	public String deleteUserById(String userId);
	

}
