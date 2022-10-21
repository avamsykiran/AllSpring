package in.tp.jpa.hib.demo.ui;

import java.sql.Date;

import javax.persistence.EntityManager;

import in.tp.jpa.hib.demo.models.example1.compositepk.Student;
import in.tp.jpa.hib.demo.models.example1.compositepk.StudentIdentity;
import in.tp.jpa.hib.demo.util.JPAUtil;

public class Example1ForCompositePK {

	public static void main(String[] args) {

		Student s = new Student(new StudentIdentity(1,'A',7), "Vamsy", 
				"Aripaka", new Date(2000, 5, 5)); 

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();

		System.out.println("Student Saved!");
		JPAUtil.shutdown();
	}
}
