package com.example.springWEB.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "hocphan")
public class Courses {
	@Id
	@Column(name = "mahp")
	private String courseId;
	@Column(name = "tenhp")
	private String courseName;
	@Column(name = "sotc")
	private int credit;
	@Column(name = "ngayhoc")
	private String date;
	@Column(name = "cahoc")
	private String time;
	@Column(name = "phonghoc")
	private String room;
	
	@ManyToOne
	@JoinColumn(name = "magv")
	private Teacher teacher;
	
	@OneToMany(mappedBy = "course")
	private List<Score> scores;
	
	@OneToMany(mappedBy = "course")
	private List<TimeTable> timetables;

	public Courses(String courseId, String courseName, int credit, String date, String time, String room,
			Teacher teacher, List<Score> scores, List<TimeTable> timetables) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.credit = credit;
		this.date = date;
		this.time = time;
		this.room = room;
		this.teacher = teacher;
		this.scores = scores;
		this.timetables = timetables;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public List<TimeTable> getTimetables() {
		return timetables;
	}

	public void setTimetables(List<TimeTable> timetables) {
		this.timetables = timetables;
	}

	public Courses() {
		super();
	}

	
}
