package com.quiz.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;

@Service
public class QuizServicesImplement implements QuizServices{
	
	@Autowired
	private QuizRepository quizRepository;
	
	public QuizServicesImplement(QuizRepository quizRepository) {
		this.quizRepository=quizRepository;
	}

	@Override
	public Quiz add(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getAll() {
		return (List<Quiz>)quizRepository.findAll();
	}

	@Override
	public Quiz getOne(Long id) {
		Optional<Quiz> iterable = quizRepository.findById(id);
		
		return iterable.get();
	}

}