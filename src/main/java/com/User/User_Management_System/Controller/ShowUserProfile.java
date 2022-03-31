package com.User.User_Management_System.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Bean.UserAddress;

public class ShowUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession(false);
		 User user = (User)session.getAttribute("user");
		 int id = user.getUserID();
		 String fname = user.getFirstname();
		 String lname = user.getLastname();
		 String email = user.getEmail();
		 Long phone = user.getPhone();
		 String dob = user.getDateofbirth();
		 String gender = user.getGender();
		 String lang = user.getLanguage();
		 ArrayList<UserAddress> add = user.getAddress();
		 out.println("Welcome "+fname+" "+lname+"<br>");
		 out.println("<br>ID:"+id);
		 out.println("<br>FirstName:"+fname);
		 out.println("<br>LastName:"+lname);
		 out.println("<br>Email:"+email);
		 out.println("<br>Phone:"+phone);
		 out.println("<br>DateOfBirth:"+dob);
		 out.println("<br>Gender:"+gender);
		 out.println("<br>Language Known:"+lang);
		 out.println("<br><a href='edit.html'>Edit Profile</a>");
		 out.println("<br><button>\r\n"
		 		+ " <a href=ShowOptions>Back</a></button>");
		 out.println(add);
		 for(UserAddress ud : add)
		 {
			 out.println(ud.getAdd1());
			 
		 }
	}

}
