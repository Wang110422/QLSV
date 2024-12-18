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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	

	@PostMapping("/index")
	public String studentToHome(Model model, HttpSession session) {
		String studentID = (String) session.getAttribute("username");
		if(studentID==null) {
			return "Student/userlogin";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
    	Students student = studentop.get();
        model.addAttribute("student", student);
		return "Student/index";
	}
	@GetMapping("/index")
	public String studentHome(Model model,HttpSession session) {
		String studentID = (String) session.getAttribute("username");
		if(studentID==null) {
			return "Student/userlogin";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
    	Students student = studentop.get();
        model.addAttribute("student", student);
		return "Student/index";
	}
	
	@GetMapping("/infor")	
	public String getStudentInfo(Model model, HttpSession session) {
		String studentID = (String) session.getAttribute("username");
		if(studentID==null) {
			return "Student/userlogin";
		}
        Optional<Students> studentop = studentService.getStudentById(studentID);
        	Students student = studentop.get();
            model.addAttribute("student", student);
        return "Student/info-student";
    }

	@GetMapping("/info-course")
	public String studentCourse(Model model, HttpSession session) {
		String studentID = (String) session.getAttribute("username");
		if(studentID==null) {
			return "Student/userlogin";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
		List<Courses> courses = coursesService.getAllCourses(studentID);
    	Students student = studentop.get();
        model.addAttribute("student", student);
        model.addAttribute("courses", courses);    	
		return "Student/info-course";
	}
	
	@GetMapping("/schedule")
	public String studentTimeTable(Model model , HttpSession session) {
		String studentID = (String) session.getAttribute("username");
		if(studentID==null) {
			return "Student/userlogin";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
    	Students student = studentop.get();
        model.addAttribute("student", student);
        
		List<Courses> courses = coursesService.getAllCourses(studentID);
        model.addAttribute("courses", courses);    	
		return "Student/schedule";
	}
	
	@GetMapping("/userfeedback")
	public String studentFeedBack(Model model , HttpSession session) {
		String studentID = (String) session.getAttribute("username");
		if(studentID==null) {
			return "Student/userlogin";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
    	Students student = studentop.get();
        model.addAttribute("student", student);
		return "Student/userfeedback";
	}
	
	@PostMapping("/userfeedback")
	public String saveFeedBack(@RequestParam("content") String content,Model model , RedirectAttributes redirectAttributes) {
		FeedBack feedBack = new FeedBack(content,"Chưa duyệt");
		feedBackService.save(feedBack);
		model.addAttribute("feedback",feedBack);
		redirectAttributes.addFlashAttribute("message", "Gửi phản hồi thành công");
		return "redirect:/student/userfeedback";
	}
	
	
	@GetMapping("/scores")
	public String studentScore(@RequestParam("courseId") String courseId, Model model , HttpSession session) {
		String studentID = (String) session.getAttribute("username");
		if(studentID==null) {
			return "Student/userlogin";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
    	Students student = studentop.get();
    	model.addAttribute("student",student);
    	
		List<Score> scores = scoreService.getAllScoresByStudentIdAndCourseId(courseId, studentID);
		Courses courses = coursesService.getCourseByID(courseId);
		model.addAttribute("courses",courses);
		model.addAttribute("scores",scores);
		return "Student/scores";
	}
	@GetMapping("/infor/change")
	public String studentChangeInfor(Model model , HttpSession session) {
		String studentID = (String) session.getAttribute("username");
		if(studentID==null) {
			return "Student/userlogin";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
    	Students student = studentop.get();
        model.addAttribute("student", student);
		return "Student/infochange";
	}
	@PostMapping("/infor/change")
	public String StudentChange(@ModelAttribute("student") Students student, Model model , HttpSession session , RedirectAttributes redirectAttributes) {
		String studentID = (String) session.getAttribute("username");
		if(studentID==null) {
			return "Student/userlogin";
		}
		Optional<Students> studentop = studentService.getStudentById(studentID);
    	Students student1 = studentop.get();
		student.setId(studentID);
		student.setDepartment(student1.getDepartment());
		student.setLop(student1.getLop());
		studentService.saveStudents(studentID,student);
		model.addAttribute("student",student);
		redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thông tin thành công");
		return "redirect:/student/infor";
	}
	//new content

}
