package com.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.model.Feedback;
import com.feedback.service.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired
	FeedbackService service;

	@PostMapping("/feedback")
	public String sendFeedback(@RequestBody Feedback feedback) {

		service.sendFeedback(feedback);
		return "success";
	}

	@GetMapping("/getFeedback")
	public Feedback getFeedback(@RequestParam Integer id) {
		Feedback feedback = service.getFeedback(id);
		System.out.println(feedback.getEmail());
		return feedback;
	}

}
