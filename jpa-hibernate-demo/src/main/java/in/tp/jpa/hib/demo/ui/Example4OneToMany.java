package in.tp.jpa.hib.demo.ui;

import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import in.tp.jpa.hib.demo.models.onetoMany.Course;
import in.tp.jpa.hib.demo.models.onetoMany.Trainee;
import in.tp.jpa.hib.demo.util.JPAUtil;

public class Example4OneToMany {

	public static void main(String[] args) {
		Course mca = new Course(101,"MCA",new TreeSet<Trainee>());
		Course mba = new Course(102,"MBA",new TreeSet<Trainee>());
		
		mca.getTrainees().add(new Trainee(201, "Vamsy", mca));
		mca.getTrainees().add(new Trainee(202, "Suseela", mca));
		mca.getTrainees().add(new Trainee(203, "Indhika", mca));
		
		mba.getTrainees().add(new Trainee(204, "Srinu", mba));
		mba.getTrainees().add(new Trainee(205, "Deepa", mba));
		mba.getTrainees().add(new Trainee(206, "Raghu", mba));
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction txn=em.getTransaction();
		
		txn.begin();
		em.persist(mca);
		em.persist(mba);
		txn.commit();
		
		JPAUtil.shutdown();
	}

}
