package com.User.User_Management_System.Controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.User.User_Management_System.Service.UserService;
import com.User.User_Management_System.Service.UserServiceImpl;

public class CheckUserExist extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserService userservice;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserServiceImpl();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email"); 
		if(userservice.userExist(email))
		{
			response.getWriter().print("*Email already exist");
		}
	}

}
