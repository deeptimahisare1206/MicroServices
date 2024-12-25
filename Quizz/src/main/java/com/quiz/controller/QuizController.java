package com.quiz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizServices;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	private QuizServices quizServices;
	
	public QuizController(QuizServices quizServices) {
		this.quizServices= quizServices;
	}
	
	
	@PostMapping
	public Quiz Add(@RequestBody Quiz quiz) {
		return quizServices.add(quiz);
	}
	
	@GetMapping
	public List<Quiz> getAll(){
		return quizServices.getAll();
	}
	
	@GetMapping("/{id}")
	public Quiz getOn(@PathVariable Long id) {
		return quizServices.getOne(id);
	}
	
	

}
