package com.User.User_Management_System.Service;

import java.util.ArrayList;
import java.util.List;

import com.User.User_Management_System.Bean.*;
import com.User.User_Management_System.Dao.*;

public class UserServiceImpl implements UserService{
	UserDao userdao = new UserDaoImpl();
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
		public User checkUser(String email)
		{
			User user = userdao.validUser(email);
			return user;
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
		public void deleteUser(int userid)
		{
			userdao.deleteUser(userid);
		}
		public void deleteImage(int imgid)
		{
			userdao.deleteImage(imgid);
		}
		public void changePwd(String pwd,String usermail) {
			
			userdao.changePwd(pwd,usermail);
		}
		public void updateUserProfile(User user,int userid)
		{
			userdao.updateUserProfile(user,userid);
		}
		public User getUserDetails(int userid)
		{
			User user = userdao.getUserDetails(userid);
			return user;
		}
}
