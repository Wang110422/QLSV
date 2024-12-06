package com.example.springWEB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Score;
import com.example.springWEB.repository.ScoreRepository;
@Service
public class ScoreService {
	@Autowired
	private ScoreRepository scoreRepository;
	
	public List<Score> getScoresByStudentId(String studentId){
		return scoreRepository.findByStudentId(studentId);
	}
	public List<Score> getAllScoresByStudentIdAndCourseId(String courseId, String studentId){
		return scoreRepository.findByScoresByCourseAndStudentId(courseId, studentId);
	}
	public int countStudentByCourse(String courseId) {
		return scoreRepository.countStudentinCourse(courseId);
	}
	public List<Score> getAllStudentByCourseId(String courseId){
		return scoreRepository.getAllStudentByCourseId(courseId);
	}
	public void saveAllScores(List<Score> scores) {
		scoreRepository.saveAll(scores);
	}
}
