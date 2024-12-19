package com.example.springWEB.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springWEB.domain.Courses;
import com.example.springWEB.domain.Department;
import com.example.springWEB.domain.FeedBack;
import com.example.springWEB.domain.Score;
import com.example.springWEB.domain.Students;
import com.example.springWEB.domain.Teacher;
import com.example.springWEB.service.CoursesService;
import com.example.springWEB.service.FeedBackService;
import com.example.springWEB.service.ScoreService;
import com.example.springWEB.service.TeacherService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CoursesService coursesService;
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private FeedBackService feedBackService;
	
	
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		String teacherId = (String) session.getAttribute("username");
		if(teacherId==null) {
			return "Student/userlogin";
		}
		Optional<Teacher> teacherop = teacherService.getTeacherById(teacherId);
		Teacher teacher = teacherop.get();
		model.addAttribute("teacher",teacher);
		return "Teacher/index";
	}
	@GetMapping("/infor")
	public String infor(Model model , HttpSession session) {
		String teacherId = (String) session.getAttribute("username");
		if(teacherId==null) {
			return "Student/userlogin";
		}
		Optional<Teacher> teacherop = teacherService.getTeacherById(teacherId);
		Teacher teacher = teacherop.get();
		model.addAttribute("teacher",teacher);
		return "Teacher/info-teacher";
	}
	@GetMapping("/infor/change")
	public String teacherChangeInfor(Model model , HttpSession session) {
		String teacherId = (String) session.getAttribute("username");
		if(teacherId==null) {
			return "Student/userlogin";
		}
		Optional<Teacher> teacherop = teacherService.getTeacherById(teacherId);
    	Teacher teacher = teacherop.get();
        model.addAttribute("teacher", teacher);
		return "Teacher/infochange";
	}
	@PostMapping("/infor/change")
	public String teacherChange(@ModelAttribute("teacher") Teacher teacher, Model model , HttpSession session,RedirectAttributes redirectAttributes) {
		String teacherId = (String) session.getAttribute("username");
		if(teacherId==null) {
			return "Student/userlogin";
		}
		Department department = new Department();
		Optional<Teacher> teacherop = teacherService.getTeacherById(teacherId);
    	Teacher teacher1 = teacherop.get();
		model.addAttribute("teacher",teacher1);
		
		System.out.println(teacher.getEmail());
		System.out.println(teacher.getPhoneNumber());
		
		
		department.setDepartmentId(teacher1.getDepartment().getDepartmentId());
		teacher.setDepartment(department);
		teacherService.saveteachers(teacherId,teacher);
		redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thông tin thành công");
		return "redirect:/teacher/infor";
	}
	@GetMapping("/info-course")
	public String teacherCourse(Model model , HttpSession session) {
		String teacherId = (String) session.getAttribute("username");
		if(teacherId==null) {
			return "Student/userlogin";
		}
		List<Integer> counts = new ArrayList<>();
		Optional<Teacher> teacherop = teacherService.getTeacherById(teacherId);
		List<Courses> courses = coursesService.getCourses(teacherId);
		for(Courses course : courses) {
			counts.add(scoreService.countStudentByCourse(course.getCourseId()));
		}
    	Teacher teacher = teacherop.get();  			
        model.addAttribute("teacher", teacher);
        model.addAttribute("courses", courses);
        model.addAttribute("count",counts);
		return "Teacher/info-course";
	}
	@GetMapping("/course-score")
	public String studentScore(@RequestParam("courseId") String courseId, Model model , HttpSession session) {
		String teacherId = (String) session.getAttribute("username");
		if(teacherId==null) {
			return "Student/userlogin";
		}
		Optional<Teacher> teacherop = teacherService.getTeacherById(teacherId);
    	Teacher teacher = teacherop.get();
    	model.addAttribute("teacher",teacher);
    	
		Courses courses = coursesService.getCourseByID(courseId);
		List<Score> scores = scoreService.getAllStudentByCourseId(courseId);
		model.addAttribute("courses",courses);
		model.addAttribute("scores",scores);
		return "Teacher/manage_studentscore";
	}
	@PostMapping("/info-course")
	public String studentScore1(@RequestParam("courseId") String courseId,
								@RequestParam List<Double> score1,
								@RequestParam List<Double> score2,
								@RequestParam List<Double> lastscore,Model model , HttpSession session , RedirectAttributes redirectAttributes) {
		String teacherId = (String) session.getAttribute("username");
		if(teacherId==null) {
			return "Student/userlogin";
		}
		System.out.println(courseId);
		List<Score> scores = scoreService.getAllStudentByCourseId(courseId);
		for(int i=0;i<scores.size();i++) {
			scores.get(i).setScore1(score1.get(i));
			scores.get(i).setScore2(score2.get(i));
			scores.get(i).setLastscore(lastscore.get(i));
		}
		scoreService.saveAllScores(scores);
		redirectAttributes.addFlashAttribute("message", "Cập nhật điểm sinh viên thành công");
		return "redirect:/teacher/info-course?courseId=" + courseId;
	}
	@GetMapping("/schedule")
	public String teacherTimeTable(Model model , HttpSession session) {
		String teacherId = (String) session.getAttribute("username");
		if(teacherId==null) {
			return "Student/userlogin";
		}
		Optional<Teacher> teacherop = teacherService.getTeacherById(teacherId);
    	Teacher teacher = teacherop.get();
    	List<Courses> courses = coursesService.getCourses(teacherId);
    	model.addAttribute("teacher",teacher);
    	model.addAttribute("courses",courses);
    	return "Teacher/schedule";
	}
	@GetMapping("/userfeedback")
	public String teacherFeedBack(Model model, HttpSession session) {
		String teacherId = (String) session.getAttribute("username");
		if(teacherId==null) {
			return "Student/userlogin";
		}
		Optional<Teacher> teacherop = teacherService.getTeacherById(teacherId);
    	Teacher teacher = teacherop.get();
        model.addAttribute("teacher", teacher);
		return "Teacher/userfeedback";
	}
	
	@PostMapping("/userfeedback")
	public String saveFeedBack(@RequestParam("content") String content,Model model,RedirectAttributes redirectAttributes) {
		FeedBack feedBack = new FeedBack(content,"Chưa duyệt");
		feedBackService.save(feedBack);
		model.addAttribute("feedback",feedBack);
		redirectAttributes.addFlashAttribute("message", "Gửi phản hồi thành công");
		return "redirect:/teacher/userfeedback";
	}
	
	
}
