package com.example.springWEB.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springWEB.domain.Admin;
import com.example.springWEB.domain.Students;
import com.example.springWEB.domain.Teacher;
import com.example.springWEB.service.AdminService;
import com.example.springWEB.service.StudentService;
import com.example.springWEB.service.TeacherService;
import com.example.springWEB.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;

	@Autowired
	private StudentService studentService;
    @GetMapping("/userlogin")
    public String loginPage(Model model, String error, String logout) {
            return "Student/userlogin";
    }
    @PostMapping("/checklogin")
    public String checkLogin(@RequestParam("username") String username , @RequestParam("password") String password, HttpSession session,Model model,RedirectAttributes redirectAttributes) {
    	if(username.startsWith("SV")) {
    		if(userService.checkUserId1(username, password)) {
    			session.setAttribute("username", username);
    			Optional<Students> studentop = studentService.getStudentById(username);
    	    	Students student = studentop.get();
    	        model.addAttribute("student", student);
    			return "Student/index";
    		}else {
            	model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
    			return "Student/userlogin";
    		}
    	};
    	if(username.startsWith("GV")) {
			if(userService.checkUserId2(username, password)) {
				session.setAttribute("username", username);
				Optional<Teacher> teacherop = teacherService.getTeacherById(username);
				Teacher teacher = teacherop.get();
				model.addAttribute("teacher",teacher);
				return "Teacher/index";
			}else {
            	model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
    			return "Student/userlogin";
			}
    	};
    	if(username.startsWith("QT")) {
			if(userService.checkUserId3(username, password)) {
				session.setAttribute("username", username);
				Optional<Admin> adminop = adminService.getAdminById(username);
				Admin admin = adminop.get();
				model.addAttribute("admin",admin);
				return "Admin/index";
			}else {
            	model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
				return "Student/userlogin";
			}
    	};
    	model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
		return "Student/userlogin";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request,HttpSession session , RedirectAttributes redirectAttributes) throws ServletException {
    	String username = (String ) session.getAttribute("username");
    	request.logout();
    	session.removeAttribute("username");
    	System.out.println("Chào");
		redirectAttributes.addFlashAttribute("message1", "Đăng xuất thành công");
        return "redirect:/userlogin";
    }
}
