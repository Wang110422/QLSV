package com.example.springWEB.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.example.springWEB.domain.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,String>{
	 public Optional<Teacher> findById(String TeacherId);
	 
	 public Teacher save(String TeacherId);
	 
	 public List<Teacher> findAll();
	 
	 @Query("Select t from Teacher t where t.department.departmentId = :departmentId")
	 public List<Teacher> findByDepartmentId(@Param("departmentId") String departmentId);
	 
	 @Query("Select distinct(t.department.departmentId) from Teacher t")
	 public List<String> getAll();
}
