package com.sparta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparta.domain.Manycharacter;
import com.sparta.repository.ManycharacterRepository;

@Service
public class ManycharacterService {

	private final ManycharacterRepository manycharacterRepository;

    // 생성자: QuestionService() 가 생성될 때 호출됨
    @Autowired
    public ManycharacterService(ManycharacterRepository manycharacterRepository) {
        // 멤버 변수 생성
        this.manycharacterRepository = manycharacterRepository;
    }

    public Manycharacter getManycharacters(String character) {
    	Manycharacter manycharacter= manycharacterRepository.findByCharacter(character);
        return manycharacter;
    }

}
