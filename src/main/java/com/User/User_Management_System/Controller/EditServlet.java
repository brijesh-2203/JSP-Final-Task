package com.User.User_Management_System.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
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
		String addressid[]=request.getParameterValues("addid");
		
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
		userservice.updateUserProfile(user,userid); //user profile updated
		
		List<UserAddress> useraddresses =userservice.getUserAddress(userid);
		int index=0;
		int current_Addressid[] = new int[useraddresses.size()];
		//int new_Addressid[] = new int[useraddresses.size()];
		int address_id_length= addressid.length;
		int count=0;
		for(UserAddress ud:useraddresses)
		{	
			current_Addressid[index]=ud.getAddressid();
			if(count<address_id_length && addressid[count].length()!=0)
			{
				int addrssid=Integer.parseInt(addressid[count]);
				if(current_Addressid[index]==addrssid)
				{
					log.info("Address id matched"+current_Addressid[index]);
					//new_Addressid[index]=addrssid;
					count++;
				}
				else
				{
					userservice.deleteAddress(current_Addressid[index]);
					//new_Addressid[index]=0;
				}
			}
			else
			{
				userservice.deleteAddress(current_Addressid[index]);
				//new_Addressid[index]=0;
			}
			index++;
		}
//		for(int i=0;i<current_Addressid.length;i++)
//		{
//			if(current_Addressid[i] != new_Addressid[i])
//			{
//				userservice.deleteAddress(current_Addressid[i]);
//				log.info("Address deleted of id:"+current_Addressid[i]);
//			}
//			else
//			{
//				log.info("Address not deleted of id:"+current_Addressid[i]);
//			}
//		}
		
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
				userservice.addUserAddress(useraddress);
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
				userservice.updateUserAddress(useraddress);
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
                userservice.addUserImg(userimg);
            }
        }
        response.sendRedirect("UserData");
	}

}
