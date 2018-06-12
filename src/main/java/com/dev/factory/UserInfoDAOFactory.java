package com.dev.factory;

import com.dev.dao.HibernateImpl;
import com.dev.dao.JDBCImpl;
import com.dev.dao.UserInfoDAO;

public class UserInfoDAOFactory {

	private final static String DATABASE="hibe";
	
    private static final UserInfoDAO ref=getDAO();
    
    private static UserInfoDAO getDAO()
    {
    	UserInfoDAO db=null;
    	
    	if(DATABASE.equals("jdbc"))
    	{
    		db=new JDBCImpl();
    		
    	}else {
			db=new HibernateImpl();
		}
    	
    	return db;
    }
    public static UserInfoDAO getDatabase()
    {
    	//return getDAO(); use to non singlton class
    	return ref;//singlton class
    }
	
}
