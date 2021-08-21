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

	//모든 캐릭터 가져오기
	@GetMapping("/api/manycharacters")
    public List<Manycharacter> getAllCharacter() {
    	return manycharacterRepository.findAll();
    }


	//특정 캐릭터 가져오기
	@GetMapping("/api/manycharacters/{character}")
    public Manycharacter getCharacter(@PathVariable String character) {
    	return manycharacterRepository.findByCharacter(character);
    }

}