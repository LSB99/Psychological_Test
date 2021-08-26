package com.sparta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparta.domain.Manycharacter;

public interface ManycharacterRepository extends JpaRepository<Manycharacter, Long> {

	Manycharacter findByCharacter(String question);

}