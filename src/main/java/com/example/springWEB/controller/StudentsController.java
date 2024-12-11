package com.example.springWEB.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springWEB.domain.Courses;
import com.example.springWEB.domain.FeedBack;
import com.example.springWEB.domain.Score;
import com.example.springWEB.domain.Students;
import com.example.springWEB.service.CoursesService;
import com.example.springWEB.service.FeedBackService;
import com.example.springWEB.service.ScoreService;
import com.example.springWEB.service.StudentService;
import com.mysql.cj.xdevapi.Session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/student")
public class StudentsController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private FeedBackService feedBackService;
	@Autowired
	private CoursesService coursesService;
	
	
	@PostMapping("/home")
	public String studentToHome(Model model, HttpSession session) {
		String studentID = (String) session.getAttribute("username");
		if(studentID==null) {
			return "Student/login";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
    	Students student = studentop.get();
        model.addAttribute("student", student);
		return "Student/home";
	}
	@GetMapping("/home") 
	public String studentHome(Model model,HttpSession session) {
		String studentID = (String) session.getAttribute("username");
		if(studentID==null) {
			return "Student/login";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
    	Students student = studentop.get();
        model.addAttribute("student", student);
		return "Student/home";
	}
	
	@GetMapping("/infor")	
	public String getStudentInfo(Model model, HttpSession session) {
		String studentID = (String) session.getAttribute("username");
		if(studentID==null) {
			return "Student/login";
		}
        Optional<Students> studentop = studentService.getStudentById(studentID);
        	Students student = studentop.get();
            model.addAttribute("student", student);
        return "Student/student-infor";
    }

	@GetMapping("/course")
	public String studentCourse(Model model, HttpSession session) {
		String studentID = (String) session.getAttribute("username");
		if(studentID==null) {
			return "Student/login";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
		List<Courses> courses = coursesService.getAllCourses(studentID);
    	Students student = studentop.get();
        model.addAttribute("student", student);
        model.addAttribute("courses", courses);    	
		return "Student/student-course";
	}
	
	@GetMapping("/timetable")
	public String studentTimeTable(Model model , HttpSession session) {
		String studentID = (String) session.getAttribute("username");
		if(studentID==null) {
			return "Student/login";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
    	Students student = studentop.get();
        model.addAttribute("student", student);
        
		List<Courses> courses = coursesService.getAllCourses(studentID);
        model.addAttribute("courses", courses);    	
		return "Student/timetable";
	}
	
	@GetMapping("/feedback")
	public String studentFeedBack(Model model , HttpSession session) {
		String studentID = (String) session.getAttribute("username");
		if(studentID==null) {
			return "Student/login";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
    	Students student = studentop.get();
        model.addAttribute("student", student);
		return "Student/feedback";
	}
	
	@PostMapping("/feedback")
	public String saveFeedBack(@RequestParam("content") String content,Model model) {
		FeedBack feedBack = new FeedBack(content,"Chưa duyệt");
		feedBackService.save(feedBack);
		model.addAttribute("feedback",feedBack);
		return "redirect:/student/feedback";
	}
	
	
	@GetMapping("/course-scores")
	public String studentScore(@RequestParam("courseId") String courseId, Model model , HttpSession session) {
		String studentID = (String) session.getAttribute("studentID");
		if(studentID==null) {
			return "Student/login";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
    	Students student = studentop.get();
    	model.addAttribute("student",student);
    	
		List<Score> scores = scoreService.getAllScoresByStudentIdAndCourseId(courseId, studentID);
		Courses courses = coursesService.getCourseByID(courseId);
		model.addAttribute("courses",courses);
		model.addAttribute("scores",scores);
		return "Student/student-score";
	}
	@GetMapping("/infor/change")
	public String studentChangeInfor(Model model , HttpSession session) {
		String studentID = (String) session.getAttribute("studentID");
		if(studentID==null) {
			return "Student/login";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
    	Students student = studentop.get();
        model.addAttribute("student", student);
		return "Student/student-changeinfor";
	}
	@PostMapping("/infor/change")
	public String StudentChange(@ModelAttribute("student") Students student, Model model , HttpSession session) {
		String studentID = (String) session.getAttribute("studentID");
		if(studentID==null) {
			return "Student/login";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
    	Students student1 = studentop.get();
		student.setId(studentID);
		student.setDepartment(student1.getDepartment());
		student.setLop(student1.getLop());
		studentService.saveStudents(studentID,student);
		model.addAttribute("student",student);
		return "redirect:/student/infor";
	}
}
