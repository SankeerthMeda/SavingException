package com.java.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger {
	private static FileLogger fileLogger;
	private PrintWriter pw;
	
	public FileLogger() {
		FileWriter fw=null;
		try {
			fw = new FileWriter("Exceptions.txt", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw=new PrintWriter(fw);
		
	}
	
	public static FileLogger getInstance() {
		if(fileLogger==null) {
			fileLogger=new FileLogger();
		}
		return fileLogger;
	}
	
	public void logIntoFile(Exception ex, String msg, String severity, String className, String methodName, String sdf) {
		pw.println(ex.getClass().getName()+","+msg+","+
				severity+","+className+","+methodName+","+sdf);
		pw.flush();
	}
}
