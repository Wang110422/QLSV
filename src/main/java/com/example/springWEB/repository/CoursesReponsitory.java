package com.example.springWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springWEB.domain.Courses;
import java.util.List;

@Repository
public interface CoursesReponsitory extends JpaRepository<Courses, String>{
	@Query("SELECT c FROM Courses c WHERE c.courseId IN (SELECT s.id.courseId FROM Score s WHERE s.id.studentId = :studentId)")
	List<Courses> findByStudentId(@Param("studentId") String studentId);
	
	Courses  findByCourseId(String courseId);
	
	@Query("Select c from Courses c where c.teacher.teacherId = :teacherId")
	List<Courses> findByTeacherId(@Param("teacherId") String teacherId);
	
	
	
}	
	