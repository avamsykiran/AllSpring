package in.tp.hibernatedemo.models.onetoMany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AnntStudentsBi")
public class Student implements Comparable<Student> {
	
	@Id
	private int admNo;
	private String sName;
	
	@ManyToOne
    @JoinColumn(name="cid")
	private Course course;
	
	public Student()
	{
		
	}

	public Student(int admNo, String sName,Course course) {
		super();
		this.admNo = admNo;
		this.sName = sName;
		setCourse(course);
	}

	public int getAdmNo() {
		return admNo;
	}

	public void setAdmNo(int admNo) {
		this.admNo = admNo;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	@Override
	public String toString() {
		return "Student [admNo=" + admNo + ", sName=" + sName + "]";
	}

	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int compareTo(Student o) {
		return (this.admNo<o.admNo?-1:(this.admNo>o.admNo?1:0));
	}
	
	
	

}
