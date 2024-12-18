package com.example.springWEB.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
			return studentsRepository.save(studentedit);
		}else { throw new RuntimeException("Student not found with id: " + studentId);
		
				}
	
	}
	public List<Students> getAllStudent(){
		return studentsRepository.findAll();
	}
	public Optional<Students> findById(String username) {
		return studentsRepository.findById(username);
	}
	
	public void deleteByStudentId(String studentId) {
		studentsRepository.deleteById(studentId);
	}
	public void addStudent(Students student) {
		studentsRepository.save(student);
	}
	public List<String> getAllClass(){
		return studentsRepository.getAll();
	}
	public List<Students> getStudentByClassId(String classId){
		return studentsRepository.findByClassId(classId);
	}
	public Page<Students> getPage(Pageable pageable){
		return studentsRepository.findAll(pageable);
	}
}