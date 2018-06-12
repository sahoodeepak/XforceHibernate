package relation.one.to.one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dev.utils.HibernateUtils;

import relation.one.to.one.Address;
import relation.one.to.one.Person_OneToOneUnidirectional;

public class TestUni {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		Person_OneToOneUnidirectional p = new Person_OneToOneUnidirectional();
		p.setName("Blake");
		p.setAge(34);
		p.setId(101);
		
		Address addr = new Address();
		addr.setCity("Bangalore");
		addr.setPin(560019);
		addr.setState("Karnataka");
		addr.setAddress_id(1001);
		
		p.setAddress(addr);
		
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();
		factory.close();
		
		
		
		
	}
}