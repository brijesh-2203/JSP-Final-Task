package com.User.User_Management_System.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Bean.UserAddress;
import com.User.User_Management_System.Bean.UserImage;
import com.User.User_Management_System.UtilityClass.ConnectionSetup;


public class UserDao {
	Connection con = null;
	PreparedStatement ps=null;
	public String registerUser(User user)
	{
		String message="";
		
		try
		{
			con=ConnectionSetup.getConnection();
			 ps=((java.sql.Connection) con).prepareStatement("insert into UserDetails(FirstName,LastName,Phone,DateOfBirth,Gender,LanguageKnown,Email,Password,Answer1,Answer2,Role) values(?,?,?,?,?,?,?,?,?,?,'user');");
			 
			 	ps.setString(1, user.getFirstname());
	            ps.setString(2, user.getLastname());
	            ps.setLong(3, user.getPhone());
	            ps.setString(4, user.getDateofbirth());
	            ps.setString(5, user.getGender());
	            ps.setString(6, user.getLanguage());
	            ps.setString(7, user.getEmail());
	            ps.setString(8, user.getPassword());
	            ps.setString(9, user.getAnswer1());
	            ps.setString(10, user.getAnswer2());
	            message= "SuccessFully Registered";
	            ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			   try {
					   if(ps!=null)
					   {
					       ps.close();
				       }
			   }catch (Exception e) {
					e.printStackTrace();
				}
			   }
		return message;
	}
	public int getUserId(String mail)
	{
		int id=0;
		try
		{
			con=ConnectionSetup.getConnection();
			 ps=((java.sql.Connection) con).prepareStatement("select * from UserDetails where Email=?;");
			 ps.setString(1,mail);
		           ResultSet rs= ps.executeQuery();
		           if(rs.next())
		           {
			           System.out.println("Query:"+rs);
			           id=rs.getInt(1);
		           }
		           rs.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			   try {
					   if(ps!=null)
					   {
					       ps.close();
				       }
			   }catch (Exception e) {
					e.printStackTrace();
				}
		}
		return id;
	}
	public void addUserAddress(List<UserAddress> list)
	{ 
		try
		{
			
			for(UserAddress add : list)
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
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			   try {
					   if(ps!=null)
					   {
					       ps.close();
				       }
			   }catch (Exception e) {
					e.printStackTrace();
				}
			   }
	}
	public void addUserImage(List<UserImage> list)
	{
		try
		{
			
			for(UserImage img : list)
			{
				con=ConnectionSetup.getConnection();
				ps=((java.sql.Connection) con).prepareStatement("insert into UserImages(UserID,Image) values(?,?);");
			 	ps.setInt(1, img.getUserid());
	            ps.setBlob(2, img.getImage());
	            ps.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			   try {
					   if(ps!=null)
					   {
					       ps.close();
				       }
			   }catch (Exception e) {
					e.printStackTrace();
				}
			   }
	}
	public boolean validUser(User user)
	{
		boolean status = false;
        try 
        {
        	con=ConnectionSetup.getConnection();
        	ps = con.prepareStatement("select * from UserDetails where Email = ? and Password = ? and Role = ?");
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
            	status=true;
            	user.setUserID(rs.getInt(1));
            	user.setFirstname(rs.getString(2));
            	user.setLastname(rs.getString(3));
            	user.setPhone(rs.getLong(4));
            	user.setDateofbirth(rs.getString(5));
            	user.setGender(rs.getString(6));
            	user.setLanguage(rs.getString(7));
            	user.setPassword(rs.getString(6));
            	user.setEmail(rs.getString(8));
            }
            else
            {
            	 status=false;
            }
           
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
        finally {
			   try {
					   if(ps!=null)
					   {
					       ps.close();
				       }
			   }catch (Exception e) {
					e.printStackTrace();
				}
			   }
        return status;
	}
	public List<User> getUserDetails()
	{
		List<User> list = new ArrayList<User>();
		 try
		 {
			con=ConnectionSetup.getConnection();
		  ps=((java.sql.Connection) con).prepareStatement("select UserID,FirstName,LastName,Email,Phone,DateOfBirth,Gender,LanguageKnown from UserDetails where Role='user';"); 
          ResultSet rs=ps.executeQuery();  
          while(rs.next()){  
        	  User user=new User();  
	          	user.setUserID(rs.getInt(1));
	        	user.setFirstname(rs.getString(2));
	        	user.setLastname(rs.getString(3));
	        	user.setEmail(rs.getString(4));
	        	user.setPhone(rs.getLong(5));
	        	user.setDateofbirth(rs.getString(6));
	        	user.setGender(rs.getString(7));
	        	user.setLanguage(rs.getString(8));       	 
              list.add(user);  
          }
          rs.close();
		 } catch (Exception e) {
				e.printStackTrace();
			}
		 finally {
			   try {
					   if(ps!=null)
					   {
					       ps.close();
				       }
			   }catch (Exception e) {
					e.printStackTrace();
				}
			   }
		return list;
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
	        	user.setAdd1(rs.getString(3));
	        	user.setAdd2(rs.getString(4));
	        	user.setPincode(rs.getString(5));
	        	user.setCity(rs.getString(6));
	        	user.setState(rs.getString(7));
	        	user.setCountry(rs.getString(8));       	 
	        	useradd.add(user);  
         }
         rs.close();
		 } catch (Exception e) {
				e.printStackTrace();
			}
		 finally {
			   try {
					   if(ps!=null)
					   {
					       ps.close();
				       }
			   }catch (Exception e) {
					e.printStackTrace();
				}
			   }
		return useradd;
	}
	public void deleteUser(int userid)
	{
		try
		{
				con=ConnectionSetup.getConnection();
				ps=((java.sql.Connection) con).prepareStatement("delete from UserDetails where UserID=?;");
			 	ps.setInt(1,userid);
	            ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			   try {
					   if(ps!=null)
					   {
					       ps.close();
				       }
			   }catch (Exception e) {
					e.printStackTrace();
				}
			   }
	}
}
