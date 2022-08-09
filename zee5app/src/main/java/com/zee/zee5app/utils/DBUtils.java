package com.zee.zee5app.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.exceptions.UnableToConnectException;
import com.mysql.cj.xdevapi.DbDoc;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;

public class DBUtils {
	
//	public static void main(String[] args) {
//		DBUtils dbUtils = DBUtils.getInstance();
//		Properties properties =  dbUtils.loadPropeerties();
//		System.out.println(properties);
//	}
	

	private DBUtils() {
		// TODO Auto-generated constructor stub
	}

	private static DBUtils dbUtils;

	public static DBUtils getInstance() {
		// userRepo object

		if (dbUtils == null) {
			dbUtils = new DBUtils();

		}

		return dbUtils;
	}
	
	public Connection getConnection() {
		
		Properties properties = loadPropeerties();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.username"), properties.getProperty("db.password"));
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	because it can read the line and assign key and value
	private Properties loadPropeerties() {
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			//inputStream = new FileInputStream("application.properties");
			//inputStream = DBUtils.class.getResourceAsStream("classpath:application.properties");
			inputStream = DBUtils.class.getClassLoader().getResourceAsStream("application.properties");
			System.out.println(inputStream!=null);
			properties.load(inputStream);
			return properties;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				inputStream.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
//		properties.load();
		return properties;
	}
	public String idGenerator(String firstName, String lastName) throws UnableToGenerateIdException
	{
		// it is responsible to generate the userid for user entity
		//1st retrive the value (db stored value from idgen table)
		// take first char from firstname and lastname
		// then increament the number (id which is retrived from db)
		// then cancate and return
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int id = 0 ;
		String query = "select id from useridgenerator";
		String updateIdStatement = "update useridgenerator set id=?";
		int updateResult = 0;
		String newId = null;
		
		connection = this.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				id = resultSet.getInt(1);
			}
			// take 1st char from firstName and lastName
			id++;
			newId = firstName.charAt(0)+""+lastName.charAt(0)+""+id;
			System.out.println(newId);
			preparedStatement = connection.prepareStatement(updateIdStatement);
			preparedStatement.setInt(1, id);
			updateResult = preparedStatement.executeUpdate();
			if(updateResult==0)
			{
				throw new UnableToGenerateIdException("unable to generate id");
			}
			
			return newId;
			// then increemnt the number (id which is retreived from DB)
			// then cancate and return 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UnableToGenerateIdException("unable to generate id"+e.getMessage());
		}
		finally {
			this.closeConnection(connection);
		}
		
	}
	
	public static void main(String[] args) {
		String result = null;
		try {
			result = DBUtils.getInstance().idGenerator("abhi", "chivte");
		} catch (UnableToGenerateIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
	}

}
