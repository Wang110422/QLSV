//package com.example.springWEB.domain;
//
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//
//import java.util.List;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//
//@Entity
//@Table(name = "Users")
//public class Users {
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
//    private long id;
//    private String ma;
//    private String fullname;
//    private String password;
//
//    // roleId
//    // users n -> 1 roles
//    @ManyToOne
//    @JoinColumn(name = "roles_id") // user la chu nen su dung joincolumn voi name = "tenduoi_id"
//    private Roles roles;
//
//    public Roles getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Roles roles) {
//        this.roles = roles;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//
//    public String getMa() {
//		return ma;
//	}
//
//	public void setMa(String ma) {
//		this.ma = ma;
//	}
//
//	public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getFullname() {
//        return fullname;
//    }
//
//    public void setFullname(String fullname) {
//        this.fullname = fullname;
//    }
//
//	@Override
//	public String toString() {
//		return "Users [id=" + id + ", ma=" + ma + ", fullname=" + fullname + ", password=" + password + ", roles="
//				+ roles + "]";
//	}
//
//
//}
