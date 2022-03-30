package com.User.User_Management_System.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import com.User.User_Management_System.Bean.UserImage;
import com.User.User_Management_System.Service.UserService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final int BUFFER_SIZE = 4096;
 
	UserService userservice;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String pwd = (String) request.getAttribute("password");
		String email=request.getParameter("email");
		RequestDispatcher r=request.getRequestDispatcher("index.jsp");
		User user = new User();
		user.setEmail(email);
		System.out.println(pwd);
			if(userservice.checkUser(user))
			{
				if(pwd.equals(user.getPassword()))
				{
					HttpSession session=request.getSession();
					String role = userservice.getRole(email);
					if(role.equals("user"))
					{
						List<UserAddress> useradd = new ArrayList<UserAddress>();
						useradd=userservice.getUserAdd(user.getUserID());
						session.setAttribute("UserAddress",useradd);
						
						List<UserImage> userimg = new ArrayList<UserImage>();
						userimg = userservice.getUserImg(user.getUserID());
						session.setAttribute("UserImages",userimg);
					 	session.setAttribute("user",user);
					 	RequestDispatcher rf=request.getRequestDispatcher("userDashBoard.jsp");
					 	rf.forward(request, response);
					 	//session.setAttribute("UserAddress", useradd);
			           // response.sendRedirect("userDashBoard.jsp");
					}
					else if(role.equals("admin"))
					{
						List<User> users = new ArrayList<User>();
						users = userservice.getUsers();
					 	request.setAttribute("UsersList",users);
					 	RequestDispatcher rf=request.getRequestDispatcher("adminDashBoard.jsp");
					 	rf.forward(request, response);
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
			request.setAttribute("message","*User Doesn't Exist");
			r.forward(request, response);
			}
		}
}
