package in.tp.jpa.hib.demo.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import in.tp.jpa.hib.demo.models.onetoone.BankAccount;
import in.tp.jpa.hib.demo.models.onetoone.Customer;
import in.tp.jpa.hib.demo.util.JPAUtil;

public class Example3OneToOne {

	public static void main(String[] args) {
			
		BankAccount ba = new BankAccount();
		Customer cs = new Customer("888555999","Sundar",ba);
		ba.setAccno("SB0001");
		ba.setCustmer(cs);
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		txn.begin();
		em.persist(cs);
		txn.commit();
		JPAUtil.shutdown();
	}
}
