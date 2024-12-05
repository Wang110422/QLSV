package com.example.springWEB.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "danhgia")
public class FeedBack {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "madg")
	private int feedBackId;
	@Column(name = "noidung")
	private String content;
	@Column(name = "trangthai")
	private String status;
	
	
	
	public FeedBack(String content, String status) {
		super();
		this.content = content;
		this.status = status;
	}
	public FeedBack(int feedBackId, String content, String status) {
		super();
		this.feedBackId = feedBackId;
		this.content = content;
		this.status = status;
	}
	public int getFeedBackId() {
		return feedBackId;
	}
	public void setFeedBackId(int feedBackId) {
		this.feedBackId = feedBackId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public FeedBack() {
		super();
	}
	
}
