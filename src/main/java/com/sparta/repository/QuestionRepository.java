package com.sparta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparta.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	Question findById(int i);
}