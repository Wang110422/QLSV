package com.example.springWEB.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "diemhocphan")
public class Score {
	@EmbeddedId 
	private ScoreId id;
	
	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(name = "mahp", insertable = false, updatable = false)
	private Courses course;
	
	@ManyToOne
	@MapsId("studentId")
	@JoinColumn(name = "masv",insertable = false, updatable = false)
	private Students student;
	
	@Column(name = "diem1")
	private double score1;
	@Column(name = "diem2")
	private double score2;
	@Column(name = "diemthi")
	private double lastscore;
	public Score(Courses course, Students student, double score1, double score2, double lastscore) {
		super();
		this.course = course;
		this.student = student;
		this.score1 = score1;
		this.score2 = score2;
		this.lastscore = lastscore;
	}
	public Courses getCourse() {
		return course;
	}
	public void setCourse(Courses course) {
		this.course = course;
	}
	public Students getStudent() {
		return student;
	}
	public void setStudent(Students student) {
		this.student = student;
	}
	public double getScore1() {
		return score1;
	}
	public void setScore1(double score1) {
		this.score1 = score1;
	}
	public double getScore2() {
		return score2;
	}
	public void setScore2(double score2) {
		this.score2 = score2;
	}
	public double getLastscore() {
		return lastscore;
	}
	public void setLastscore(double lastscore) {
		this.lastscore = lastscore;
	}
	public Score() {
		super();
	}
	
	
}