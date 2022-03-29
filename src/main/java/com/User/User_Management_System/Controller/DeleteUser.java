package com.User.User_Management_System.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.User.User_Management_System.Service.UserService;


public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    UserService userservice;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uid=request.getParameter("userid"); 
		int userid = Integer.parseInt(uid);
		userservice.deleteUser(userid);
		response.sendRedirect("adminDashBoard.jsp");
	}

}
