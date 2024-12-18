package com.example.springWEB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Courses;
import com.example.springWEB.domain.Students;
import com.example.springWEB.domain.Teacher;
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
	
	public List<Courses> getAllCourses(){
		return coursesReponsitory.findAll();
	}
	public void deleteByCourseId(String courseId) {
		coursesReponsitory.deleteById(courseId);
	}
	public void addByCourse(Courses course) {
		coursesReponsitory.save(course);
	}
	public Courses saveCouses(String courseId,Courses course) {
		Optional<Courses> optional = coursesReponsitory.findById(courseId);
		if(optional.isPresent()) {
			Teacher teacher = new Teacher();
			Courses courseedit = optional.get();
			teacher.setTeacherId(course.getTeacher().getTeacherId());
			courseedit.setCourseName(course.getCourseName());
			courseedit.setCredit(course.getCredit());
			courseedit.setDate(course.getDate());
			courseedit.setTime(course.getTime());
			courseedit.setRoom(course.getRoom());
			courseedit.setTeacher(teacher);
			return coursesReponsitory.save(courseedit);
		}else { throw new RuntimeException("course not found with id: " + courseId);
		
				}
}
	public Page<Courses> getPage(Pageable pageable){
		return coursesReponsitory.findAll(pageable);
	}
}
	