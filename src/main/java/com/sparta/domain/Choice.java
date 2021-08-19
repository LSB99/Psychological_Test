package com.sparta.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Choice {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String choice;

    @Column(nullable = true)
    private String character1;

    @Column(nullable = true)
    private String character2;

    @Column(nullable = true)
    private String character3;

    @Column(nullable = true)
    private String character4;
}