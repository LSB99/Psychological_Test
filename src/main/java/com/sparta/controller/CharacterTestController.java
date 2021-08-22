package com.sparta.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sparta.domain.Choice;
import com.sparta.domain.Comment;
import com.sparta.domain.Manycharacter;
import com.sparta.domain.Question;
import com.sparta.domain.User;
import com.sparta.dto.CommentRequestDto;
import com.sparta.dto.UserRequestDto;
import com.sparta.repository.ChoiceRepository;
import com.sparta.repository.CommentRepository;
import com.sparta.repository.ManycharacterRepository;
import com.sparta.repository.QuestionRepository;
import com.sparta.repository.UserRepository;
import com.sparta.service.ChoiceService;
import com.sparta.service.CommentService;
import com.sparta.service.QuestionService;
import com.sparta.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class CharacterTestController {


    private final ChoiceService choiceService;
    private final QuestionService questionService;
    private final QuestionRepository questionRepository;
    private final ChoiceRepository choiceRepository;
    private final CommentRepository commentRepository;
    private final CommentService commentService;
    private final ManycharacterRepository manycharacterRepository;
    private final UserRepository userRepository;
    private final UserService userService;


    String currentUserName;
    String character;

    //첫 화면
    @GetMapping("/api/home")
    public String home() {

    	return "wellcome";
    }

    //홈화면에서 닉네임 입력시 username만 들어간 user객체 생성
    @PostMapping("/api/home")
	public User createUserName(@RequestBody UserRequestDto requestDto) {
		User user = new User(requestDto);
		currentUserName=user.getUserName();

		return userRepository.save(user);
	}

    //모든 유저보기
    @GetMapping("/api/users")
    public List<User> getAllUsers() {
    	return userRepository.findAll();
    }


    //모든 선택지에 관한 캐릭터 가져오기
    @GetMapping("/api/choices")
    public List<Choice> getAllChoices() {
    	return choiceRepository.findAll();
    }

    //모든 질문에 대한 선택지 가져오기
    @GetMapping("/api/questions")
    public List<Question> getAllQuestion() {
    	return questionRepository.findAll();
    }

    //선지 선택시에 업데이트하기
    @PostMapping("/api/questions/{userName}")
   	public String updateUser(@PathVariable String userName, @RequestBody UserRequestDto requestDto) {
   		return userService.update(userName, requestDto);
   	}

    //특정 질문에 대한 선택지 가져오기
	@GetMapping("/api/questions/{id}")
    public Question getQuestion(@PathVariable int id) {
    	return questionRepository.findById(id);
    }

	//결과보기 직전
	@GetMapping("/api/finish")
	public String finish() {
	    return "결과보기";
	}

	//결과보기 클릭 후 결과 집계하여 user정보 업데이트 하기(구현 중)
	@PostMapping("/api/finish")
	public void updateResult() {
		User user= userRepository.findByUserName(currentUserName);
		int manggu = 0, jadu=0, inuyasya=0, nojingu=0, piglet=0, tungtungi=0, rupy=0, wudy=0;
		int max=0;
		String maxCharacter="맹구";

		String array[]=new String[8];
		array[0]=user.getChoose1();
		array[1]=user.getChoose2();
		array[2]=user.getChoose3();
		array[3]=user.getChoose4();
		array[4]=user.getChoose5();
		array[5]=user.getChoose6();
		array[6]=user.getChoose7();
		array[7]=user.getChoose8();

		for(int i=0; i<array.length; i++) {
			if(array[i]=="맹구")
				manggu+=1;
			else if(array[i]=="자두")
				jadu+=1;
			else if(array[i]=="이누야샤")
				inuyasya+=1;
			else if(array[i]=="노진구")
				nojingu+=1;
			else if(array[i]=="피글렛")
				piglet+=1;
			else if(array[i]=="퉁퉁이")
				tungtungi+=1;
			else if(array[i]=="루피")
				rupy+=1;
			else if(array[i]=="우디")
				wudy+=1;
		}

		if(max<manggu) {
			max=manggu;
			maxCharacter="맹구";
		}

		if(max<jadu) {
			max=jadu;
			maxCharacter="자두";
		}

		if(max<inuyasya) {
			max=inuyasya;
			maxCharacter="이누야샤";
		}


		if(max<nojingu) {
			max=nojingu;
			maxCharacter="노진구";
		}

		if(max<piglet) {
			max=piglet;
			maxCharacter="피글렛";
		}

		if(max<tungtungi) {
			max=tungtungi;
			maxCharacter="퉁퉁이";
		}

		if(max<rupy) {
			max=rupy;
			maxCharacter="루피";
		}

		if(max<wudy) {
			max=wudy;
			maxCharacter="우디";
		}

	    return;
	}

	//결과 보여주기
	 @GetMapping("/api/results/{userName}")
	 public Manycharacter getResult(@PathVariable String userName) {
	   	User user=userRepository.findByUserName(userName);
	   	character=user.getManycharacter();
		return manycharacterRepository.findByCharacter(character);
	}


	//댓글

	//댓글 쓰기 기능
	@PostMapping("/api/comments")
	public Comment createComment(@RequestBody CommentRequestDto requestDto) {
		Comment comment = new Comment(requestDto);
		return commentRepository.save(comment);
	}

	//모든 댓글 가져오기
	@GetMapping("/api/comments")
	public List<Comment> getComments() {
		return commentRepository.findAllByOrderByModifiedAtDesc();
	}

	//댓글 수정하기
	@PutMapping("/api/comments/{userName}")
	public String updateComment(@PathVariable String userName, @RequestBody CommentRequestDto requestDto) {
		commentService.update(userName, requestDto);
		return userName;
	}

	//댓글 삭제하기
	@DeleteMapping("/api/comments/{userName}")
	public String deleteComment(@PathVariable String userName) {
		commentRepository.deleteByUserName(userName);
		return userName;
	}

}