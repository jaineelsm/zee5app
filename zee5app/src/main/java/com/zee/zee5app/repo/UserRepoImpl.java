package com.zee.zee5app.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.IdComparator;

public class UserRepoImpl implements UserRepo {
	
	
	private UserRepoImpl() {
      // TODO Auto-generated constructor stub
  }
  
//	private List<User> users = new LinkedList<>();
	
	
  private static UserRepo userRepo;
  
  public static UserRepo getInstance() {
      // userRepo object
      
      if(userRepo == null) {
          userRepo = new UserRepoImpl();
          
      }
      
      return userRepo;
  }
	
	
	
	
	
	
	private DBUtils dbUtils = DBUtils.getInstance();
	
	
	

	@Override
	public User insertUser(User user) throws UnableToGenerateIdException {
		// TODO Auto-generated method stub
//		connection object
		Connection connection = null;
		PreparedStatement preparableStatement = null;
		String insertStament = "insert into user_table(userid, firstname,"
				+ "lastname,email,"
				+ "doj,dob,active) values(?,?,?,?,?,?,?)";
		connection = dbUtils.getConnection();
	
//		Statement object(prepared)
		try {
			preparableStatement = connection.prepareStatement(insertStament);
			preparableStatement.setString(1, dbUtils.idGenerator(user.getFirstName(), user.getLastName()));
			preparableStatement.setString(2, user.getFirstName());
			preparableStatement.setString(3, user.getLastName());
			preparableStatement.setString(4, user.getEmail());
//			preparableStatement.setDate(5	, new Date(user.getDoj().toEpochDay()));
//			preparableStatement.setDate(6, new Date(user.getDob().toEpochDay()));
			preparableStatement.setDate(5	, Date.valueOf(user.getDoj()));
			preparableStatement.setDate(6, Date.valueOf(user.getDob()));
			preparableStatement.setBoolean(7, user.isActive());
			int result = preparableStatement.executeUpdate();
			if(result>0) {
//				System.out.println("sdbhsdbcjsajn");
				return user;
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeConnection(connection);
		}
		
//		we should get the result base on that we will return the result
		
		
		
		return null;
	}

	@Override
	public User updateUser(String userId, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(String userId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User[]> getAllUsers() {
		// TODO Auto-generated method stub
		return Optional.empty();
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
	
	
	
	
//	private UserRepoImpl() {
//        // TODO Auto-generated constructor stub
//    }
//    
//	private List<User> users = new LinkedList<>();
//	
//	
//    private static UserRepo userRepo;
//    
//    public static UserRepo getInstance() {
//        // userRepo object
//        
//        if(userRepo == null) {
//            userRepo = new UserRepoImpl();
//            
//        }
//        
//        return userRepo;
//    }
//	
//	
//	
//
//	@Override
//	public User insertUser(User user) {
//		// TODO Auto-generated method stub
//		
//		users.contains(user);
//		
//		
//		boolean result  = users.add(user);
//		Collections.sort(users);
//		Collections.sort(users, new IdComparator());
//		if(result) {
//			return user;
//		}
//		return null;
//		
//		
////		return null;
//	}
//
//	@Override
//	public User updateUser(String userId, User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String deleteUser(String userId) throws NoDataFoundException {
//		// TODO Auto-generated method stub
//		Optional<User> optional = this.getUserById(userId);
//		
//		
//		
//		if(optional.isPresent()) {
//			users.remove(optional.get());
////			return Optional.of().get();
//			return "success";
//		
//			
//		}else {
//			throw  new NoDataFoundException("no data found");
//			
//		}
////		return null;
//	}
//
//	@Override
//	public Optional<User[]> getAllUsers() {
//		// TODO Auto-generated method stub
//		if(this.users.isEmpty()) {
//			return Optional.empty();
//		}
//		
//		User[] users = new User[this.users.size()];
//		this.users.toArray(users);
//		return Optional.of(users);
//		
//		
////		return null;
//	}
//
//	@Override
//	public Optional<User> getUserById(String userId) {
//		// TODO Auto-generated method stub
//		for (User user : users) {
//			if(user!=null && userId.equals(user.getUserId())) {
//				return Optional.of(user);
//			}
//		}
//		return Optional.empty();
////		return null;
//	}
//
//
//
//
//	@Override
//	public String deleteUserById(String userId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
