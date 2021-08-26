package com.sparta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparta.domain.Choice;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {
	Choice findAllById(Long id);
	Choice findByChoice(String choice);
}
