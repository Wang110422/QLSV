package com.example.springWEB.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springWEB.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{
	Optional<Admin> findByAdminId(String adminId);
}
