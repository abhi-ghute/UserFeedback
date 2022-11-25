package com.feedback.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.entity.FeedbackEntity;
import com.feedback.model.Feedback;
import com.feedback.repository.FeedbackRepo;

@Service
public class FeedbackService {

	@Autowired
	FeedbackRepo repo;

	public String sendFeedback(Feedback feedback) {

		FeedbackEntity entity = new FeedbackEntity();

		BeanUtils.copyProperties(feedback, entity);

		repo.save(entity);
		return "success";
	}

	public Feedback getFeedback(Integer id) {

		Optional<FeedbackEntity> optional =  repo.findById(id);
		FeedbackEntity  entity = optional.get();
		Feedback feedback =  new Feedback();
		BeanUtils.copyProperties(entity, feedback);
		
		return feedback;
	}
}
