
package com.java.client;

import java.util.Scanner;

import com.java.ioccontainer.DependencyInjector;
import com.java.logger.DatabaseLogger;
import com.java.logger.FileLogger;

public class Application {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("current working directory : "+System.getProperty("user.dir"));
		FileLogger fileLogger = DependencyInjector.getInstance().createInstance(FileLogger.class);
		DatabaseLogger databaseLogger = DependencyInjector.getInstance().createInstance(DatabaseLogger.class);
		
//		Class<?> classfileLogger =  Class.forName("FileLogger");
//		FileLogger fileLogger = (FileLogger) DependencyInjector.getInstance().createInstance(classfileLogger);
//		Class<?> classdbLogger =  Class.forName("com.java.logger.DatabaseLogger");
//		DatabaseLogger databaseLogger = (DatabaseLogger) DependencyInjector.getInstance().createInstance(classdbLogger);
		
		try {
			throw new ArithmeticException("Arithmetic Exception occured");
		}
		catch(Exception e) {
			System.out.println("Where do you want to save exception");
			System.out.println("1-> In file");
			System.out.println("2-> In database");
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				fileLogger.logIntoFile(e, e.getMessage(), "major", "Application", "main", "04-08-2023");
				break;
			case 2:
				databaseLogger.logIntoDb(e, e.getMessage(), "major", "Application", "main", "04-08-2023");
			default:
				System.exit(0);
			}
			sc.close();
			
		}

	}

}
