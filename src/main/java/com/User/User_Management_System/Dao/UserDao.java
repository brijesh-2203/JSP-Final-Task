package com.User.User_Management_System.Dao;

import java.util.List;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Bean.UserAddress;
import com.User.User_Management_System.Bean.UserImage;

public interface UserDao {
	public boolean userExist(String mail);
	public void registerUser(User user);
	public int getUserId(String mail);
	public void addUserAddress(UserAddress add);
	public void addUserImage(UserImage img);
	public String getRole(String mail);
	public List<User> getUserDetails();
	public List<UserAddress> getUserAddress(int userid);
	public List<UserImage> getUserImg(int userid);
	public void deleteUser(int userid);
	public void deleteImage(int imgid);
	public void changePwd(String pwd, String usermail); 
	public void updateUserProfile(User user,int userid);
	public User validUser(String email);
}
