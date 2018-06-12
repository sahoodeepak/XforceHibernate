package example.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.dev.beans.Userinfo;
import com.dev.utils.HibernateUtils;


public class WritingQueries {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
//		Query<Student> query = session.createQuery("select s from Student s",Student.class);
//		Query<Userinfo> query = session.createQuery("from Userinfo",Userinfo.class);
		Query query = session.createQuery("select u.FirstName from Userinfo u");
		
		List<String> userinfos = query.getResultList();
		
		for(String u:userinfos){
			System.out.println(u);
		}
		session.getTransaction().commit();
		session.close();
	}
}