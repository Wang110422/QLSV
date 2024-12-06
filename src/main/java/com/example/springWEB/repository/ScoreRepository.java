package com.example.springWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springWEB.domain.Score;
import com.example.springWEB.domain.ScoreId;

import java.util.List;


@Repository
public interface ScoreRepository extends JpaRepository<Score,ScoreId> {
	List<Score> findByStudentId(String studentId);
	 
	@Query("SELECT s FROM Score s WHERE s.id.courseId = :courseId AND s.id.studentId = :studentId")
	List<Score> findByScoresByCourseAndStudentId(@Param("courseId") String courseId , @Param("studentId") String studentId);
	
	@Query("SELECT COUNT(DISTINCT s.id.studentId) from Score s where s.id.courseId =:courseId")
	int countStudentinCourse(@Param("courseId") String courseId);
	
	@Query("Select s from Score s where s.id.courseId = :courseId")
	List<Score> getAllStudentByCourseId(@Param("courseId") String courseId);


}
