package com.User.User_Management_System.Dao;

import java.sql.*;
import java.util.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Bean.UserAddress;
import com.User.User_Management_System.Bean.UserImage;
import com.User.User_Management_System.UtilityClass.ConnectionSetup;

public class UserDaoImpl implements UserDao {
	static Logger log = LogManager.getLogger(UserDaoImpl.class.getName());
	Connection con = null;
	PreparedStatement ps=null;
	UserAddressDao addressdao = new UserAddressDaoImpl();
	UserImageDao userImageDao = new UserImageDaoImpl();
	public boolean userExist(String mail)
	{
		boolean status=false;
		try 
        {
        	con=ConnectionSetup.getConnection();
        	ps = con.prepareStatement("select * from UserDetails where Email=?");
            ps.setString(1, mail);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
            	status=true;
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
	public void registerUser(User user)
	{
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
	public User validUser(String email)
	{
		User user = null;
		ArrayList<UserAddress> useradd = new ArrayList<UserAddress>();
		ArrayList<UserImage> userimg = new ArrayList<UserImage>();
		
        try 
        {
        	con=ConnectionSetup.getConnection();
        	ps = con.prepareStatement("select * from UserDetails where Email = ?;");
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
            	user = new User();
            	useradd = (ArrayList<UserAddress>) addressdao.getUserAddress(rs.getInt(1));
            	user.setAddress(useradd);
            	userimg = (ArrayList<UserImage>) userImageDao.getUserImg(rs.getInt(1));
            	user.setImage(userimg);
            	user.setUserID(rs.getInt(1));
            	user.setFirstname(rs.getString(2));
            	user.setLastname(rs.getString(3));
            	user.setPhone(rs.getLong(4));
            	user.setDateofbirth(rs.getString(5));
            	user.setGender(rs.getString(6));
            	user.setLanguage(rs.getString(7));
            	user.setEmail(rs.getString(8));
            	user.setPassword(rs.getString(9));
            	user.setAnswer1(rs.getString(10));
            	user.setAnswer2(rs.getString(11));
            	user.setRole(rs.getString(12));
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
        return user;
	}
	public User getUserDetails(int userid)
	{
		User user = null;
		ArrayList<UserAddress> useradd = new ArrayList<UserAddress>();
		ArrayList<UserImage> userimg = new ArrayList<UserImage>();
		
        try 
        {
        	con=ConnectionSetup.getConnection();
        	ps = con.prepareStatement("select * from UserDetails where UserID = ?;");
            ps.setInt(1,userid);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
            	user = new User();
            	useradd = (ArrayList<UserAddress>) addressdao.getUserAddress(rs.getInt(1));
            	user.setAddress(useradd);
            	userimg = (ArrayList<UserImage>) userImageDao.getUserImg(rs.getInt(1));
            	user.setImage(userimg);
            	user.setUserID(rs.getInt(1));
            	user.setFirstname(rs.getString(2));
            	user.setLastname(rs.getString(3));
            	user.setPhone(rs.getLong(4));
            	user.setDateofbirth(rs.getString(5));
            	user.setGender(rs.getString(6));
            	user.setLanguage(rs.getString(7));
            	user.setEmail(rs.getString(8));
            	user.setPassword(rs.getString(9));
            	user.setAnswer1(rs.getString(10));
            	user.setAnswer2(rs.getString(11));
            	user.setRole(rs.getString(12));
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
        return user;
	}
	public String getRole(String mail)
	{
		String role="";
		try 
        {
        	con=ConnectionSetup.getConnection();
        	ps = con.prepareStatement("select Role from UserDetails where Email = ?;");
            ps.setString(1,mail);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
            	role=rs.getString(1);
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
		return role;
	}
	public List<User> getUserList()
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
	
	public void changePwd(String pwd, String usermail) {
		try
		{
				con=ConnectionSetup.getConnection();
				ps=((java.sql.Connection) con).prepareStatement("update UserDetails set Password=? where Email=?;");
			 	ps.setString(1,pwd);
			 	ps.setString(2,usermail);
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
	
	public void updateUserProfile(User user,int userid)
	{
		try
		{
			con=ConnectionSetup.getConnection();
			 ps=((java.sql.Connection) con).prepareStatement("update UserDetails set FirstName=?,LastName=?,Phone=?,DateOfBirth=?,Gender=?,LanguageKnown=? where UserID=?;");
			 
			 	ps.setString(1, user.getFirstname());
	            ps.setString(2, user.getLastname());
	            ps.setLong(3, user.getPhone());
	            ps.setString(4, user.getDateofbirth());
	            ps.setString(5, user.getGender());
	            ps.setString(6, user.getLanguage());
	            ps.setInt(7, userid);
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
