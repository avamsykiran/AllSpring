package in.tp.jpa.hib.demo.models.example1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CapEmps")
@NamedQueries({
	@NamedQuery(name = "empBasicRangeQry", 
	query = "SELECT e FROM Employee e WHERE e.basic BETWEEN :lBound AND :uBound"),
	@NamedQuery(name = "empNameQry", 
	query = "SELECT e FROM Employee e WHERE e.empName=:ename")
})
public class Employee {

	@Id
	@Column(name = "eid")
	private int empId;

	@Column(name = "ename", nullable = false)
	private String empName;

	private double basic;

	public Employee() {

	}

	public Employee(int empId, String empName, double basic) {

		this.empId = empId;
		this.empName = empName;
		this.basic = basic;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", basic=" + basic + "]";
	}

}
