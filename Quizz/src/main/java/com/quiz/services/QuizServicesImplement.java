package com.quiz.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;

@Service
public class QuizServicesImplement implements QuizServices{
	
	@Autowired
	private QuizRepository quizRepository;
	
	private QuestionClient questionClient;
	
	public QuizServicesImplement(QuizRepository quizRepository,QuestionClient questionClient) {
		this.quizRepository=quizRepository;
		this.questionClient= questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getAll() {
		List<Quiz> quizzes = (List<Quiz>)quizRepository.findAll();
		
		List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
			quiz.setQuestion(questionClient.getQuestionofQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		return newQuizList;
		
		
	}

	@Override
	public Quiz getOne(Long id) {
		Quiz quiz = quizRepository.findById(id).get();
		quiz.setQuestion(questionClient.getQuestionofQuiz(quiz.getId()));
		return quiz;
	}

	

}
