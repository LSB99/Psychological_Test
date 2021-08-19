package com.sparta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparta.domain.Choice;
import com.sparta.repository.ChoiceRepository;

@Service
public class ChoiceService {
    // 멤버 변수 선언
    private final ChoiceRepository choiceRepository;


    // 생성자: ChoiceService() 가 생성될 때 호출됨
    @Autowired
    public ChoiceService(ChoiceRepository choiceRepository) {
        // 멤버 변수 생성
        this.choiceRepository = choiceRepository;
    }

    public Choice getChoices(Long id) {
    	Choice choice= choiceRepository.findAllById(id);
        return choice;
    }
}