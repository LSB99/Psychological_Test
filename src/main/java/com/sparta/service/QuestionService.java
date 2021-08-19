package com.sparta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparta.domain.Question;
import com.sparta.repository.QuestionRepository;

@Service
public class QuestionService {
    // 멤버 변수 선언
    private final QuestionRepository questionRepository;


    // 생성자: QuestionService() 가 생성될 때 호출됨
    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        // 멤버 변수 생성
        this.questionRepository = questionRepository;
    }

    public Question getQuestions(int id) {
    	Question question= questionRepository.findById(id);
        return question;
    }
}
