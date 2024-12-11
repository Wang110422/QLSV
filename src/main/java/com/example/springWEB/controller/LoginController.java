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
    @GetMapping("/login")
    public String loginPage(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("errorMessage", "Sai tên đăng nhập hoặc mật khẩu!");
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "Đăng xuất thành công!");
        }
        return "Student/login";
    }
    @PostMapping("/checklogin")
    public String checkLogin(@RequestParam("username") String username , @RequestParam("password") String password, HttpSession session,Model model) {
    	if(username.startsWith("SV")) {
    		if(userService.checkUserId1(username, password)) {
    			session.setAttribute("username", username);
    			Optional<Students> studentop = studentService.getStudentById(username);
    	    	Students student = studentop.get(); 
    	        model.addAttribute("student", student); 
    			return "Student/home";
    		}else {
    			return "Student/login";
    		}
    	}
    	if(username.startsWith("GV")) {
			if(userService.checkUserId2(username, password)) {
				session.setAttribute("username", username);
				Optional<Teacher> teacherop = teacherService.getTeacherById(username);
				Teacher teacher = teacherop.get();
				model.addAttribute("teacher",teacher);
				return "Teacher/teacher-home";
			}else {
    			return "Student/login";
			}
    	}
    	if(username.startsWith("QT")) {
			if(userService.checkUserId3(username, password)) {
				session.setAttribute("username", username);
				Optional<Admin> adminop = adminService.getAdminById(username);
				Admin admin = adminop.get();
				model.addAttribute("admin",admin);
				return "Admin/home";
			}else {
				return "Student/login";
			}
    	}
		return "Student/login";
    }
//    @GetMapping("/processUserId")
//    public String processUserId(Model model ) {
////    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////    	String userId = auth.getName();
//    	model.addAttribute("admin",userId);
//    	return "Amin/home";
//    }

//    @GetMapping("/redirect-after-login")
//    public String redirectAfterLogin() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        
//        String userId = auth.getName();
//        
//        String role = auth.getAuthorities().stream().findFirst().get().getAuthority();
        
//        httpSession.setAttribute("userId", userId);

//        if (role.equals("ROLE_QT")) {
//            return "redirect:/admin/home";
//        } else if (role.equals("ROLE_GV")) {
//            return "redirect:/teacher/home";
//        } else if (role.equals("ROLE_SV")) {
//            return "redirect:/student/home";
//        } else {
//            return "redirect:/login?error=true";
//        }
//    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpSession session) throws ServletException {
    	String username = (String ) session.getAttribute("username");
    	request.logout();
    	session.removeAttribute("username");
        return "redirect:/login?logout=true";
    }
}
