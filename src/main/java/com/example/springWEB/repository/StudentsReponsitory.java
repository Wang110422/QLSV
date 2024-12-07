package com.example.springWEB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
	
}
