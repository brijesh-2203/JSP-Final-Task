package com.User.User_Management_System.Service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.User.User_Management_System.Bean.UserAddress;
import com.User.User_Management_System.Dao.UserAddressDao;
import com.User.User_Management_System.Dao.UserAddressDaoImpl;

public class UserAddressServiceImpl implements UserAddressService{
	static Logger log = LogManager.getLogger(UserAddressServiceImpl.class.getName());
	UserAddressDao userAddressDao = new UserAddressDaoImpl();
	public void addUserAddress(UserAddress useradd)
	{
		log.info("User Address service,addUserAddress methods call");
		userAddressDao.addUserAddress(useradd);
	}
	public void updateUserAddress(UserAddress useradd)
	{
		log.info("User Address service,updateUserAddress methods call");
		userAddressDao.updateUserAddress(useradd);
	}
	public List<UserAddress> getUserAddress(int userid)
	{
		log.info("User Address service,getUserAddress methods call");
		List<UserAddress> useraddlist = userAddressDao.getUserAddress(userid);
		return useraddlist;
	}
	public void deleteAddress(int addid)
	{
		log.info("User Address service,deleteAddress methods call");
		userAddressDao.deleteAddress(addid);
	}
}
