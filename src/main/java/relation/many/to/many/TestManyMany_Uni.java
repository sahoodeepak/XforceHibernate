package relation.many.to.many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dev.utils.HibernateUtils;

public class TestManyMany_Uni {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		
		Students_Unidirectional stu_uni=new Students_Unidirectional();
		stu_uni.setName("drs");
		stu_uni.setAge(25);
		
		Teacher teacher=new Teacher();
		teacher.setName("saroj");
		teacher.setSubject("math");
		
		Teacher teacher2=new Teacher();
		teacher2.setName("sana");
		teacher2.setSubject("odiya");
		
		Set<Teacher> teachers=new HashSet<>();
		teachers.add(teacher);
		teachers.add(teacher2);
		
		stu_uni.setList(teachers);
		
		session.beginTransaction();
		session.save(stu_uni);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}
