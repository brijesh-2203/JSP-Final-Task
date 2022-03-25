package com.User.User_Management_System.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	//	Validation val = new Validation();
		String fname=request.getParameter("firstname");  
		String lname=request.getParameter("lastname");
		String email=request.getParameter("email"); 
		String phone=request.getParameter("phone");
		String pwd=request.getParameter("password");
		String repwd=request.getParameter("repass");
		String birthdate=request.getParameter("birthdate");
		String ans1=request.getParameter("q1");
		String ans2=request.getParameter("q2");
		//String image[]=request.getParameterValues("photo");
		String gender=request.getParameter("Gender");
		String address[]=request.getParameterValues("address");
		String[] pincode=request.getParameterValues("pincode");
		String[] city=request.getParameterValues("city");
		String[] state=request.getParameterValues("state");
		String[] country=request.getParameterValues("country");
		String language[]=request.getParameterValues("lang");
		
		out.println("fname: "+fname);
		out.println("lname: "+lname);
		out.println("email: "+email);
		out.println("phone: "+phone);
		out.println("pwd: "+pwd);
		out.println("repwd: "+repwd);
		out.println("Birthdate: "+birthdate);
		out.println("Ans1: "+ans1);
		out.println("Ans2: "+ans2);
		//out.println("Image: "+image);
		out.println("Gender: "+gender);
		
		 InputStream inputStream = null;
		 
	        Part filePart = request.getPart("photo");
	  
	        if (filePart != null) 
	        {      
	                filePart.getName();
	                filePart.getSize();
	                filePart.getContentType();
	  
	            inputStream = filePart.getInputStream();
	        }
//		for(int i=0;i<image.length;i++)
//		{
//			out.println("Images "+(i+1)+": "+image[i]);
//		}
		for(int i=0;i<language.length;i++)
		{
			out.println("language "+(i+1)+": "+language[i]);
		}
		for(int i=0;i<address.length;i++)
		{
			out.println("address "+(i+1)+": "+address[i]);
		}
		for(int i=0;i<pincode.length;i++)
		{
			out.println("pincode "+(i+1)+": "+pincode[i]);
		}
		for(int i=0;i<city.length;i++)
		{
			out.println("city "+(i+1)+": "+city[i]);
		}
		for(int i=0;i<state.length;i++)
		{
			out.println("state "+(i+1)+": "+state[i]);
		}
		for(int i=0;i<country.length;i++)
		{
			out.println("country "+(i+1)+": "+country[i]);
		}
		
		//RequestDispatcher rd=request.getRequestDispatcher("index2.html"); 
	}

}
