package relation.one.to.one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dev.utils.HibernateUtils;

import relation.one.to.one.Address;
import relation.one.to.one.Person_OneToOneUnidirectional;

public class TestBi {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		
		User_OneToOneBidirectional user = new User_OneToOneBidirectional();
		user.setName("Ryder");
		user.setUser_id(101);
		
		VoterCard vc = new VoterCard();
		vc.setVoter_id(201);
		vc.setUser(user);
		user.setVoterCard(vc);
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		factory.close();
		
		
		
		
	}
}