package in.tp.jpa.hib.demo.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import in.tp.jpa.hib.demo.models.example1.Employee;
import in.tp.jpa.hib.demo.models.onetoMany.Course;
import in.tp.jpa.hib.demo.util.JPAUtil;

public class Example7TypedQrys {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

		String qryString = "SELECT e FROM Employee e";
		
		Query qry = em.createQuery(qryString);

		List<Employee> empList = qry.getResultList();
		for (Employee e : empList) {
			System.out.println(e.getEmpId() + "\t" + e.getEmpName());
		}
				
		TypedQuery<Employee> empQry = em.createQuery(qryString,Employee.class);

		List<Employee> empList2 = empQry.getResultList();
		for (Employee e : empList2) {
			System.out.println(e.getEmpId() + "\t" + e.getEmpName());
		}
				
		//Named Parameters
		TypedQuery<Employee> empQry3 = em.createQuery(
				"SELECT e FROM Employee e WHERE e.basic BETWEEN :lBound AND :uBound",
				Employee.class);
		
		empQry3.setParameter("lBound", 4500);
		empQry3.setParameter("uBound", 7500);
		List<Employee> empsList3 = empQry3.getResultList();
		
		for(Employee e : empsList3) {
			System.out.println(e.getEmpId() + "\t" + e.getEmpName() + "\t"+ e.getBasic());
		}
		
		//Named Parameters By Ordinal
		TypedQuery<Employee> empQry4 = em.createQuery(
				"SELECT e FROM Employee e WHERE e.basic BETWEEN ?1 AND ?2",Employee.class);
		
		empQry4.setParameter(1, 4500.0);
		empQry4.setParameter(2, 7500.0);
		List<Employee> empsList4 = empQry4.getResultList();
		
		for(Employee e : empsList4) {
			System.out.println(e.getEmpId() + "\t" + e.getEmpName() + "\t"+ e.getBasic());
		}
		
		TypedQuery<Employee> empQry5 = 
				em.createNamedQuery("empBasicRangeQry", Employee.class);
		empQry5.setParameter("lbound", 4500);
		empQry5.setParameter("ubound", 7500);
		List<Employee> empsList5 = empQry5.getResultList();
		
		for(Employee e : empsList5) {
			System.out.println(e.getEmpId() + "\t" + e.getEmpName() + "\t"+ e.getBasic());
		}
		
		em.close();
	}

}
