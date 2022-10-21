package in.tp.jpa.hib.demo.models.example2IsA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

//@DiscriminatorValue("cemp")
//@Table(name="cemps")
@Table(name="cemps_only")
public class ContractEmp extends Emp {
	@Column(name="cdur")
	private int contractDur;
	
	public ContractEmp()
	{
		
	}

	public ContractEmp(int empNo, String eName, double sal,int contractDur) {
		super(empNo, eName, sal);
		this.contractDur=contractDur;
	}

	@Override
	public String toString() {
		return "ContractEmp [contractDur=" + contractDur + ", getEmpNo()="
				+ getEmpNo() + ", geteName()=" + geteName() + ", getSal()="
				+ getSal() + "]";
	}

	public int getContractDur() {
		return contractDur;
	}

	public void setContractDur(int contractDur) {
		this.contractDur = contractDur;
	}
	
	
	

}
