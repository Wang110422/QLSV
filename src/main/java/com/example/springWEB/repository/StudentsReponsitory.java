package com.example.springWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.example.springWEB.domain.Students;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsReponsitory extends JpaRepository<Students, String>{
	public Optional<Students> findById(String id);
	
	public Students save(Students student);
	
	@Query("Select s from Students s")
	public List<Students> findAll();
	
	@Query("Select distinct(s.lop.classId) from Students s")
	public List<String> getAll();
	
	@Query("select s from Students s where s.lop.classId = :classId")
	public List<Students> findByClassId(@Param("classId") String classId);
}
