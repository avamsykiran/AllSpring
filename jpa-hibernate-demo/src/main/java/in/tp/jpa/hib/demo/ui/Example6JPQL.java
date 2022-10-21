package in.tp.jpa.hib.demo.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import in.tp.jpa.hib.demo.models.example1.Employee;
import in.tp.jpa.hib.demo.util.JPAUtil;

public class Example6JPQL {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

		Employee emp = em.find(Employee.class, 101);
		
		if(emp!=null) {
			System.out.println(emp);
		}else {
			System.out.println("Object Not Found");
		}
			
		
		String qryString = "SELECT e FROM Employee e";
		Query qry= em.createQuery(qryString);
		
		display(qry.getResultList());
		
		display(em.createQuery("SELECT e FROM Employee e WHERE e.basic>5000")
				.getResultList());		
		
		List<String> names = em.createQuery("SELECT e.empName FROM Employee e")
				.getResultList();
		for(String n : names) {
			System.out.println(n);
		}
		
/*		em.createQuery("SELECT e.empName FROM Employee e")
		.getResultStream().forEach(System.out::println);
*/		
		em.close();
		JPAUtil.shutdown();
	}
	
	static void display(List<Employee> data) {
		System.out.println("-------------------------------------------");
		for(Employee e : data) {
			System.out.println(e);
		}
		System.out.println("-------------------------------------------");
	}

}
