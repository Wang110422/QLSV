package com.example.springWEB.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "lop")
public class Lop {
	@Id
	@Column(name = "malop")
	private String classId;
	@Column(name = "tenlop")
	private String className;
	
	@ManyToOne
	@JoinColumn(name = "makhoa")
	private Department department;
	
	@OneToMany(mappedBy = "lop")
	private List<Students> students;
	
	public Lop() {
		super();
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Department getDepartment() {
		return department;
	}
	public List<Students> getStudents() {
		return students;
	}
	public void setStudents(List<Students> students) {
		this.students = students;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Lop(String classId, String className, Department department, List<Students> students) {
		super();
		this.classId = classId;
		this.className = className;
		this.department = department;
		this.students = students;
	}
	public void setMaKhoa(Department department) {
		this.department = department;
	}
	
}
