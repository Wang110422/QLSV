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
@Table(name = "sinhvien")
public class Students {
	@Id
	@Column(name = "masv")
	private String id;
	@Column(name = "hovaten")
	private String name;
	@Column(name = "gioitinh")
	private String gender;
	@Column(name ="ngaysinh")
	private Date birthday;
	@Column(name ="quequan")
	private String hometown;
	@Column(name ="sodienthoai")
	private String phonenumber;
	@Column(name = "email")
	private String email;
	@Column(name = "matkhau")
	private String password;
	@Column(name = "phanquyen")
	private String roles;
	
	@ManyToOne
	@JoinColumn(name ="malop")
	private Lop lop;
	@ManyToOne
	@JoinColumn(name = "makhoa")
	private Department department;
	
	@OneToMany(mappedBy = "student")
	private List<Score> scores;
	
	@OneToMany(mappedBy = "student")
	private List<TimeTable> timetables;
	
	
	public Students() {
		super();
	}
	public Students(String id) {
		this.id=id;
	}

	public Students(String id, String name, String gender, Date birthday, String hometown, String phonenumber,
			String email, String password, String roles, Lop lop, Department department, List<Score> scores,
			List<TimeTable> timetables) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.hometown = hometown;
		this.phonenumber = phonenumber;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.lop = lop;
		this.department = department;
		this.scores = scores;
		this.timetables = timetables;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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


	public String getRoles() {
		return roles;
	}


	public void setRoles(String roles) {
		this.roles = roles;
	}


	public Lop getLop() {
		return lop;
	}


	public void setLop(Lop lop) {
		this.lop = lop;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public List<Score> getScores() {
		return scores;
	}


	public void setScores(List<Score> scores) {
		this.scores = scores;
	}


	public List<TimeTable> getTimetables() {
		return timetables;
	}


	public void setTimetables(List<TimeTable> timetables) {
		this.timetables = timetables;
	}

}