package com.example.model;

import java.time.LocalDate;

public class Student {
	
	private Long studentId;
	private String studentName;
	private Integer age;
	private LocalDate dob;
	private String studentEmail;
	
	//No Args Constructor
	public Student() {
		
	}
	
	//With all of the properties
	public Student(Long studentId, String studentName, Integer age, LocalDate dob, String studentEmail) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.age = age;
		this.dob = dob;
		this.studentEmail = studentEmail;
	}
	
	//Without the studentId Properties (will be provided automatically by the database)
	public Student(String studentName, Integer age, LocalDate dob, String studentEmail) {
		this.studentName = studentName;
		this.age = age;
		this.dob = dob;
		this.studentEmail = studentEmail;
	}

	//Getters
	public Long getStudentId() { return studentId; }
	public String getStudentName() { return studentName;	}
	public Integer getAge() { return age; }
	public LocalDate getDob() { return dob; }
	public String getStudentEmail() { return studentEmail; }
	
	//Setters
	public void setStudentId(Long studentId) { this.studentId = studentId; }
	public void setStudentName(String studentName) { this.studentName = studentName; }
	public void setAge(Integer age) { this.age = age; }
	public void setDob(LocalDate dob) { this.dob = dob; }
	public void setStudentEmail(String studentEmail) { this.studentEmail = studentEmail; }

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ",\nstudentName=" + studentName + ",\nage=" + age + ",\ndob=" + dob
				+ ",\nstudentEmail=" + studentEmail + "]";
	}
	
}
