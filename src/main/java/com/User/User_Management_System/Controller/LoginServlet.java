package com.User.User_Management_System.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Service.UserService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	UserService userservice;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String pwd = (String) request.getAttribute("password");
		String role=request.getParameter("role");  
		String email=request.getParameter("email");
		if(role=="admin")
		{
			
		}
		else if(role=="user")
		{
			User user = new User();
			user.setEmail(email);
			user.setPassword(pwd);
			if(userservice.checkUser(user))
			{
				
			}
		}
		else
		{
			
		}
	}

}
