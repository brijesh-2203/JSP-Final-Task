package com.User.User_Management_System.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.User.User_Management_System.Bean.*;
import com.User.User_Management_System.Dao.*;

public class UserServiceImpl implements UserService{
	static Logger log = LogManager.getLogger(UserServiceImpl.class.getName());
	UserDao userdao = new UserDaoImpl();
		public boolean userExist(String mail)
		{
			log.info("User service,userExist methods call");
			boolean status = userdao.userExist(mail);
			return status;
		}
		public void registerUser(User user)
		{
			log.info("User service,registerUser methods call");
			userdao.registerUser(user);
		}
		public int getUser(String mail)
		{
			log.info("User service,getUser methods call");
			int id = userdao.getUserId(mail);
			return id;
		}
		public User checkUser(String email)
		{
			log.info("User service,checkUser methods call");
			User user = userdao.validUser(email);
			return user;
		}
		public String getRole(String mail)
		{
			log.info("User service,getRole methods call");
			String role = userdao.getRole(mail);
			return role;
		}
		public List<User> getUsers()
		{
			log.info("User service,getUsers methods call");
			List<User> userlist = new ArrayList<User>();
			userlist = userdao.getUserList();
			return userlist;
		}
		public void deleteUser(int userid)
		{
			log.info("User service,deleteUser methods call");
			userdao.deleteUser(userid);
		}
		public void changePwd(String pwd,String usermail) {
			log.info("User service,changePwd methods call");
			userdao.changePwd(pwd,usermail);
		}
		public void updateUserProfile(User user,int userid)
		{
			log.info("User service,updateUserProfile methods call");
			userdao.updateUserProfile(user,userid);
		}
		public User getUserDetails(int userid)
		{
			log.info("User service,getUserDetails methods call");
			User user = userdao.getUserDetails(userid);
			return user;
		}
}
