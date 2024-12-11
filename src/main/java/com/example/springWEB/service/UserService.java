package com.example.springWEB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Admin;
import com.example.springWEB.domain.Students;
import com.example.springWEB.domain.Teacher;



@Service
public class UserService {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired 
	private StudentService studentService;
	
	public boolean checkUserId1(String username , String password) {
		Optional<Students> studentop = studentService.findById(username);
		if(studentop.isPresent() && studentop.get().getPassword().equals(password)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean checkUserId2(String username , String password) {
		Optional<Teacher> teacherop = teacherService.findById(username);
		if(teacherop.isPresent() && teacherop.get().getPassword().equals(password)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean checkUserId3(String username , String password) {
		Optional<Admin> adminop = adminService.getAdminById(username);
		if(adminop.isPresent() && adminop.get().getPassword().equals(password)) {
			return true;
		}else {
			return false;
		}
	}
}
