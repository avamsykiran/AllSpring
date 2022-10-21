package in.tp.hibernatedemo.ui;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import in.tp.hibernatedemo.models.example2IsA.ContractEmp;
import in.tp.hibernatedemo.models.example2IsA.Emp;
import in.tp.hibernatedemo.models.example2IsA.Manager;

public class Example2 {

	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		conf.addAnnotatedClass(in.tp.hibernatedemo.models.example2IsA.Emp.class);
		conf.addAnnotatedClass(in.tp.hibernatedemo.models.example2IsA.Manager.class);
		conf.addAnnotatedClass(in.tp.hibernatedemo.models.example2IsA.ContractEmp.class);

		StandardServiceRegistryBuilder srBuilder = new StandardServiceRegistryBuilder();
		srBuilder.applySettings(conf.getProperties());

		StandardServiceRegistry serviceRegistry = srBuilder.build();

		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);

		Session session = sf.openSession();
		Transaction txn= session.beginTransaction();
		
		Emp e = new Emp(101,"Vamsy",25000);
		Manager m = new Manager(102, "Ramu", 35000, 9500);
		ContractEmp ce = new ContractEmp(103, "Kittu", 45200, 11);
		
		session.save(e);
		session.save(m);
		session.save(ce);
		
		txn.commit();
		System.out.println("Emp Saved!");
		
		session.close();
	}

}
