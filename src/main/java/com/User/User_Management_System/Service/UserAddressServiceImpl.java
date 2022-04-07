package com.User.User_Management_System.Service;

import java.util.List;

import com.User.User_Management_System.Bean.UserAddress;
import com.User.User_Management_System.Dao.UserAddressDao;
import com.User.User_Management_System.Dao.UserAddressDaoImpl;

public class UserAddressServiceImpl implements UserAddressService{
	UserAddressDao userAddressDao = new UserAddressDaoImpl();
	public void addUserAddress(UserAddress useradd)
	{
		userAddressDao.addUserAddress(useradd);
	}
	public void updateUserAddress(UserAddress useradd)
	{
		userAddressDao.updateUserAddress(useradd);
	}
	public List<UserAddress> getUserAddress(int userid)
	{
		List<UserAddress> useraddlist = userAddressDao.getUserAddress(userid);
		return useraddlist;
	}
	public void deleteAddress(int addid)
	{
		userAddressDao.deleteAddress(addid);
	}
}
