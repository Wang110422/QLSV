package com.example.springWEB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springWEB.domain.FeedBack;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack,Integer>{
	public List<FeedBack> findAll();
	
}
