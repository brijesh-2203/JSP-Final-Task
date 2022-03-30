package com.User.User_Management_System.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.User.User_Management_System.UtilityClass.CheckValidation;

@MultipartConfig
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CheckValidation  val;
	public void init(ServletConfig config) throws ServletException {
		val = new CheckValidation();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fname=request.getParameter("firstname");  
		String lname=request.getParameter("lastname");
		String email=request.getParameter("email"); 
		String phone=request.getParameter("phone");
		String pwd=request.getParameter("password");
		String repwd=request.getParameter("repass");
		String birthdate=request.getParameter("birthdate");
		String ans1=request.getParameter("q1");
		String ans2=request.getParameter("q2");
		String gender=request.getParameter("Gender");
		String address1[]=request.getParameterValues("address1");
		String address2[]=request.getParameterValues("address2");
		String[] pincode=request.getParameterValues("pincode");
		String[] city=request.getParameterValues("city");
		String[] state=request.getParameterValues("state");
		String[] country=request.getParameterValues("country");
		String language[]=request.getParameterValues("lang");
		
		
RequestDispatcher rd=request.getRequestDispatcher("registration.jsp"); 
		
		if(fname == ""||pwd ==""||lname==""||email==""||phone==""||repwd==""||birthdate==""||ans1==""||ans2==""||gender=="")
		{
			rd.include(request, response);
			out.println("<span style='color:Red'>*All Feilds are Required</span>");
		}
		else if(address1.length==0||address2.length==0||pincode.length==0||city.length==0||state.length==0||country.length==0||language.length==0)
		{
			rd.include(request, response);
			out.println("<span style='color:Red'>*All Feilds are Required</span>");
		}
		else if(val.validatename(fname))
		{
			rd.include(request, response);
			out.print("<span style='color:red'>*Only Alphabets are Allowed in FirstName.</span>");
		}
		else if(val.validatename(lname))
		{
			rd.include(request, response);
			out.print("<span style='color:red'>*Only Alphabets are Allowed in LastName.</span>");
		}
		else if(val.validatepwd(pwd))
		{
			rd.include(request, response);
			out.print("Password:<span style='color:red'>*Please Choose Strong Password.</span>"); 
		}
		else if(!pwd.equals(repwd))
		{
			rd.include(request, response);
			out.print("Password:<span style='color:red'>*Confirm password Should be same as Password.</span>"); 
		}
		else if(val.validatemail(email))
		{
			rd.include(request, response);
			out.print("E-mail:<span style='color:red'>*Please Enter Valid Mail-Id.</span>"); 
		}
		else if(phone.length()<10)
		{
			rd.include(request, response);
			out.print("<span style='color:red'>*Number not less than 10 Digits.</span>");
		}
		else
		{
			RequestDispatcher rf=request.getRequestDispatcher("UserRegistration"); 
			rf.forward(request, response);
		}
	}

}
