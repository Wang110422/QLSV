package com.example.springWEB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springWEB.domain.FeedBack;
import com.example.springWEB.repository.FeedBackRepository;

@Service
public class FeedBackService {
	@Autowired
	private FeedBackRepository feedBackRepository;
	
	public FeedBack save(FeedBack content) {
		return feedBackRepository.save(content);
	}
	
	public List<FeedBack> getAllFeedBack(){
		return feedBackRepository.findAll();
	}
	public void deleteByFeedBackId(int feedBackId) {
		feedBackRepository.deleteById(feedBackId);
	}
}
