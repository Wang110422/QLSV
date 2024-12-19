package com.example.springWEB.controller;

import java.util.List;
import java.util.Optional;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springWEB.domain.Admin;
import com.example.springWEB.domain.Courses;
import com.example.springWEB.domain.Department;
import com.example.springWEB.domain.FeedBack;
import com.example.springWEB.domain.Lop;
import com.example.springWEB.domain.Students;
import com.example.springWEB.domain.Teacher;
import com.example.springWEB.service.AdminService;
import com.example.springWEB.service.CoursesService;
import com.example.springWEB.service.FeedBackService;
import com.example.springWEB.service.StudentService;
import com.example.springWEB.service.TeacherService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CoursesService coursesService;
	
	@Autowired
	private FeedBackService feedBackService;
	
	
	@GetMapping("/home")
	public String home(Model model,HttpSession session) {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String adminId1 = auth.getName();
		String adminId = (String) session.getAttribute("username");
		if(adminId==null) {
			return "Student/userlogin";
		}
		Optional<Admin> adminop = adminService.getAdminById(adminId);
		Admin admin = adminop.get();
		model.addAttribute("admin",admin);
		
		return "Admin/index";
	}
	@GetMapping("/student-manager")
	public String admin_student_manager(Model model, HttpSession session,@RequestParam(value = "classes", defaultValue = "all" , required = false) String classId,@RequestParam(value =  "page",defaultValue = "1") int page) {
		String adminId = (String) session.getAttribute("username");
		if(adminId==null) {
			return "Student/userlogin";
		}
		Pageable pageable = PageRequest.of(page-1, 5);
		Page<Students> pageStudent = studentService.getPage(pageable); 
		
		System.out.println(page);
		List<String> lop = studentService.getAllClass();
		Optional<Admin> adminop = adminService.getAdminById(adminId);
		Admin admin = adminop.get();
		List<Students> students ;
		if(classId.equals("all")) {
			students = pageStudent.getContent();
		}else {
			students = studentService.getStudentByClassId(classId);
		}
		model.addAttribute("students",students);
		model.addAttribute("currentPage",page);
		model.addAttribute("totalPage",pageStudent.getTotalPages());
		model.addAttribute("lop",lop);
		model.addAttribute("admin",admin);
		return "Admin/student_management";
	}
	@GetMapping("/teacher-manager")
	public String admin_teacher_manager(Model model,HttpSession session,@RequestParam(value = "departments", defaultValue = "all" , required = false) String departmentId , @RequestParam(value =  "page",defaultValue = "1") int page) {
		String adminId = (String) session.getAttribute("username");
		if(adminId==null) {
			return "Student/userlogin";
		}
		Pageable pageable = PageRequest.of(page-1, 5);
		Page<Teacher> pageTeacher = teacherService.getPage(pageable); 
		
		List<String> deparment = teacherService.getDepartmentId();
		Optional<Admin> adminop = adminService.getAdminById(adminId);
		Admin admin = adminop.get();
		List<Teacher> teachers;
		if(departmentId.equals("all")) {
			teachers = pageTeacher.getContent();
		}else {
			teachers = teacherService.findTeacherByDepartmentId(departmentId);
		}
		model.addAttribute("currentPage",page);
		model.addAttribute("totalPage",pageTeacher.getTotalPages());
		model.addAttribute("departmentIds",deparment);
		model.addAttribute("teachers",teachers);
		model.addAttribute("admin",admin);
		return "Admin/teacher_management";
	}
	@GetMapping("/course-manager")
	public String admin_course_manager(Model model,HttpSession session,@RequestParam(value =  "page",defaultValue = "1") int page) {
		String adminId = (String) session.getAttribute("username");
		if(adminId==null) {
			return "Student/userlogin";
		}
		Pageable pageable = PageRequest.of(page-1, 5);
		Page<Courses> pageCourse = coursesService.getPage(pageable); 
		
		Optional<Admin> adminop = adminService.getAdminById(adminId);
		Admin admin = adminop.get();
		List<Courses> courses = pageCourse.getContent();
		
		model.addAttribute("currentPage",page);
		model.addAttribute("totalPage",pageCourse.getTotalPages());
		model.addAttribute("courses",courses);
		model.addAttribute("admin",admin);
		return "Admin/course_management";
	}
	@GetMapping("/feedback-manager")
	public String admin_feedback_manager(Model model,HttpSession session,@RequestParam(value = "page",defaultValue = "1") int page) {
		String adminId = (String) session.getAttribute("username");
		if(adminId==null) {
			return "Student/userlogin";
		}
		Pageable pageable = PageRequest.of(page-1, 6);
		Page<FeedBack> pageFeekBack = feedBackService.getPage(pageable); 
		
		Optional<Admin> adminop = adminService.getAdminById(adminId);
		Admin admin = adminop.get();
		List<FeedBack> feedbacks = pageFeekBack.getContent();
		
		model.addAttribute("currentPage",page);
		model.addAttribute("totalPage",pageFeekBack.getTotalPages());
		model.addAttribute("feedbacks",feedbacks);
		model.addAttribute("admin",admin);
		return "Admin/feedback_management";
		
	}
	
	@PostMapping("/student-manager")
	public String admin_delete_student(@RequestParam("studentId") String studentId, Model model , RedirectAttributes redirectAttributes) {
		studentService.deleteByStudentId(studentId);
		redirectAttributes.addFlashAttribute("message2", "Xóa sinh viên có ID : " +studentId+" thành công");
		return "redirect:/admin/student-manager";
	}
	@PostMapping("/teacher-manager")
	public String admin_delete_teacher(@RequestParam("teacherId") String teacherId , RedirectAttributes redirectAttributes) {
		teacherService.deleteByTeacherId(teacherId);
		redirectAttributes.addFlashAttribute("message2", "Xóa giảng viên có ID : "+teacherId+" thành công");
		return "redirect:/admin/teacher-manager";
	}
	@PostMapping("/course-manager")
	public String admin_delete_course(@RequestParam("courseId") String courseId , RedirectAttributes redirectAttributes) {
		coursesService.deleteByCourseId(courseId);
		redirectAttributes.addFlashAttribute("message2", "Xóa khóa học có ID : "+courseId+" thành công");
		return "redirect:/admin/course-manager";
	}
	@PostMapping("feedback-manager")
	public String admin_delete_feedback(@RequestParam("feedbackId") int feedBackId , RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message2", "Xóa feedback có ID : "+feedBackId+" thành công");
		feedBackService.deleteByFeedBackId(feedBackId);
		return "redirect:/admin/feedback-manager";
	}
	@GetMapping("/course-manager/add-course")
	public String admin_add_course(Model model,HttpSession session) {
		String adminId = (String) session.getAttribute("username");
		if(adminId==null) {
			return "Student/login";
		}
		Optional<Admin> adminop = adminService.getAdminById(adminId);
		Admin admin = adminop.get();
		model.addAttribute("admin",admin);
		return "Admin/add-new-course";
	}
	@PostMapping("/course-manager/add-course")
	public String admin_add_courses(@ModelAttribute("course") Courses course , Model model, RedirectAttributes redirectAttributes) {
		System.out.println(course.getCourseId());
		String courseId = course.getCourseId().replace(",", "").trim();
		course.setCourseId(courseId);
		coursesService.addByCourse(course);
		redirectAttributes.addFlashAttribute("message1", "Đã thêm khóa học có ID : "+courseId+" thành công");	
		return "redirect:/admin/course-manager";
	}
	@GetMapping("/student-manager/add-student")
	public String admin_add_student(Model model ,HttpSession session ) {
		String adminId = (String) session.getAttribute("username");
		if(adminId==null) {
			return "Student/userlogin";
		}
		Optional<Admin> adminop = adminService.getAdminById(adminId);
		Admin admin = adminop.get();
		model.addAttribute("admin",admin);
		return "Admin/add-new-student";
	}
	@PostMapping("/student-manager/add-student")
	public String admin_add_students(@ModelAttribute("student") Students student , Model model,@RequestParam("classId") String classId , @RequestParam("departmentId") String departmentId,RedirectAttributes redirectAttributes) {
		String studentId = student.getId().replace(",", "").trim();
		student.setId(studentId);
		Lop lop = new Lop();
		Department department = new Department();
		lop.setClassId(classId);
		department.setDepartmentId(departmentId);
		student.setLop(lop);
		student.setDepartment(department);
		studentService.addStudent(student);
		redirectAttributes.addFlashAttribute("message1", "Đã thêm sinh viên có ID : "+studentId+" thành công");	
		return "redirect:/admin/student-manager";
	}
	@GetMapping("/teacher-manager/add-teacher")
	public String admin_add_teacher(Model model,HttpSession session) {
		String adminId = (String) session.getAttribute("username");
		if(adminId==null) {
			return "Student/userlogin";
		}
		Optional<Admin> adminop = adminService.getAdminById(adminId);
		Admin admin = adminop.get();
		model.addAttribute("admin",admin);
		return "Admin/add-new-teacher";
	}
	@PostMapping("/teacher-manager/add-teacher")
	public String admin_add_teachers(@ModelAttribute("teacher") Teacher teacher , Model model,@RequestParam("departmentId") String departmentId,RedirectAttributes redirectAttributes) {
		String teacherId = teacher.getTeacherId().replace(",", "").trim();
		teacher.setTeacherId(teacherId);
		System.out.println(departmentId);
		Department department = new Department();
		
		department.setDepartmentId(departmentId);
		teacher.setDepartment(department);
		
		teacherService.addTeacher(teacher);
		redirectAttributes.addFlashAttribute("message1", "Đã thêm giảng viên có ID : "+teacherId+" thành công");	
		return "redirect:/admin/teacher-manager";
	}
	@GetMapping("/course-manager/edit-course")
	public String admin_edit_course(Model model,@RequestParam("courseId1") String courseId) {
		model.addAttribute("courseId1",courseId);
		return "/Admin/edit-info-course";
	}
	
	@PostMapping("/course-manager/edit-course")
	public String admin_edit_courses(@RequestParam("courseId1") String courseId , @ModelAttribute("course") Courses course,RedirectAttributes redirectAttributes) {
		coursesService.saveCouses(courseId,course);
		System.out.println(course.getCourseId());
		System.out.println(course.getTeacher().getTeacherId());
		redirectAttributes.addFlashAttribute("message1", "Đã cập nhật khóa học thành công");
		
		return "redirect:/admin/course-manager";
	}
	@GetMapping("/student-manager/edit-student")
	public String admin_edit_student(@RequestParam("studentId1") String studentId,Model model,RedirectAttributes redirectAttributes) {
		Optional<Students> studentop = studentService.getStudentById(studentId);
		Students student = studentop.get();
		
		model.addAttribute("student",student);
		model.addAttribute("studentId1",studentId);
		return "/Admin/edit-info-student";
	}
	
	@PostMapping("/student-manager/edit-student")
	public String admin_edit_students(@RequestParam("studentId1") String studentId , @RequestParam("classId") String classId, @RequestParam("departmentId") String departmentId,  @ModelAttribute("student") Students student,RedirectAttributes redirectAttributes) 
	{
		Lop lop = new Lop();
		Department department = new Department();
		lop.setClassId(classId);
		department.setDepartmentId(departmentId);
		student.setLop(lop);
		student.setDepartment(department);
		
		studentService.saveStudents(studentId,student);
		redirectAttributes.addFlashAttribute("message1", "Đã cập nhật sinh viên thành công");

		return "redirect:/admin/student-manager";
	}
	
	
	@GetMapping("/teacher-manager/edit-teacher")
	public String admin_edit_teacher(Model model,@RequestParam("teacherId1") String teacherId ) {
		Optional<Teacher> teacherop = teacherService.getTeacherById(teacherId);
		Teacher teacher = teacherop.get();
		model.addAttribute("teacher",teacher);
		model.addAttribute("teacherId1",teacherId);
		return "/Admin/edit-info-teacher";
	}
	
	@PostMapping("/teacher-manager/edit-teacher")
	public String admin_edit_teachers(@RequestParam("teacherId1") String teacherId , @RequestParam("departmentId") String departmentId, @ModelAttribute("teacher") Teacher teacher,Model model,RedirectAttributes redirectAttributes) {
		Department department = new Department();
		department.setDepartmentId(departmentId);
		teacher.setDepartment(department);
		
		teacherService.saveteachers(teacherId,teacher);
		model.addAttribute("teacherId1",teacherId);
		redirectAttributes.addFlashAttribute("message1", "Đã cập nhật giảng viên thành công");
		return "redirect:/admin/teacher-manager";
		
	}
	@PostMapping("/feedback")
	public String admin_feedback(@RequestParam("content") String content,@RequestParam("feedbackId") int feedbackId , RedirectAttributes redirectAttributes) {
		FeedBack feedBack = new FeedBack();
		feedBack.setContent(content);
		System.out.println(feedBack.getContent());
		feedBackService.saveFeedBack(feedbackId,feedBack);
		redirectAttributes.addFlashAttribute("message1", "Feedback đã được duyệt thành công!");
		return "redirect:/admin/feedback-manager";
	}

}
 