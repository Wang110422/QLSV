//package com.example.springWEB.service;
//
//
//import com.example.springWEB.domain.Admin;
//import com.example.springWEB.domain.Students;
//import com.example.springWEB.domain.Teacher;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private StudentService studentService;
//
//    @Autowired
//    private TeacherService teacherService;
//
//    @Autowired
//    private AdminService adminService;
//
//    @Override
//    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//        String role = extractRole(userId);
//
//        if (role.equals("SV")) {
//            Optional<Students> student1 = studentService.getStudentById(userId);
//            Students student = student1.get();
//            if (student == null) throw new UsernameNotFoundException("Sinh viên không tồn tại!");
//            return User.builder()
//                    .username(student.getId())
//                    .password(student.getPassword())
//                    .roles("SV")	
//                    .build();
//        } else if (role.equals("GV")) {
//            Optional<Teacher> teacher1 = teacherService.getTeacherById(userId);
//            Teacher teacher = teacher1.get();
//            if (teacher == null) throw new UsernameNotFoundException("Giảng viên không tồn tại!");
//            return User.builder()
//                    .username(teacher.getTeacherId())
//                    .password(teacher.getPassword())
//                    .roles("GV")
//                    .build();
//        } else if (role.equals("QT")) {
//            Optional<Admin> admin1 = adminService.getAdminById(userId);
//            Admin admin = admin1.get();
//            if (admin == null) throw new UsernameNotFoundException("Quản trị không tồn tại!");
//            return User.builder()
//                    .username(admin.getAdminId())
//                    .password(admin.getPassword())
//                    .roles("QT")
//                    .build();
//        } else {
//            throw new UsernameNotFoundException("Không tìm thấy người dùng với mã: " + userId);
//        }
//    }
//
//    private String extractRole(String userId) {
//        if (userId.startsWith("SV")) return "SV";
//        if (userId.startsWith("GV")) return "GV";
//        if (userId.startsWith("QT")) return "QT";
//        return "";
//    }
//}
