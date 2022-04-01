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

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Dao.UserDao;
import com.User.User_Management_System.Dao.UserDaoImpl;
import com.User.User_Management_System.Service.UserService;
import com.User.User_Management_System.Service.UserServiceImpl;

public class Admin_EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = LogManager.getLogger(Admin_EditUser.class.getName());
	UserService userservice;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserServiceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasicConfigurator.configure();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("userid");
		int userid = Integer.parseInt(uid);
		User user = userservice.getUserDetails(userid);
		log.info("user profile updated");
		request.setAttribute("user", user);
		RequestDispatcher r=request.getRequestDispatcher("registration.jsp");
		r.forward(request, response);
		//response.sendRedirect("registration.jsp");
	}

}
