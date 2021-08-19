package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Question;
import repository.QuestionRepository;

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

    public Question getQuestions(Long id) {
    	Question question= questionRepository.findAllById(id);
        return question;
    }
}
