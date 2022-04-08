package com.User.User_Management_System.UtilityClass;

import java.sql.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConnectionSetup {
	static Logger log = LogManager.getLogger(ConnectionSetup.class.getName());
	public static Connection getConnection() throws SQLException,ClassNotFoundException
	   {
		   Connection connection=null; 
	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/UserManagementSystem","root","Brijesh163@");
	    } 
	   catch(Exception e)
	   {
		   log.fatal(e);
		} 
	   log.info("Connection setup Successfull");
	   return connection;
	   }
}
