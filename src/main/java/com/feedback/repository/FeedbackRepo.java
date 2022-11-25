package com.feedback.repository;

import org.springframework.data.repository.CrudRepository;

import com.feedback.entity.FeedbackEntity;

public interface FeedbackRepo extends CrudRepository<FeedbackEntity, Integer>{

}
