package com.example.charactertest.domain;

import com.example.charactertest.requestDto.CharacterRequestDto;
import com.example.charactertest.requestDto.QuestionRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Character { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String character;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String body;


    public Character(String character, String image, String body) {
        this.character = character;
        this.image = image;
        this.body = body;
    }
    public Character(CharacterRequestDto requestDto) {
        this.character = requestDto.getCharacter();
        this.image = requestDto.getImage();
        this.body = requestDto.getBody();
    }
}