package com.User.User_Management_System.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.User.User_Management_System.UtilityClass.CheckValidation;

public class Validation implements Filter {
	
	 CheckValidation  val;
	public void init(FilterConfig fConfig) throws ServletException {
		val = new CheckValidation();
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
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
			request.setAttribute("message","*All Feilds are Required");
			rd.forward(request, response);
		}
		else if(address1==null||address2==null||pincode==null||city==null||state==null||country==null||language==null)
		{
			request.setAttribute("message","*All Feilds are Required");
			rd.forward(request, response);
		}
		for(int i=0;i<pincode.length;i++)
		{
			if(val.validateNumber(pincode[i]))
			{
				request.setAttribute("message","*Only Numbers are Allowed in pincode.");
				rd.forward(request, response);
			}
			else if(pincode[i].length()>6)
			{
				request.setAttribute("message","*Pincode not greater than 6 Digits.");
				rd.forward(request, response);
			}
			else if(val.validatename(city[i]))
			{
				request.setAttribute("message","*Only Alphabets are Allowed in City.");
				rd.forward(request, response);
			}
			else if(val.validatename(state[i]))
			{
				request.setAttribute("message","*Only Alphabets are Allowed in State.");
				rd.forward(request, response);
			}
			else if(val.validatename(country[i]))
			{
				request.setAttribute("message","*Only Alphabets are Allowed in Country.");
				rd.forward(request, response);
			}
			
		}
		if(val.validatename(fname))
		{
			request.setAttribute("message","*Only Alphabets are Allowed in FirstName.");
			rd.forward(request, response);
		}
		else if(val.validatename(lname))
		{
			request.setAttribute("message","*Only Alphabets are Allowed in LastName.");
			rd.forward(request, response);
		}
		else if(val.validatepwd(pwd))
		{
			request.setAttribute("message","*Please Choose Strong Password.");
			rd.forward(request, response);
		}
		else if(!pwd.equals(repwd))
		{
			request.setAttribute("message","*Confirm password Should be same as Password.");
			rd.forward(request, response);
		}
		else if(val.validatemail(email))
		{
			request.setAttribute("message","*Please Enter Valid Mail-Id.");
			rd.forward(request, response);
		}
		else if(val.validateNumber(phone))
		{
			request.setAttribute("message","*Only Numbers are Allowed in Phone.");
			rd.forward(request, response);
		}
		else if(phone.length()<10)
		{
			request.setAttribute("message","*Number not less than 10 Digits.");
			rd.forward(request, response);
		}
		else
		{
		chain.doFilter(request, response);
		}
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}
	

}
