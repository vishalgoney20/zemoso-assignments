package com.example.springbootassignment.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	


	@NotNull(message="Course Name is required ")
	@Size(min=1,message="Course Name  is required ") 
	@Column(name="title")
	private String courseName;
	
	@NotNull(message="is required ")
	@Size(min=1,message="Course Duration is required ") 
	@Column(name="duration")
	private String courseDuration;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="course_student",
			joinColumns = @JoinColumn(name="course_id"),
			inverseJoinColumns=@JoinColumn(name="student_id"))
	private List<Student> students;
	
	public Course() {
		
	}

	public Course(String courseName, String courseDuration) {
		this.courseName = courseName;
		this.courseDuration = courseDuration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseDuration=" + courseDuration /*+  ", students="
				+ students */+ "]";
	}

	/*@Override
	public String toString() {
		//String s="";
		//for(Student s1:students)
		//{
			//s=s+"Id = "+String.valueOf(s1.getId())+" , "+"first Name = "+s1.getFirstName()+" LastName = "+s1.getLastName()+" email = "+s1.getEmail();
		//	System.out.println(s);
		//}
		
		return "Course [id=" + id + ", courseName=" + courseName + ", courseDuration=" + courseDuration + "Student "+s+"]";
	}	*/
	
	

}
