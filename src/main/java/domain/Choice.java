package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import dto.ChoiceRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Choice { // 생성,수정 시간을 자동으로 만들어줍니다.
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


    public Choice(String choice, String character1, String character2, String character3, String character4) {
        this.choice = choice;
        this.character1 = character1;
        this.character2 = character2;
        this.character3 = character3;
        this.character4 = character4;
    }
    public Choice(ChoiceRequestDto requestDto) {
        this.choice = requestDto.getChoice();
        this.character1 = requestDto.getCharacter1();
        this.character2 = requestDto.getCharacter2();
        this.character3 = requestDto.getCharacter3();
        this.character4 = requestDto.getCharacter4();
    }
}