package in.tp.sbcrud;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import javax.persistence.EntityTransaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import in.tp.sbcrud.dao.EmployeeRepository;
import in.tp.sbcrud.model.Department;
import in.tp.sbcrud.model.Employee;

@RunWith(SpringRunner.class) // a bridge between Spring Boot test features and JUnit
@DataJpaTest // configuring H2, an in-memory database,setting Hibernate, Spring Data, and the
				// DataSource,performing an @EntityScan turning on SQL logging
public class EmployeeRepositoryUnitTest {

	private Employee emps[];

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeRepositoryUnitTest() {
		emps  = new Employee[] {
				new Employee("Vamsy","Aripaka",45000,
						LocalDate.now(),Department.DEVELOPMENT,
						"9052224753","a.vamc.it@gmail.com")
    	};
	}
	
	@Before
    public void beforeEachTest() {
    	for(Employee e : emps) {
    		entityManager.persist(e);
    	}
    	entityManager.flush();
    }

	@After
	public void afterEachTest() {
		for(Employee e : emps) {
    		entityManager.remove(e);
    	}
    	entityManager.flush();
	}
	
	@Test
	public void whenFindByMobileNumber_thenReturnEmployee() {
		Employee e = employeeRepository.findByMobileNumber(emps[0].getMobileNumber());
		assertThat(e).isEqualTo(emps[0]);
	}

	@Test
	public void whenFindByMobileNumber_withNonExistingMobleNumber_thenReturnNull() {
		Employee e = employeeRepository.findByMobileNumber("1234567890");
		assertThat(e).isNull();
	}

}