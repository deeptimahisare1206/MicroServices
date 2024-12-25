package com.questions.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questions.entities.Questions;
import com.questions.repositories.QuestionRepository;


@Service
public class QuestionServicesImplement implements QuestionServices{
	
	

	@Autowired
	private QuestionRepository questionRepository;
	
	public QuestionServicesImplement(QuestionRepository questionRepository) {
		this.questionRepository=questionRepository;
	}

	@Override
	public Questions add(Questions questions) {
		return questionRepository.save(questions);
	}

	@Override
	public List<Questions> getAll() {
		return (List<Questions>)questionRepository.findAll();
	}

	@Override
	public Questions getOne(Long question_id) {
		Optional<Questions> iterable = questionRepository.findById(question_id);
		
		return iterable.get();
	}


}
