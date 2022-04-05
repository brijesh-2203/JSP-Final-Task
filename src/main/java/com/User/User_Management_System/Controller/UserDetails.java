package com.User.User_Management_System.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Service.UserService;
import com.User.User_Management_System.Service.UserServiceImpl;

public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = LogManager.getLogger(UserDetails.class.getName());

	UserService userservice;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserServiceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BasicConfigurator.configure();
		HttpSession session=request.getSession(false);
		User user = (User) session.getAttribute("USER");
		RequestDispatcher rf=request.getRequestDispatcher("registration.jsp");
		if(user.getRole().equals("user"))
		{
			request.setAttribute("user",user);
			log.info("Updated User set in Request");
		 	rf.forward(request, response);
		}
		else
		{
			String uid = request.getParameter("userid");
			int userid = Integer.parseInt(uid);
			User usr = userservice.getUserDetails(userid);
			request.setAttribute("user", usr);
			log.info("Updated User set in Request");
			rf.forward(request, response);
		}
		
	}

}
