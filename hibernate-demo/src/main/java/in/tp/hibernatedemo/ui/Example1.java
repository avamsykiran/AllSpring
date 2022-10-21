package in.tp.hibernatedemo.ui;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import in.tp.hibernatedemo.models.example1.Emp;

public class Example1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Create an emp object
		Emp e = new Emp();
		System.out.print("EmpId: ");
		e.setEmpId(scan.nextInt());
		System.out.print("EName: ");
		e.setEmpName(scan.next());
		System.out.print("Basic: ");
		e.setBasic(scan.nextDouble());

		
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		conf.addAnnotatedClass(in.tp.hibernatedemo.models.example1.Emp.class);

		StandardServiceRegistryBuilder srBuilder = new StandardServiceRegistryBuilder();
		srBuilder.applySettings(conf.getProperties());

		StandardServiceRegistry serviceRegistry = srBuilder.build();

		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);

		Session session = sf.openSession();
		Transaction txn= session.beginTransaction();
		session.save(e);
		txn.commit();
		System.out.println("Emp Saved!");
		
		session.close();
	}

}
