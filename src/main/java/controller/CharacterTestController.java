package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import domain.Question;
import service.ChoiceService;
import service.QuestionService;

@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class CharacterTestController {
    // 멤버 변수 선언
    private final ChoiceService choiceService;
    private final QuestionService questionService;

    @Autowired
    public CharacterTestController(ChoiceService choiceService, QuestionService questionService) {
        // 멤버 변수 생성
        this.choiceService = choiceService;
        this.questionService= questionService;
    }

    @GetMapping("/api/questions")
    public Question updateProduct() {
        Question question = questionService.getQuestions((long) 1);
        // 응답 보내기
        return question;
    }



    @GetMapping("/api/questions/{id}")
    public Question getQuestion(@PathVariable Long id) {

        // 응답 보내기

    }

}