package com.User.User_Management_System.Service;

import java.util.ArrayList;
import java.util.List;

import com.User.User_Management_System.Bean.UserImage;
import com.User.User_Management_System.Dao.UserImageDao;
import com.User.User_Management_System.Dao.UserImageDaoImpl;

public class UserImageServiceImpl implements UserImageService{

	UserImageDao userImageDao = new UserImageDaoImpl();
	public void addUserImg(UserImage userimg)
	{
		userImageDao.addUserImage(userimg);
	}
	public void deleteImage(int imgid)
	{
		userImageDao.deleteImage(imgid);
	}
	public ArrayList<UserImage> getUserImg(int userid)
	{
		List<UserImage> userimglist = userImageDao.getUserImg(userid);
		return (ArrayList<UserImage>)userimglist;
		
	}
}
