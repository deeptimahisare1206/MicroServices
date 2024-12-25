package com.quiz.repositories;

import org.springframework.data.repository.CrudRepository;

import com.quiz.entities.Quiz;

public interface QuizRepository extends CrudRepository<Quiz, Long>{

}
