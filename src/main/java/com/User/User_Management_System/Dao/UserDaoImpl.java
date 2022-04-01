package com.User.User_Management_System.Dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.User.User_Management_System.Bean.User;
import com.User.User_Management_System.Bean.UserAddress;
import com.User.User_Management_System.Bean.UserImage;
import com.User.User_Management_System.Controller.Admin_EditUser;
import com.User.User_Management_System.UtilityClass.ConnectionSetup;

public class UserDaoImpl implements UserDao {
	static Logger log = LogManager.getLogger(UserDaoImpl.class.getName());
	Connection con = null;
	PreparedStatement ps=null;
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
	public void addUserImage(UserImage img)
	{
		try
		{
				con=ConnectionSetup.getConnection();
				ps=((java.sql.Connection) con).prepareStatement("insert into UserImages(UserID,Image) values(?,?);");
			 	ps.setInt(1, img.getUserid());
	            ps.setBlob(2, img.getImage());
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
            	useradd = (ArrayList<UserAddress>) getUserAddress(rs.getInt(1));
            	user.setAddress(useradd);
            	userimg = (ArrayList<UserImage>) getUserImg(rs.getInt(1));
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
            	useradd = (ArrayList<UserAddress>) getUserAddress(rs.getInt(1));
            	user.setAddress(useradd);
            	userimg = (ArrayList<UserImage>) getUserImg(rs.getInt(1));
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
       	  		user.setAddressid(rs.getInt(2));
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
	public List<UserImage> getUserImg(int userid)
	{
		List<UserImage> userimg = new ArrayList<UserImage>();
		try
		 {
			java.sql.Blob image=null;
			con=ConnectionSetup.getConnection();
		  ps=((java.sql.Connection) con).prepareStatement("select * from UserImages where UserID=?;"); 
		  ps.setInt(1,userid);
         ResultSet rs=ps.executeQuery();  
         while(rs.next()){  
        	 image=rs.getBlob(3);
        	 InputStream inputStream = image.getBinaryStream();
        	 ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        	 byte[] buffer = new byte[4096];
        	 int bytesRead = -1;
        	  
        	 while ((bytesRead = inputStream.read(buffer)) != -1) {
        	     outputStream.write(buffer, 0, bytesRead);
        	 }
        	 byte[] imageBytes = outputStream.toByteArray();
        	  
        	 String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        	 UserImage user=new UserImage();
        	 user.setBase64Image(base64Image);
        	 user.setImgid(rs.getInt(2));
	        	userimg.add(user);  
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
		return userimg;
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
	public void deleteImage(int imgid)
	{
		try
		{
				con=ConnectionSetup.getConnection();
				ps=((java.sql.Connection) con).prepareStatement("delete from UserImages where ImageID=?;");
			 	ps.setInt(1,imgid);
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
