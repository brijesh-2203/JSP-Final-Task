package com.User.User_Management_System.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.User.User_Management_System.Bean.UserImage;
import com.User.User_Management_System.Dao.UserImageDao;
import com.User.User_Management_System.Dao.UserImageDaoImpl;

public class UserImageServiceImpl implements UserImageService{
	static Logger log = LogManager.getLogger(UserImageServiceImpl.class.getName());
	UserImageDao userImageDao = new UserImageDaoImpl();
	public void addUserImg(UserImage userimg)
	{
		log.info("User Image service,addUserImg methods call");
		userImageDao.addUserImage(userimg);
	}
	public void deleteImage(int imgid)
	{
		log.info("User Image service,deleteImage methods call");
		userImageDao.deleteImage(imgid);
	}
	public ArrayList<UserImage> getUserImg(int userid)
	{
		log.info("User Image service,getUserImg methods call");
		List<UserImage> userimglist = userImageDao.getUserImg(userid);
		return (ArrayList<UserImage>)userimglist;
		
	}
}
