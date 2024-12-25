package com.questions.repositories;

import org.springframework.data.repository.CrudRepository;

import com.questions.entities.Questions;

public interface QuestionRepository extends CrudRepository<Questions, Long> {

}
