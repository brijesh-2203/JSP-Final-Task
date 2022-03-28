package com.User.User_Management_System.Service;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Bean.UserAddress;
import com.User.User_Management_System.Bean.UserImage;
import com.User.User_Management_System.Dao.UserDao;
import java.util.*;
public class UserService{
		UserDao userdao = new UserDao();
	public String registerUser(User user)
	{
		String message = userdao.registerUser(user);
		return message;
	}
	public void addUserAddress(List<UserAddress> list)
	{
		userdao.addUserAddress(list);
	}
	public int getUser(String mail)
	{
		int id = userdao.getUserId(mail);
		return id;
	}
	public void addUserImg(List<UserImage> list)
	{
		userdao.addUserImage(list);
	}
	public boolean checkUser(User user)
	{
		boolean status = userdao.validUser(user);
		return status;
	}
}
