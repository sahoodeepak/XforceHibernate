package relation.many.to.many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dev.utils.HibernateUtils;

public class TestManyMany_Bi {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		
		Teacher_Bidirectional teBidirectional=new Teacher_Bidirectional();
		teBidirectional.setName("suyash");
		teBidirectional.setSubject("hindi");
		
		Teacher_Bidirectional teBidirectional2=new Teacher_Bidirectional();
		teBidirectional2.setName("raja");
		teBidirectional2.setSubject("jdbc");
		
		Teacher_Bidirectional teBidirectional3=new Teacher_Bidirectional();
		teBidirectional3.setName("subrat");
		teBidirectional3.setSubject("hibernate");
		
		Set<Teacher_Bidirectional> teacher_Bidirectionals=new HashSet<>();
		teacher_Bidirectionals.add(teBidirectional);
		teacher_Bidirectionals.add(teBidirectional2);
		teacher_Bidirectionals.add(teBidirectional3);
		
		Students_Bidirectional sBidirectional=new Students_Bidirectional();
		sBidirectional.setName("subham");
		sBidirectional.setAge(19);
		
		Students_Bidirectional sBidirectional2=new Students_Bidirectional();
		sBidirectional2.setName("rama");
		sBidirectional2.setAge(21);
		
		Students_Bidirectional sBidirectional3=new Students_Bidirectional();
		sBidirectional3.setName("john");
		sBidirectional3.setAge(18);
		
		Set<Students_Bidirectional> students_Bidirectionals=new HashSet<>();
		students_Bidirectionals.add(sBidirectional);
		students_Bidirectionals.add(sBidirectional2);
		students_Bidirectionals.add(sBidirectional3);
		
//		teBidirectional.setStudents(students_Bidirectionals);
//		teBidirectional2.setStudents(students_Bidirectionals);
//		teBidirectional3.setStudents(students_Bidirectionals);
		
		sBidirectional.setTeachers(teacher_Bidirectionals);
		sBidirectional2.setTeachers(teacher_Bidirectionals);
		sBidirectional3.setTeachers(teacher_Bidirectionals);
		
		session.beginTransaction();
		session.save(sBidirectional);
		session.save(sBidirectional2);
		session.save(sBidirectional3);
		session.getTransaction().commit();
		session.close();
		factory.close();
		
		
		
	}
}
