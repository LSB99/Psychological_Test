package com.sparta.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sparta.domain.Manycharacter;
import com.sparta.domain.Choice;
import com.sparta.domain.Comment;
import com.sparta.domain.Question;
import com.sparta.dto.CommentRequestDto;
import com.sparta.repository.ChoiceRepository;
import com.sparta.repository.CommentRepository;
import com.sparta.repository.ManycharacterRepository;
import com.sparta.repository.QuestionRepository;
import com.sparta.service.ChoiceService;
import com.sparta.service.CommentService;
import com.sparta.service.QuestionService;

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


    //모든 선택지에 관한 캐릭터 가져오기
    @RequestMapping("api/choices")
    public @ResponseBody List<Choice> getAllChoices() {
    	return choiceRepository.findAll();
    }

    //모든 질문에 대한 선택지 가져오기
    @GetMapping("/api/questions")
    public List<Question> getAllQuestion() {
    	return questionRepository.findAll();
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
	@PutMapping("/api/comments/{id}")
	public int updateComment(@PathVariable Integer id, @RequestBody CommentRequestDto requestDto) {
		commentService.update(id, requestDto);
		return id;
	}

	//댓글 삭제하기
	@DeleteMapping("/api/comments/{id}")
	public int deleteComment(@PathVariable Integer id) {
		commentRepository.deleteById(id);
		return id;
	}
	
	@GetMapping("/api/manycharacters")
    public List<Manycharacter> getAllCharacter() {
    	return manycharacterRepository.findAll();
    }


	@GetMapping("/api/manycharacters/{id}")
    public Manycharacter getCharacter(@PathVariable int id) {
    	return manycharacterRepository.findById(id);
    }
	
}