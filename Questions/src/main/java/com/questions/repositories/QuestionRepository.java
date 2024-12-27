package com.questions.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.questions.entities.Questions;

public interface QuestionRepository extends CrudRepository<Questions, Long> {

	public List<Questions> findByQuizId(Long quiz_id);
	
}
