package com.sparta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparta.domain.Character;

public interface CharacterRepository extends JpaRepository<Character, Long> {

}