package in.tp.jpa.hib.demo.models.example1.compositepk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class StudentIdentity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int rollNumber;
	private char section;
	private int clazz;
	
	public StudentIdentity(){}

	public StudentIdentity(int rollNumber, char section, int clazz) {
		super();
		this.rollNumber = rollNumber;
		this.section = section;
		this.clazz = clazz;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public char getSection() {
		return section;
	}

	public void setSection(char section) {
		this.section = section;
	}

	public int getClazz() {
		return clazz;
	}

	public void setClazz(int clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "StudentIdentity [rollNumber=" + rollNumber + ", section="
				+ section + ", clazz=" + clazz + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	
}
