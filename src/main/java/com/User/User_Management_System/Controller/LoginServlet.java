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

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	UserService userservice;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
					session.setAttribute("user",user);
					if(role.equals("user"))
					{
			           response.sendRedirect("userDashBoard.jsp");
					}
					else if(role.equals("admin"))
					{
						response.sendRedirect("AdminWork");
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
			request.setAttribute("message","*Unauthorized User");
			r.forward(request, response);
			}
		}
}
