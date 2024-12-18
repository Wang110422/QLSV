package com.example.springWEB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Department;
import com.example.springWEB.domain.Teacher;
import com.example.springWEB.repository.TeacherRepository;

	@Service
	public class TeacherService {
		@Autowired
		private TeacherRepository teacherRepository;
		
		public Optional<Teacher> getTeacherById(String teacherId) {
			return teacherRepository.findById(teacherId);
		}
		
		public Teacher saveteachers(String teacherId,Teacher teacher) {
			Optional<Teacher> optional = teacherRepository.findById(teacherId);
			if(optional.isPresent()) {
				Teacher teacheredit = optional.get();
				teacheredit.setName(teacher.getName());
				teacheredit.setGender(teacher.getGender());
				teacheredit.setBirthday(teacher.getBirthday());
				teacheredit.setHometown(teacher.getHometown());
				teacheredit.setPhoneNumber(teacher.getPhoneNumber());
				teacheredit.setEmail(teacher.getEmail());
				teacheredit.setPassword(teacher.getPassword());
				teacheredit.setRole(teacher.getRole());
				teacheredit.setDepartment(teacher.getDepartment());
				return teacherRepository.save(teacheredit);
			}else { throw new RuntimeException("teacher not found with id: " + teacherId);
			
					}
		}
		
		public List<Teacher> getAllTeachers(){
			return teacherRepository.findAll();
		}
		public void deleteByTeacherId(String teacherId) {
			teacherRepository.deleteById(teacherId);
		}
		public void addTeacher(Teacher teacher) {
			teacherRepository.save(teacher);
		}
		public Optional<Teacher> findById(String username) {
			return teacherRepository.findById(username);
		}
		public List<Teacher> findTeacherByDepartmentId(String departmentId){
			return teacherRepository.findByDepartmentId(departmentId);
		}
		public List<String> getDepartmentId(){
			return teacherRepository.getAll();
		}
		
		public Page<Teacher> getPage(Pageable pageable){
			return teacherRepository.findAll(pageable);
		}
	}
	
