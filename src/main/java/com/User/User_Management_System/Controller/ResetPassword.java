package com.User.User_Management_System.Controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.User.User_Management_System.Service.UserService;

public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	UserService userservice;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = (String) request.getAttribute("password");
		
		String usermail = request.getParameter("usermail");
		System.out.println(pwd);
		System.out.println(usermail);
		userservice.changePwd(pwd,usermail);
		response.sendRedirect("index.jsp");
	}

}
