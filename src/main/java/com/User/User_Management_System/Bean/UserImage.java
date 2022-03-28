package com.User.User_Management_System.Bean;

import java.io.InputStream;

public class UserImage {
	private int userid;
	private InputStream image;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}	
}
