package com.example.springWEB.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "thoikhoabieu")
public class TimeTable {
	@Id
	@ManyToOne
	@JoinColumn(name = "masv")
	private Students student;
	@Id
	@ManyToOne
	@JoinColumn(name = "mahp")
	private Courses course;
	
	public Students getStudent() {
		return student;
	}
	public void setStudent(Students student) {
		this.student = student;
	}
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	public TimeTable(Students student, Courses course) {
		super();
		this.student = student;
		this.course = course;
	}
	public TimeTable() {
		super();
	}
	

}
