package com.example.springWEB.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.example.springWEB.domain.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,String>{
	 public Optional<Teacher> findById(String TeacherId);
	 
	 public Teacher save(String TeacherId);
}
