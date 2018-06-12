package example.persistence.lifecycle;

import java.net.MalformedURLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dev.beans.Userinfo;
import com.dev.utils.HibernateUtils;

public class PesistenceLifeCycleExample {
	public static void main(String[] args) throws MalformedURLException {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		//get() is used to make an entity persistence
		Userinfo user = session.get(Userinfo.class, 1);
//		session.evict(user);
		session.detach(user);
		boolean state = session.contains(user);
		System.out.println("User object present: "+state);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}