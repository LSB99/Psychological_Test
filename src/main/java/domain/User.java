package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dto.UserRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = true)
    private String choose1;

    @Column(nullable = true)
    private String choose2;

    @Column(nullable = true)
    private String choose3;

    @Column(nullable = true)
    private String choose4;

    @Column(nullable = true)
    private String choose5;

    @Column(nullable = true)
    private String choose6;

    @Column(nullable = true)
    private String choose7;

    @Column(nullable = true)
    private String choose8;

    @Column(nullable = true)
    private String character;


    public User(Long userId, String choose1, String choose2, String choose3, String choose4, String choose5, String choose6, String choose7, String choose8, String character) {
        this.userId = userId;
        this.choose1 = choose1;
        this.choose2 = choose2;
        this.choose3 = choose3;
        this.choose4 = choose4;
        this.choose5 = choose5;
        this.choose6 = choose6;
        this.choose7 = choose7;
        this.choose8 = choose8;
        this.character = character;
    }
    public User(UserRequestDto requestDto) {
        this.userId = requestDto.getUserId();
        this.choose1 = requestDto.getChoose1();
        this.choose2 = requestDto.getChoose2();
        this.choose3 = requestDto.getChoose3();
        this.choose4 = requestDto.getChoose4();
        this.choose5 = requestDto.getChoose5();
        this.choose6 = requestDto.getChoose6();
        this.choose7 = requestDto.getChoose7();
        this.choose8 = requestDto.getChoose8();
        this.character = requestDto.getCharacter();
    }
}
