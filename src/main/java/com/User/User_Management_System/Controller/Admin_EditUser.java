package com.User.User_Management_System.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Service.UserService;

/**
 * Servlet implementation class Admin_EditUser
 */
public class Admin_EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userservice;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String mail = request.getParameter("usermail");
		User user = userservice.checkUser(mail);
		request.setAttribute("user", user);
		RequestDispatcher r=request.getRequestDispatcher("registration.jsp");
		r.forward(request, response);
		//response.sendRedirect("registration.jsp");
	}

}
