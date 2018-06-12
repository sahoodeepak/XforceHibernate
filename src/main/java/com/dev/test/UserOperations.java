package com.dev.test;

import com.dev.beans.Userinfo;
import com.dev.dao.UserInfoDAO;
import com.dev.factory.UserInfoDAOFactory;

public class UserOperations {

	public static void main(String[] args) {
		// Configuration config = new Configuration().configure();
		// SessionFactory factory = HibernateUtils.getSessionFactory();
		// Session session = factory.openSession();

		Userinfo user = new Userinfo();
		user.setUser_id(15);
		user.setFirstName("sipu");
		user.setLastName("sahoo");
		user.setEmail_id("sipu@gmail.com");
		user.setPassword("14234");

		UserInfoDAO db = UserInfoDAOFactory.getDatabase();
		boolean res = db.createProfile(user);

		if (res) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}

		// session.getTransaction().begin();
		// session.save(user);
		// session.getTransaction().commit();
		// session.close();
		// factory.close();

	}

}
