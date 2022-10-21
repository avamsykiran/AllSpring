package in.tp.jpa.hib.demo.models.example1.compositepk;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TabStudents")
public class Student {

	@EmbeddedId
	private StudentIdentity sid;
	
	@Column(name="fnm",nullable=false)
	private String firstName;
	
	@Column(name="lnm")
	private String lastName;
	
	@Column(name="dob",nullable=false)
	private Date dateOfBirth;
	
	public Student(){}

	public Student(StudentIdentity sid, String firstName, String lastName,
			Date dateOfBirth) {
		super();
		this.sid = sid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public StudentIdentity getSid() {
		return sid;
	}

	public void setSid(StudentIdentity sid) {
		this.sid = sid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Student ["+sid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}
	
	
}
