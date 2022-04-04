package com.User.User_Management_System.UtilityClass;

import java.util.regex.Pattern;

public class CheckValidation {
	String regex = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$";
	String mailFormat="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	public boolean validatename(String name)
	{
		if(Pattern.matches("[a-zA-Z]+",name))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public boolean validatepwd(String pwd)
	{
		if(Pattern.matches(regex,pwd))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public boolean validatemail(String mail)
	{
		if(Pattern.matches(mailFormat,mail))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public boolean validateNumber(String number)
	{
		if(Pattern.matches("[0-9]+",number))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}
