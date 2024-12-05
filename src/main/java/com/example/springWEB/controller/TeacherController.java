package com.example.springWEB.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springWEB.domain.Teacher;
import com.example.springWEB.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	private String teacherId = "GV001";
	
	@GetMapping("/home")
	public String home(Model model) {
		Optional<Teacher> teacherop = teacherService.getTeacherById(teacherId);
		Teacher teacher = teacherop.get();
		model.addAttribute("teacher",teacher);
		return "teacher-home";
	}
}
