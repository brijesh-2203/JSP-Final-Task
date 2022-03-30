package com.User.User_Management_System.Service;

import com.User.User_Management_System.Bean.User;

import com.User.User_Management_System.Bean.UserAddress;
import com.User.User_Management_System.Bean.UserImage;
import com.User.User_Management_System.Dao.UserDao;

import java.util.*;
public class UserService{
		UserDao userdao = new UserDao();
	public boolean userExist(String mail)
	{
		boolean status = userdao.userExist(mail);
		return status;
	}
	public void registerUser(User user)
	{
		userdao.registerUser(user);
	}
	public void addUserAddress(UserAddress useradd)
	{
		userdao.addUserAddress(useradd);
	}
	public int getUser(String mail)
	{
		int id = userdao.getUserId(mail);
		return id;
	}
	public void addUserImg(UserImage userimg)
	{
		userdao.addUserImage(userimg);
	}
	public boolean checkUser(User user)
	{
		boolean status = userdao.validUser(user);
		return status;
	}
	public String getRole(String mail)
	{
		String role = userdao.getRole(mail);
		return role;
	}
	public List<User> getUsers()
	{
		List<User> userlist = new ArrayList<User>();
		userlist = userdao.getUserDetails();
		return userlist;
	}
	public List<UserAddress> getUserAdd(int userid)
	{
		List<UserAddress> userlist = new ArrayList<UserAddress>();
		userlist = userdao.getUserAddress(userid);
		return userlist;
	}
	public void deleteUser(int userid)
	{
		userdao.deleteUser(userid);
	}
	public List<UserImage> getUserImg(int userid)
	{
		List<UserImage> userlist = new ArrayList<UserImage>();
		userlist = userdao.getUserImg(userid);
		return userlist;
	}
	public void deleteImage(int imgid)
	{
		userdao.deleteImage(imgid);
	}
	public void changePwd(String pwd,String usermail) {
		
		userdao.changePwd(pwd,usermail);
	}
}
