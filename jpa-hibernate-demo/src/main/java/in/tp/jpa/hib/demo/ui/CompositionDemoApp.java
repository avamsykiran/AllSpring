package in.tp.jpa.hib.demo.ui;

import javax.persistence.EntityManager;

import in.tp.jpa.hib.demo.models.composition.Address;
import in.tp.jpa.hib.demo.models.composition.Faculty;
import in.tp.jpa.hib.demo.util.JPAUtil;

public class CompositionDemoApp {

	public static void main(String[] a) {

		Faculty f = new Faculty("Vamsy", 
				new Address("A201", "Serling Brookside Apartments", "Banglore, Karnataka."));
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		
		System.out.println("Faculty Saved!");
		JPAUtil.shutdown();
	}

}
