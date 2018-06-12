package relation.one.to.many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dev.utils.HibernateUtils;

public class TestBucket {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		
		Bucket_Bidirectional bucket=new Bucket_Bidirectional();
		bucket.setBucket_id(111);
		bucket.setName("ankur");
		
		IceCube ice=new IceCube();
		ice.setIceCubeId(11);
		ice.setSize("20");
		ice.setBucket(bucket);
		
		IceCube ice2=new IceCube();
		ice2.setIceCubeId(12);
		ice2.setSize("30");
		ice2.setBucket(bucket);
		
		List<IceCube> cubes=new ArrayList<>();
		cubes.add(ice);
		cubes.add(ice2);
		
		bucket.setIceCube(cubes);
		
		session.beginTransaction();
		session.save(bucket);
		session.getTransaction().commit();
		session.close();
		factory.close();
		
	}

}
