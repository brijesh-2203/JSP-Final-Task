package com.User.User_Management_System.UtilityClass;

import java.sql.*;

public class ConnectionSetup {
	public static Connection getConnection() throws SQLException,ClassNotFoundException
	   {
		   Connection connection=null; 
	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/UserManagementSystem","root","Brijesh163@");
	    } 
	   catch(Exception e)
	   {
		   System.out.println(e);
		} 
	   return connection;
	   }
}
