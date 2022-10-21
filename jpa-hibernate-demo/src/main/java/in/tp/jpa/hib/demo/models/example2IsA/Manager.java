package in.tp.jpa.hib.demo.models.example2IsA;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

//@DiscriminatorValue("mang")
//@Table(name="mgrs")
@Table(name="mgrs_only")
public class Manager extends Emp {
	@Column(name="hra")
	private double hra;
	
	public Manager()
	{
		
	}

	public Manager(int empNo, String eName, double sal,double hra) {
		super(empNo, eName, sal);
		this.hra=hra;
	}

	@Override
	public String toString() {
		return "manager [hra=" + hra + ", getEmpNo()=" + getEmpNo()
				+ ", geteName()=" + geteName() + ", getSal()=" + getSal() + "]";
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}
	
	

}
