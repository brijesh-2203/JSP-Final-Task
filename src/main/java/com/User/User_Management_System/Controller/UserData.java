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

public class UserData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = LogManager.getLogger(UserData.class.getName());

	UserService userservice;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserServiceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasicConfigurator.configure();
		HttpSession session=request.getSession(false);
		User user = (User) session.getAttribute("USER");
		if(user.getRole().equals("admin"))
		{
			response.sendRedirect("AdminWork");
		}
		else
		{
			user = userservice.checkUser(user.getEmail());
			session.setAttribute("USER", user);
			log.info("Updated User data stored in session");
			response.sendRedirect("userDashBoard.jsp");
		}
	}
}
