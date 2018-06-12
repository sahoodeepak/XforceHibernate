package com.dev.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dev.beans.Userinfo;

public class DeleteUser {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		Userinfo user = session.get(Userinfo.class, 15);
		session.delete(user);
		
		session.getTransaction().begin();
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
