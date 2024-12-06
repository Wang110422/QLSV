package com.example.springWEB.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	}
	
