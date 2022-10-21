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
import in.tp.hibernatedemo.models.onetoone.BankAccount;
import in.tp.hibernatedemo.models.onetoone.Customer;

public class Example3OneToOne {

	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		conf.addAnnotatedClass(in.tp.hibernatedemo.models.onetoone.BankAccount.class);
		conf.addAnnotatedClass(in.tp.hibernatedemo.models.onetoone.Customer.class);

		StandardServiceRegistryBuilder srBuilder = new StandardServiceRegistryBuilder();
		srBuilder.applySettings(conf.getProperties());

		StandardServiceRegistry serviceRegistry = srBuilder.build();

		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);

		Session session = sf.openSession();
		Transaction txn= session.beginTransaction();
		
		BankAccount ba = new BankAccount();
		
		Customer cs = new Customer("888555999","Sundar",ba);
		
		ba.setAccno("SB0091");
		ba.setCustmer(cs);
		
		session.save(cs);
		
		txn.commit();
		System.out.println("Emp Saved!");
		
		session.close();
	}

}
