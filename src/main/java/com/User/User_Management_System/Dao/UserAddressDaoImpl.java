package com.User.User_Management_System.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.User.User_Management_System.Bean.UserAddress;
import com.User.User_Management_System.UtilityClass.ConnectionSetup;

public class UserAddressDaoImpl implements UserAddressDao {
	static Logger log = LogManager.getLogger(UserAddressDaoImpl.class.getName());
	Connection con = null;
	PreparedStatement ps=null;
	public void addUserAddress(UserAddress add)
	{ 
		try
		{
				con=ConnectionSetup.getConnection();
				ps=((java.sql.Connection) con).prepareStatement("insert into AddressDetails(UserID,Addressline1,Addressline2,Pincode,City,State,Country) values(?,?,?,?,?,?,?);");
			 	ps.setInt(1, add.getUserid());
	            ps.setString(2, add.getAdd1());
	            ps.setString(3, add.getAdd2());
	            ps.setString(4, add.getPincode());
	            ps.setString(5, add.getCity());
	            ps.setString(6, add.getState());
	            ps.setString(7, add.getCountry());
	            ps.executeUpdate();
	            log.info("Address added in Database");
		}
		catch(Exception e)
		{
			log.fatal(e);
		}
		finally {
			   try {
					   if(ps!=null)
					   {
					       ps.close();
				       }
			   }catch (Exception e) {
				   log.fatal(e);
				}
			   }
	}
	public List<UserAddress> getUserAddress(int userid)
	{
		List<UserAddress> useradd = new ArrayList<UserAddress>();
		try
		 {
			con=ConnectionSetup.getConnection();
		  ps=((java.sql.Connection) con).prepareStatement("select * from AddressDetails where UserID=?;"); 
		  ps.setInt(1,userid);
         ResultSet rs=ps.executeQuery();  
         while(rs.next()){  
       	  UserAddress user=new UserAddress();
       	  		user.setAddressid(rs.getInt(2));
	        	user.setAdd1(rs.getString(3));
	        	user.setAdd2(rs.getString(4));
	        	user.setPincode(rs.getString(5));
	        	user.setCity(rs.getString(6));
	        	user.setState(rs.getString(7));
	        	user.setCountry(rs.getString(8));       	 
	        	useradd.add(user);  
	        	log.info("Get Addresses from Database");
         }
         rs.close();
		 } catch (Exception e) {
			 log.fatal(e);
			}
		 finally {
			   try {
					   if(ps!=null)
					   {
					       ps.close();
				       }
			   }catch (Exception e) {
				   log.fatal(e);
				}
			   }
		return useradd;
	}
	public void updateUserAddress(UserAddress add)
	{ 
		try
		{
				con=ConnectionSetup.getConnection();
				ps=((java.sql.Connection) con).prepareStatement("update AddressDetails set Addressline1=?,Addressline2=?,Pincode=?,City=?,State=?,Country=? where AddressID=?;");
			 	
	            ps.setString(1, add.getAdd1());
	            ps.setString(2, add.getAdd2());
	            ps.setString(3, add.getPincode());
	            ps.setString(4, add.getCity());
	            ps.setString(5, add.getState());
	            ps.setString(6, add.getCountry());
	            ps.setInt(7, add.getAddressid());
	            ps.executeUpdate();
	            log.info("Address updated in Database");
		}
		catch(Exception e)
		{
			log.fatal(e);
		}
		finally {
			   try {
					   if(ps!=null)
					   {
					       ps.close();
				       }
			   }catch (Exception e) {
				   log.fatal(e);
				}
			   }
	}
	public void deleteAddress(int addid)
	{
		try
		{
				con=ConnectionSetup.getConnection();
				ps=((java.sql.Connection) con).prepareStatement("delete from AddressDetails where AddressID=?;");
			 	ps.setInt(1,addid);
	            ps.executeUpdate();
	            log.info("Address deleted from Database");
		}
		catch(Exception e)
		{
			log.fatal(e);
		}
		finally {
			   try {
					   if(ps!=null)
					   {
					       ps.close();
				       }
			   }catch (Exception e) {
				   log.fatal(e);
				}
			   }
	}
}
