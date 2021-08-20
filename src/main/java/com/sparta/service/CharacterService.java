package com.sparta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparta.domain.Character;
import com.sparta.repository.CharacterRepository;

@Service
public class CharacterService {
	
	 private final CharacterRepository characterRepository;


	    // 생성자: QuestionService() 가 생성될 때 호출됨
	    @Autowired
	    public CharacterService(CharacterRepository characterRepository) {
	        // 멤버 변수 생성
	        this.characterRepository = characterRepository;
	    }

	    public Character getQuestions(int id) {
	    	Character question= characterRepository.findById(id);
	        return question;
	    }

}
