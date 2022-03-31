package com.User.User_Management_System.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Service.UserService;

public class UserData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userservice;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		User user = (User) session.getAttribute("user");
		if(user.getFirstname().equals("Admin"))
		{
			response.sendRedirect("AdminWork");
		}
		else
		{
			user = userservice.checkUser(user.getEmail());
			session.setAttribute("user", user);
			response.sendRedirect("userDashBoard.jsp");
		}
	}
}
