package in.tp.hibernatedemo.ui;

import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import in.tp.hibernatedemo.models.onetoMany.Course;
import in.tp.hibernatedemo.models.onetoMany.Student;

public class Example4OneToMany {

	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		conf.addAnnotatedClass(in.tp.hibernatedemo.models.onetoMany.Course.class);
		conf.addAnnotatedClass(in.tp.hibernatedemo.models.onetoMany.Student.class);

		StandardServiceRegistryBuilder srBuilder = new StandardServiceRegistryBuilder();
		srBuilder.applySettings(conf.getProperties());

		StandardServiceRegistry serviceRegistry = srBuilder.build();

		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);

		Session session = sf.openSession();
		Transaction txn= session.beginTransaction();
		
		Course c1 = new Course(101,"MBA",new TreeSet<Student>());
		Course c2 = new Course(102,"MCA",new TreeSet<Student>());
		
		c1.getStudents().add(new Student(2001,"Ram",c1));
		c1.getStudents().add(new Student(2002,"Shyam",c1));
		c1.getStudents().add(new Student(2003,"Sita",c1));
		
		c2.getStudents().add(new Student(1001,"Komal",c2));
		c2.getStudents().add(new Student(1002,"Varun",c2));
		c2.getStudents().add(new Student(1003,"Latha",c2));
		
		session.save(c1);
		session.save(c2);
		
		txn.commit();
		System.out.println("Emp Saved!");
		
		session.close();
	}

}
