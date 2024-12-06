package com.example.springWEB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Courses;
import com.example.springWEB.repository.CoursesReponsitory;
@Service
public class CoursesService {
	@Autowired
	private CoursesReponsitory coursesReponsitory;
//	
	public List<Courses> getAllCourses(String studentId){
		return coursesReponsitory.findByStudentId(studentId);
	}

	public Courses getCourseByID(String courseId) {
		return coursesReponsitory.findByCourseId(courseId);
	}
	
	public List<Courses> getCourses(String teacherId) {
		return coursesReponsitory.findByTeacherId(teacherId);
		
	
	}
}
	