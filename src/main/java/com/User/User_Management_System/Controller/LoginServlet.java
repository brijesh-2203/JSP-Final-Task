package com.User.User_Management_System.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Bean.UserAddress;
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
		User user = new User();
		user.setEmail(email);
		user.setPassword(pwd);
		user.setRole(role);
		if(role.equals("admin"))
		{
			out.print("hello admin");
			if(userservice.checkUser(user))
			{
				HttpSession session=request.getSession();
				List<User> users = new ArrayList<User>();
				users = userservice.getUsers();
			 	request.setAttribute("UsersList",users);
			 	RequestDispatcher r=request.getRequestDispatcher("adminDashBoard.jsp");
			 	r.forward(request, response);
	            //response.sendRedirect("adminDashBoard.jsp");
			}
			else
			{
			RequestDispatcher r=request.getRequestDispatcher("/index.jsp");
			request.setAttribute("message","Invalid UserName or Password");
			r.forward(request, response);	
			}
		}
		else if(role.equals("user"))
		{
			out.print("hello user");
			if(userservice.checkUser(user))
			{
				HttpSession session=request.getSession();
				List<UserAddress> useradd = new ArrayList<UserAddress>();
				useradd=userservice.getUserAdd(user.getUserID());
				session.setAttribute("UserAddress",useradd);
			 	session.setAttribute("User",user);
			 	//session.setAttribute("UserAddress", useradd);
	            response.sendRedirect("userDashBoard.jsp");
			}
			else
			{
			RequestDispatcher r=request.getRequestDispatcher("/index.jsp");
			request.setAttribute("message","*Invalid UserName or Password");
			r.forward(request, response);
			
			}
		}
		else
		{
			RequestDispatcher r=request.getRequestDispatcher("/index.jsp");
			request.setAttribute("message","*Please Select Role");
			r.forward(request, response);
			
		}
//		RequestDispatcher r=request.getRequestDispatcher("/index.jsp");
//		request.setAttribute("message","");
//		r.forward(request, response);
		//request.setAttribute("message","");
	}

}
