package com.example.springWEB.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Students;
import com.example.springWEB.repository.StudentsReponsitory;
@Service
public class StudentService{
	@Autowired
	private StudentsReponsitory studentsRepository;
	
	public Optional<Students> getStudentById(String id) {
		return studentsRepository.findById(id);
	}
	
	public Students saveStudents(String studentId,Students student) {
		Optional<Students> optional = studentsRepository.findById(studentId);
		if(optional.isPresent()) {
			Students studentedit = optional.get();
			studentedit.setName(student.getName());
			studentedit.setGender(student.getGender());
			studentedit.setBirthday(student.getBirthday());
			studentedit.setHometown(student.getHometown());
			studentedit.setPhonenumber(student.getPhonenumber());
			studentedit.setEmail(student.getEmail());
			studentedit.setPassword(student.getPassword());
			studentedit.setRoles(student.getRoles());
			studentedit.setLop(student.getLop());
			studentedit.setDepartment(student.getDepartment());
			studentedit.setScores(student.getScores());
			studentedit.setTimetables(student.getTimetables());
			return studentsRepository.save(student);
		}else { throw new RuntimeException("Student not found with id: " + studentId);
		
	}

}
	
}