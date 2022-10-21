package in.tp.jpa.hib.demo.models.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BankAccounts")
public class BankAccount {
	
	@Id
	private String accno;
	
	@OneToOne
	@JoinColumn(name="aadhar")
	private Customer customer;
	
	public BankAccount()
	{
		
	}

	public BankAccount(String accno) {
		super();
		this.accno = accno;
	}


	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	@Override
	public String toString() {
		return "BankAccount [aadhar=" + customer.getAadhar() + ", accno=" + accno + "]";
	}

	public Customer getCustmer() {
		return customer;
	}

	public void setCustmer(Customer customer) {
		this.customer = customer;
	}
	

}
