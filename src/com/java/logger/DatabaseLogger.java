package com.java.logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseLogger {
	private static DatabaseLogger databaseLogger;
	private PreparedStatement ps;
	public DatabaseLogger() {
		Connection connection;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			ps=connection.prepareStatement("INSERT INTO loggers(exception_name,message,severity,class_name,method_name,curr_date) values(?,?,?,?,?,?)");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static DatabaseLogger getInstance() {
		if(databaseLogger!=null) {
			databaseLogger=new DatabaseLogger();
		}
		return databaseLogger;
	}
	
	public void logIntoDb(Exception ex, String msg, String severity, String className, String methodName, String sdf) {
		try {
			ps.setString(1, ex.getClass().getName());
			ps.setString(2, msg);
			ps.setString(3, severity);
			ps.setString(4, className);
			ps.setString(5, methodName);
			ps.setString(6,sdf);
			
			int res= ps.executeUpdate();
			if(res>0) {
				System.out.println("insertion success");
			}
			else {
				System.out.println("did not inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
