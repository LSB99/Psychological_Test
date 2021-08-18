package com.example.charactertest.domain;

import com.example.charactertest.requestDto.QuestionRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Question { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String choice1;

    @Column(nullable = false)
    private String choice2;

    @Column(nullable = false)
    private String choice3;


    public Question(String question, String choice1, String choice2, String choice3) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
    }
    public Question(QuestionRequestDto requestDto) {
        this.question = requestDto.getQuestion();
        this.choice1 = requestDto.getChoice1();
        this.choice2 = requestDto.getChoice2();
        this.choice3 = requestDto.getChoice3();
    }
}