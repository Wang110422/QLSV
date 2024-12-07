package com.example.springWEB.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "quantri")
public class Admin {
	@Id
	@Column(name = "maQT")
	private String adminId;
	@Column(name = "hovaten")
	private String name;
	@Column(name = "matkhau")
	private String password;
	@Column(name = "phanquyen")
	private String roles;
	
	
	public Admin() {
		super();
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Admin(String adminId, String name, String password, String roles) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.password = password;
		this.roles = roles;
	}
	
	
	
}

