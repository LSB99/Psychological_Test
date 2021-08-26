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


    String currentUserName="user2";
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
    @PostMapping("/api/questions")
   	public String updateUser(@RequestBody UserRequestDto requestDto) {
   		return userService.update(currentUserName, requestDto);
   	}

    //특정 질문에 대한 선택지 가져오기
	@GetMapping("/api/questions/{id}")
    public Question getQuestion(@PathVariable int id) {
    	return questionRepository.findById(id);
    }


	//결과보기 직전
	@GetMapping("/api/finish")
	public String updateResult() {
		User user= userRepository.findByUserName(currentUserName);
		String choice1 =user.getChoose1();
   		String choice2 =user.getChoose2();
   		String choice3 =user.getChoose3();
   		String choice4 =user.getChoose4();
   		String choice5 =user.getChoose5();
   		String choice6 =user.getChoose6();
   		String choice7 =user.getChoose7();
   		String choice8 =user.getChoose8();


		int manggu = 0, jadu=0, inuyasya=0, nojingu=0, piglet=0, tungtungi=0, rupy=0, wudy=0;
		int max=0;
		String maxCharacter="";


		String array[]=new String[8];
		array[0]=(choiceRepository.findByChoice(choice1)).getCharacter1();
		array[1]=(choiceRepository.findByChoice(choice2)).getCharacter1();
		array[2]=(choiceRepository.findByChoice(choice3)).getCharacter1();
		array[3]=(choiceRepository.findByChoice(choice4)).getCharacter1();
		array[4]=(choiceRepository.findByChoice(choice5)).getCharacter1();
		array[5]=(choiceRepository.findByChoice(choice6)).getCharacter1();
		array[6]=(choiceRepository.findByChoice(choice7)).getCharacter1();
		array[7]=(choiceRepository.findByChoice(choice8)).getCharacter1();

		for(int i=0; i<array.length; i++) {
			if(array[i].equals("맹구"))
				manggu+=1;
			else if(array[i].equals("자두"))
				jadu+=1;
			else if(array[i].equals("이누야샤"))
				inuyasya+=1;
			else if(array[i].equals("노진구"))
				nojingu+=1;
			else if(array[i].equals("피글렛"))
				piglet+=1;
			else if(array[i].equals("퉁퉁이"))
				tungtungi+=1;
			else if(array[i].equals("루피"))
				rupy+=1;
			else if(array[i].equals("우디"))
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
		UserRequestDto requestDto=new UserRequestDto();
		requestDto.setChoose1(choice1);
		requestDto.setChoose2(choice2);
		requestDto.setChoose3(choice3);
		requestDto.setChoose4(choice4);
		requestDto.setChoose5(choice5);
		requestDto.setChoose6(choice6);
		requestDto.setChoose7(choice7);
		requestDto.setChoose8(choice8);
		requestDto.setManycharacter(maxCharacter);
		requestDto.setUserName(currentUserName);

		userService.update(currentUserName, requestDto);
		return maxCharacter;
	}

	//결과 보여주기
	 @GetMapping("/api/results")
	 public Manycharacter getResult() {
	   	User user=userRepository.findByUserName(currentUserName);
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