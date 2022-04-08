package com.User.User_Management_System.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Bean.UserAddress;
import com.User.User_Management_System.Bean.UserImage;
import com.User.User_Management_System.Service.UserAddressService;
import com.User.User_Management_System.Service.UserAddressServiceImpl;
import com.User.User_Management_System.Service.UserImageService;
import com.User.User_Management_System.Service.UserImageServiceImpl;
import com.User.User_Management_System.Service.UserService;
import com.User.User_Management_System.Service.UserServiceImpl;
@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = LogManager.getLogger(EditServlet.class.getName());
	UserService userservice;
	UserAddressService userAddressService;
	UserImageService userImageService;
	public void init(ServletConfig config) throws ServletException {
		userservice = new UserServiceImpl();
		userAddressService = new UserAddressServiceImpl();
		userImageService = new UserImageServiceImpl();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String addressid[]=request.getParameterValues("addid");
		
		String language="";
		if(lang!=null)
		{
			for(int i=0;i< lang.length;i++){
				language+=lang[i]+" ";
			}
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
		userservice.updateUserProfile(user,userid); //user profile updated
		
		List<UserAddress> useraddresses =userAddressService.getUserAddress(userid);
		int index=0;
		int old_Addressid[] = new int[useraddresses.size()];
		int address_id_length= addressid.length;
		int count=0;
		for(UserAddress ud:useraddresses)
		{	
			old_Addressid[index]=ud.getAddressid();
			if(count<address_id_length && addressid[count].length()!=0)
			{
				int addrssid=Integer.parseInt(addressid[count]);
				if(old_Addressid[index]==addrssid)
				{
					count++;
				}
				else
				{
					log.debug("Address deleted");
					userAddressService.deleteAddress(old_Addressid[index]);
				}
			}
			else
			{
				log.debug("Address deleted");
				userAddressService.deleteAddress(old_Addressid[index]);
			}
			index++;
		}
		for(int i=0;i<addressid.length;i++)
		{	
			UserAddress useraddress = new UserAddress();
			if(addressid[i].length()==0)     
			{
				//add new address of the user in address table
				useraddress.setUserid(userid);
				useraddress.setAdd1(address1[i]);
				useraddress.setAdd2(address2[i]);
				useraddress.setPincode(pincode[i]);
				useraddress.setCity(city[i]);
				useraddress.setState(state[i]);
				useraddress.setCountry(country[i]);
				userAddressService.addUserAddress(useraddress);
				log.debug("New Address added");
			}
			else
			{
				//Update  the User Address of the particular Address Id
 				int addrssid=Integer.parseInt(addressid[i]);
				useraddress.setUserid(userid);
				useraddress.setAddressid(addrssid);
				useraddress.setAdd1(address1[i]);
				useraddress.setAdd2(address2[i]);
				useraddress.setPincode(pincode[i]);
				useraddress.setCity(city[i]);
				useraddress.setState(state[i]);
				useraddress.setCountry(country[i]);
				userAddressService.updateUserAddress(useraddress);
				log.debug("Address Updated");
			}
		}
		//Image Addition to the user
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
                userImageService.addUserImg(userimg);
                log.debug("New Images added");
            }
        }
       response.sendRedirect("UserData");   
	}

}
