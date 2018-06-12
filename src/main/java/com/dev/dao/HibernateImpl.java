package com.dev.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dev.beans.Userinfo;
import com.dev.utils.HibernateUtils;

public class HibernateImpl implements UserInfoDAO {

	SessionFactory factory = HibernateUtils.getSessionFactory();

	@Override
	public boolean createProfile(Userinfo user) {
		Session session = null;
		try {
			session = factory.openSession();
//			Transaction tx=session.getTransaction();
//			tx.begin();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public Userinfo login(int User_id, String Password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "HibernateImpl [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
