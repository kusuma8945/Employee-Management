package com.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.constant.Constants;

public class DBConnection {
	
	
	public static Connection connection;
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			if(connection==null) {
				connection=DriverManager.getConnection(Constants.URL,Constants.DBUSERNAME , Constants.DBPASSWORD);
				return connection;
			}
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
