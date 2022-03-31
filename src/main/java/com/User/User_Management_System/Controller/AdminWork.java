package com.User.User_Management_System.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Service.UserService;

public class AdminWork extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService userservice;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = new ArrayList<User>();
		users = userservice.getUsers();
	 	request.setAttribute("UsersList",users);
	 	RequestDispatcher rf=request.getRequestDispatcher("adminDashBoard.jsp");
	 	rf.forward(request, response);
	}

}
