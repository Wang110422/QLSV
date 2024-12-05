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
}
