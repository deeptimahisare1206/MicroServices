package com.questions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questions.entities.Questions;
import com.questions.services.QuestionServices;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
private QuestionServices questionServices;
	
	 public QuestionController(QuestionServices questionServices) {
		this.questionServices= questionServices;
	}
	
	
	@PostMapping
	public Questions Add(@RequestBody Questions question) {
		return questionServices.add(question);
	}
	
	@GetMapping
	public List<Questions> getAll(){
		return questionServices.getAll();
	}
	
	@GetMapping("/{id}")
	public Questions getOn(@PathVariable Long id) {
		return questionServices.getOne(id);
	}
	
	@GetMapping("/quiz/{quiz_id}")
	public List<Questions> getQuestionsofQuizId(@PathVariable Long quiz_id){
		return questionServices.getQuestionsofQuizId(quiz_id);
	}
}
