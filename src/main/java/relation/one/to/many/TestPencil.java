package relation.one.to.many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dev.utils.HibernateUtils;

public class TestPencil {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		
		PencilBox_UniDirectional box=new PencilBox_UniDirectional();
		box.setSize("10");
		
		Pencil pencil=new Pencil();
		pencil.setName("nataraj");
		
		Pencil pencil2=new Pencil();
		pencil2.setName("apshara");
		
		List<Pencil> pencils=new ArrayList<>();
		pencils.add(pencil);
		pencils.add(pencil2);
		
		box.setPencils(pencils);
		
		session.beginTransaction();
		session.save(box);
		session.getTransaction().commit();
		session.close();
		factory.close();
		
	}

}
