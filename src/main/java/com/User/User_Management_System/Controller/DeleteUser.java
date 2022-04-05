package com.User.User_Management_System.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.User.User_Management_System.Service.UserService;
import com.User.User_Management_System.Service.UserServiceImpl;


public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = LogManager.getLogger(DeleteUser.class.getName());
    UserService userservice;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserServiceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasicConfigurator.configure();
		response.setContentType("text/html");
		String uid=request.getParameter("userid"); 
		log.info(uid);
		int userid = Integer.parseInt(uid);
		userservice.deleteUser(userid);
		log.info("User deleted of userid:"+userid);
//		response.sendRedirect("AdminWork");
	}

}
