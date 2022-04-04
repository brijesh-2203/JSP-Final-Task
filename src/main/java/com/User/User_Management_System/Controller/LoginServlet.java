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
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 static Logger log = LogManager.getLogger(LoginServlet.class.getName()); 
	UserService userservice;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserServiceImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 BasicConfigurator.configure(); 
		response.setContentType("text/html");
		String pwd = (String) request.getAttribute("password");
		String email=request.getParameter("email");
		RequestDispatcher r=request.getRequestDispatcher("index.jsp");
		User user = userservice.checkUser(email);
			if(user!=null)
			{
				if(pwd.equals(user.getPassword()))
				{
					HttpSession session=request.getSession();
					String role = userservice.getRole(email);
					session.setAttribute("USER",user);
					if(role.equals("user"))
					{
			           response.sendRedirect("userDashBoard.jsp");
			          // log.info("User-logged-in");  
					}
					else
					{
						response.sendRedirect("AdminWork");
						//log.info("Admin-logged-in");  
					}
				}
				else
				{
					request.setAttribute("message","*Invalid Password");
					r.forward(request, response);
				}
			}
			else
			{
				log.error("Login fail"); 
				request.setAttribute("message","*Unauthorized User");
				r.forward(request, response);
			}
		}
}
