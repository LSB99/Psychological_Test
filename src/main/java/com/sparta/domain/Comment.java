package com.sparta.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sparta.dto.CommentRequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Comment extends Timestamped{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String body;


    public Comment(String userName, String body) {
        this.userName = userName;
        this.body = body;
    }
    public Comment(CommentRequestDto requestDto) {
        this.userName = requestDto.getUserName();
        this.body = requestDto.getBody();
    }

    public void update(CommentRequestDto requestDto) {
    	this.userName = requestDto.getUserName();
    	this.body = requestDto.getBody();
    	}
}