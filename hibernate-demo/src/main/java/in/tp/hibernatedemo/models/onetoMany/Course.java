package in.tp.hibernatedemo.models.onetoMany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AnntCoursesBi")
public class Course {
	@Id
	private int cId;
	private String cName;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="course")
	private Set<Student> students;
	
	public Course()
	{
		
	}

	public Course(int cId, String cName, Set<Student> students) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.students = students;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Course [cId=" + cId + ", cName=" + cName + "]\n");
		if(students != null)
		{
			for(Student student : students)
				sb.append("\n"+student);
		}
		
		return sb.toString();
	}
	
	
	
	
	

}
