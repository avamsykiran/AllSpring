package in.tp.jpa.hib.demo.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;

import in.tp.jpa.hib.demo.models.example1.Employee;
import in.tp.jpa.hib.demo.util.JPAUtil;

public class Example1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

		boolean shallContinue = true;
		
		while (shallContinue) {
			// Create an emp object
			Employee e = new Employee();
			System.out.print("EmpId: ");
			e.setEmpId(scan.nextInt());
			System.out.print("EName: ");
			e.setEmpName(scan.next());
			System.out.print("Basic: ");
			e.setBasic(scan.nextDouble());
			
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			
			System.out.print("Wanna Add One More? (true-to continue): ");
			shallContinue=scan.nextBoolean();
		}

		shallContinue = true;
		
		while(shallContinue) {
			System.out.print("Enter EmpId to Search: ");
			int empId = scan.nextInt();
			
			Employee e = em.find(Employee.class, empId);
			if(e!=null)
				System.out.println(e.getEmpId() +"\t" + e.getEmpName() + "\t" + e.getBasic());
			else 
				System.out.println("Record Not Found!");
		
			System.out.print("Wanna Search More? (true-to continue): ");
			shallContinue=scan.nextBoolean();
		}
		
		
		System.out.println("Emp Saved!");
		JPAUtil.shutdown();
		scan.close();
	}
}
