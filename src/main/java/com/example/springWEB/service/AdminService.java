package com.example.springWEB.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Admin;
import com.example.springWEB.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public Optional<Admin> getAdminById(String adminId) {
		return adminRepository.findByAdminId(adminId);
	}
}
