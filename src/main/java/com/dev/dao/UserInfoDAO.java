package com.dev.dao;

import com.dev.beans.Userinfo;

public interface UserInfoDAO {

	public boolean createProfile(Userinfo user);
    public Userinfo login(int User_id, String Password);
	

	
}
