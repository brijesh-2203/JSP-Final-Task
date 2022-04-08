package com.User.User_Management_System.UtilityClass;

import java.util.regex.Pattern;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CheckValidation {
	static Logger log = LogManager.getLogger(CheckValidation.class.getName());
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
			log.debug("Character Validation Pass");
			return false;
		}
		else
		{
			log.debug("Character Validation Fail");
			return true;
		}
	}
	public boolean validatepwd(String pwd)
	{
		if(Pattern.matches(regex,pwd))
		{
			log.debug("Password Validation Pass");
			return false;
		}
		else
		{
			log.debug("Password Validation Fails");
			return true;
		}
	}
	public boolean validatemail(String mail)
	{
		if(Pattern.matches(mailFormat,mail))
		{
			log.debug("Mail Validation Pass");
			return false;
		}
		else
		{
			log.debug("Mail Validation Fail");
			return true;
		}
	}
	public boolean validateNumber(String number)
	{
		 String numbers = "^[0-9]+$";
		if(number.matches(numbers))
		{
			log.debug("Number Validation Pass");
			return false;
		}
		else
		{
			log.debug("Number Validation Fails");
			return true;
		}
	}

}
