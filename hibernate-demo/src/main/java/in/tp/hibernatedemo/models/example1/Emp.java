package in.tp.hibernatedemo.models.example1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TestEmps")
public class Emp {

	@Id
	@Column(name = "eid")
	private int empId;

	@Column(name = "ename")
	private String empName;

	private double basic;

	public Emp() {

	}

	public Emp(int empId, String empName, double basic) {

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
		return "Emp [empId=" + empId + ", empName=" + empName + ", basic="
				+ basic + "]";
	}

}
