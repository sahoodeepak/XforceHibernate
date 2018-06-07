package com.dev.dao;

import com.dev.beans.Userinfo;

public class HibernateImpl implements UserInfoDAO {

	@Override
	public String toString() {
		return "HibernateImpl [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public boolean CreateProfile(Userinfo data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Userinfo Login(int User_id, String Password) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
