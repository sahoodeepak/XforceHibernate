package com.dev.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dev.beans.Userinfo;

public class GetUserInfo {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		Userinfo user = session.get(Userinfo.class, 2);
		
		System.out.println(user);
		
		session.close();
		factory.close();
		
	}

}
