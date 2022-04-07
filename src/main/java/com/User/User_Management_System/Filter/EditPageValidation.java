package com.User.User_Management_System.Filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Bean.UserAddress;
import com.User.User_Management_System.Bean.UserImage;
import com.User.User_Management_System.Service.UserAddressService;
import com.User.User_Management_System.Service.UserAddressServiceImpl;
import com.User.User_Management_System.Service.UserImageService;
import com.User.User_Management_System.Service.UserImageServiceImpl;
import com.User.User_Management_System.UtilityClass.CheckValidation;
@MultipartConfig
public class EditPageValidation implements Filter {
	 CheckValidation  val;
	 UserImageService userImageService;
	 UserAddressService userAddressService;
		public void init(FilterConfig fConfig) throws ServletException {
			val = new CheckValidation();
			userImageService = new UserImageServiceImpl();
			userAddressService = new UserAddressServiceImpl();
		}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
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
		String language[]=request.getParameterValues("lang");
    
		User user = new User();
		user.setFirstname(fname);
		user.setLastname(lname);
		if(val.validateNumber(phone))
		{
			request.setAttribute("phonenumber",phone);
		}
		else {
		 user.setPhone(Long.parseLong(phone));
		}
		user.setDateofbirth(birthdate);
		user.setGender(gender);
		String lang="";
		if(language!=null)
		{
			for(int i=0;i< language.length;i++){
				lang+=language[i]+" ";
			}
		}
		user.setLanguage(lang);
		
		 String uid = request.getParameter("userid");
			int userid = Integer.parseInt(uid);
		ArrayList<UserAddress> list = (ArrayList<UserAddress>) userAddressService.getUserAddress(userid);
		user.setAddress(list);
       
		ArrayList<UserImage> imagelist =(ArrayList<UserImage>) userImageService.getUserImg(userid);
		user.setImage(imagelist);
		RequestDispatcher rd=request.getRequestDispatcher("registration.jsp"); 
		request.setAttribute("user",user);
		
		if(fname.equals("")||lname.equals("")||phone.equals("")||birthdate.equals("")||gender.equals(""))
		{
			request.setAttribute("message","*All Feilds are Required");
			rd.forward(request, response);
		}
		else if(address1==null||address2==null||pincode==null||city==null||state==null||country==null||language==null)
		{
			request.setAttribute("message","*All Feilds are Required");
			rd.forward(request, response);
		}
		else
		{
		for(int i=0;i<pincode.length;i++)
		{
			if(address1[i].equals("") || address2[i].equals("") || city[i].equals("") || state[i].equals("") || country[i].equals(""))
			{
				request.setAttribute("message","*All Address Fields are Required.");
				rd.forward(request, response);
			}
			else if(val.validateNumber(pincode[i]))
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

	public UserImage uploadedImages(UserImage userimg)
	{
		 System.out.println("images");
    	 InputStream inputStream = userimg.getImage();
    	 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    	 byte[] buffer = new byte[4096];
    	 int bytesRead = -1;
    	  
    	 try {
			while ((bytesRead = inputStream.read(buffer)) != -1) {
			     outputStream.write(buffer, 0, bytesRead);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 byte[] imageBytes = outputStream.toByteArray();
    	  
    	 String base64Image = Base64.getEncoder().encodeToString(imageBytes);
    	 UserImage user=new UserImage();
    	 user.setBase64Image(base64Image); 
		return user;
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
