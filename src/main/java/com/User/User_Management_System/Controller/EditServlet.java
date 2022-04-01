package com.User.User_Management_System.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Bean.UserAddress;
import com.User.User_Management_System.Bean.UserImage;
import com.User.User_Management_System.Service.UserService;
import com.User.User_Management_System.Service.UserServiceImpl;
@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = LogManager.getLogger(EditServlet.class.getName());
	UserService userservice;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserServiceImpl();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BasicConfigurator.configure();
		response.setContentType("text/html");
		String fname=request.getParameter("firstname");  
		
		String lname=request.getParameter("lastname"); 
		String phone=request.getParameter("phone");
		String birthdate=request.getParameter("birthdate");
		String gender=request.getParameter("Gender");
		String address1[]=request.getParameterValues("address1");
		String address2[]=request.getParameterValues("address2");
		String[] pincode=request.getParameterValues("pincode");
		String[] city=request.getParameterValues("city");
		String[] state=request.getParameterValues("state");
		String[] country=request.getParameterValues("country");
		String lang[]=request.getParameterValues("lang");
		
		String language="";
		for(int i=0;i< lang.length;i++){
			language+=lang[i]+" ";
		}
		long number = Long.parseLong(phone); 
		User user = new User();
		user.setFirstname(fname);
		user.setLastname(lname);
		user.setPhone(number);
		user.setDateofbirth(birthdate);
		user.setGender(gender);
		user.setLanguage(language);
		String uid=request.getParameter("userid");
		int userid=Integer.parseInt(uid);
		userservice.updateUserProfile(user,userid);
		//response.sendRedirect("userDashBoard.jsp");
		response.sendRedirect("UserData");
		//int userid=userservice.getUser(email);
//		UserAddress useraddress;
//		for(int i=0;i<address1.length;i++)
//		{
//				useraddress= new UserAddress();
//				useraddress.setUserid(userid);
//				useraddress.setAdd1(address1[i]);
//				useraddress.setAdd2(address2[i]);
//				useraddress.setPincode(pincode[i]);
//				useraddress.setCity(city[i]);
//				useraddress.setState(state[i]);
//				useraddress.setCountry(country[i]);
//				userservice.addUserAddress(useraddress);
//		}
		@SuppressWarnings("unchecked")
		ArrayList<Part> fileParts = (ArrayList) request.getParts().stream().filter(new Predicate<Part>() {
			public boolean test(Part part) {
			return "image[]".equals(part.getName()) && part.getSize() > 0;
		}
		}).collect(Collectors.toList()); 
	    InputStream inputStream = null;
		UserImage userimg=null;
        for (Part filePart : fileParts) {
            if (filePart != null && filePart.getSize() != 0) {
            	 userimg = new UserImage();
                inputStream = filePart.getInputStream();
                userimg.setUserid(userid);
                userimg.setImage(inputStream);
                userservice.addUserImg(userimg);
            }
        }
	}

}
