package com.example.springWEB.domain;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "giangvien")
public class Teacher {
	@Id
	@Column(name = "magv")
	private String teacherId;
	@Column(name = "hovaten")
	private String name;
	@Column(name = "gioitinh")
	private String gender;
	@Column(name = "ngaysinh")
	private Date birthday;
	@Column(name = "quequan")
	private String hometown;
	@Column(name = "sodienthoai")
	private String phoneNumber;
	@Column(name = "email")
	private String email;
	@Column(name = "matkhau")
	private String password;
	@Column(name = "phanquyen")
	private String role;
	
	@ManyToOne
	@JoinColumn(name = "makhoa")
	private Department department;
	
	@OneToMany(mappedBy = "teacher")
	private List<Courses> courses;
	

	public List<Courses> getCourses() {
		return courses;
	}
	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
	public Teacher() {
		super();
	}
	public Teacher(String teacherId, String name, String gender, Date birthday, String hometown, String phoneNumber,
			String email, String password, String role, Department departmentId, List<Courses> courses) {
		super();
		this.teacherId = teacherId;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.hometown = hometown;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.role = role;
		this.department = department;
		this.courses = courses;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

}
