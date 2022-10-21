package in.tp.sbcrud;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import in.tp.sbcrud.dao.EmployeeRepository;
import in.tp.sbcrud.model.Department;
import in.tp.sbcrud.model.Employee;
import in.tp.sbcrud.service.EmployeeService;
import in.tp.sbcrud.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplUnitTest {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public EmployeeService employeeService() {
			return new EmployeeServiceImpl();
		}
	}

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Before
	public void setUp() {
		Employee emp = new Employee("Vamsy", "Aripaka", 45000, 
				LocalDate.now(), Department.DEVELOPMENT, "9052224753",
				"a.vamc.it@gmail.com");

		Mockito.when(employeeRepository.findByMobileNumber(emp.getMobileNumber()))
		.thenReturn(emp);
		
	/*	Mockito.when(employeeRepository.findByMobileNumber(Mockito.anyString()))
		.thenReturn(null);*/
	}

	@Test
	public void whenValidMobileNumber_thenEmployeeShouldBeFound() {
		String mno = "9052224753";
		Employee found = employeeService.findByMobileNumber(mno);
		assertThat(found.getMobileNumber()).isEqualTo(mno);
	}
	
	@Test
	public void whenInValidMobileNumber_thenEmployeeShouldNotBeFound() {
		String mno = "1234567890";
		Employee found = employeeService.findByMobileNumber(mno);
		assertThat(found).isNull();
	}
}