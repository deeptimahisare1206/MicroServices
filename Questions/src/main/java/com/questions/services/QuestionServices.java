package com.questions.services;

import java.util.List;

import com.questions.entities.Questions;

public interface QuestionServices {
	
	public Questions add(Questions questions);
	public List<Questions> getAll();
	public Questions getOne(Long questions_id);
	
}
