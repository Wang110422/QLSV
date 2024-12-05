package com.example.springWEB.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "khoa")
public class Department {
	@Id
	@Column(name = "makhoa")
	private String departmentId;
	@Column(name = "tenkhoa")
	private String departmentName;
	
	@OneToMany(mappedBy = "department")
	private List<Teacher> teachers;
	
	@OneToMany(mappedBy = "department")
	private List<Students> students;	
	
	@OneToMany(mappedBy = "department")
	private List<Lop> lop;

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	public List<Lop> getLop() {
		return lop;
	}

	public void setLop(List<Lop> lop) {
		this.lop = lop;
	}

	public Department(String departmentId, String departmentName, List<Teacher> teachers, List<Students> students,
			List<Lop> lop) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.teachers = teachers;
		this.students = students;
		this.lop = lop;
	}

	public Department() {
		super();
	}
	
	
}
