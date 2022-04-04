package com.User.User_Management_System.Service;

import com.User.User_Management_System.Bean.User;


import com.User.User_Management_System.Bean.UserAddress;
import com.User.User_Management_System.Bean.UserImage;
import com.User.User_Management_System.Dao.*;

import java.util.*;
public interface UserService{
	public boolean userExist(String mail);
	public void registerUser(User user);
	public void addUserAddress(UserAddress useradd);
	public int getUser(String mail);
	public void addUserImg(UserImage userimg);
	public User checkUser(String email);
	public String getRole(String mail);
	public List<User> getUsers();
	public void deleteUser(int userid);
	public void deleteImage(int imgid);
	public void changePwd(String pwd,String usermail);
	public void updateUserProfile(User user,int userid);
	public User getUserDetails(int userid);
	public void updateUserAddress(UserAddress useradd);
	public List<UserAddress> getUserAddress(int userid);
	public void deleteAddress(int addid);
}
