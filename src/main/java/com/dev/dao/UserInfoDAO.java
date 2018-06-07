package com.dev.dao;

import com.dev.beans.Userinfo;

public interface UserInfoDAO {

	public boolean CreateProfile(Userinfo data);
    public Userinfo Login(int User_id, String Password);
	

	
}
