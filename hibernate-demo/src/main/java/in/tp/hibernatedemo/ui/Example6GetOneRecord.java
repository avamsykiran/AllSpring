package in.tp.hibernatedemo.ui;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import in.tp.hibernatedemo.models.example1.Emp;

public class Example6GetOneRecord {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		conf.addAnnotatedClass(in.tp.hibernatedemo.models.example1.Emp.class);

		StandardServiceRegistryBuilder srBuilder = new StandardServiceRegistryBuilder();
		srBuilder.applySettings(conf.getProperties());

		StandardServiceRegistry serviceRegistry = srBuilder.build();

		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);

		Session session = sf.openSession();
		
		System.out.print("EmpId: ");
		int empId = scan.nextInt();
		
		//Emp e = session.load(Emp.class, empId);
		Emp e = session.get(Emp.class, empId);
		System.out.println(e);
		session.close();
	}

}
