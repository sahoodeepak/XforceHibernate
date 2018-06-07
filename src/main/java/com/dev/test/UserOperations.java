package com.dev.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dev.beans.Userinfo;

public class UserOperations {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		Userinfo user = new Userinfo();
		user.setUser_id(15);
		user.setFirstName("sipu");
		user.setLastName("sahoo");
		user.setEmail_id("sipu@gmail.com");
		user.setPassword("14234");

		session.getTransaction().begin();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		factory.close();

	}

}
