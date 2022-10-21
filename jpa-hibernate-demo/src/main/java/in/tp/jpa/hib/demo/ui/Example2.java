package in.tp.jpa.hib.demo.ui;

import javax.persistence.EntityManager;

import in.tp.jpa.hib.demo.models.example2IsA.ContractEmp;
import in.tp.jpa.hib.demo.models.example2IsA.Emp;
import in.tp.jpa.hib.demo.models.example2IsA.Manager;
import in.tp.jpa.hib.demo.util.JPAUtil;

public class Example2 {

	public static void main(String[] args) {
					
		Emp e = new Emp(101,"Vamsy",25000);
		Manager m = new Manager(102, "Ramu", 35000, 9500);
		ContractEmp ce = new ContractEmp(103, "Kittu", 45200, 11);

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

		em.getTransaction().begin();
		em.persist(e);
		em.persist(m);
		em.persist(ce);
		em.getTransaction().commit();

		//em.remove(e);
		
		System.out.println("All Records Saved!");
		JPAUtil.shutdown();
	}

}
