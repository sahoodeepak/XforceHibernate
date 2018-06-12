package example.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.dev.beans.Userinfo;
import com.dev.utils.HibernateUtils;


public class PassingParameters {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		//Indexed Parameter Type
//		Query<Student> query = session.createQuery("FROM Student s WHERE s.regno=?",Student.class);
		
		//Named Parameter Type
		Query<Userinfo> query = session.createQuery("FROM Userinfo s WHERE s.User_id= :id ",Userinfo.class);
//		query.setParameter(0, args[0]); // for Indexed Parameter type
		query.setParameter("id", 2);
		/*
		 * SetParameter can set the type of value intelligently but you should be aware of 
		 * using Temporal type like date and time. You have to explicitly setDate or setTime
		 */
		List<Userinfo> userinfos = query.list();
		for(Userinfo u:userinfos){
			System.out.println(u);
		}
		session.getTransaction().commit();
		session.close();
	}
}