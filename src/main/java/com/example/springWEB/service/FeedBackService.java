package com.example.springWEB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public FeedBack saveFeedBack(int feedbackId,FeedBack feedBack) {
		Optional<FeedBack> optional = feedBackRepository.findById(feedbackId);
		if(optional.isPresent()) {
			FeedBack feedBack1 = optional.get();
			feedBack1.setFeedBackId(feedbackId);
			feedBack1.setContent(feedBack.getContent());
			feedBack1.setStatus("Duyệt");
			return feedBackRepository.save(feedBack1);
		}
		return feedBack;
	}
	public Page<FeedBack> getPage(Pageable pageable){
		return feedBackRepository.findAll(pageable);
	}
}
