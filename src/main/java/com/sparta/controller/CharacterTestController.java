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

import com.sparta.domain.Choice;
import com.sparta.domain.Comment;
import com.sparta.domain.Question;
import com.sparta.dto.CommentRequestDto;
import com.sparta.repository.ChoiceRepository;
import com.sparta.repository.CommentRepository;
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

    @GetMapping("/api/questions")
    public List<Question> getAllQuestion() {
    	return questionRepository.findAll();
    }

    @RequestMapping("api/choices")
    public @ResponseBody List<Choice> getAllChoices() {
    	return choiceRepository.findAll();
    }


	@GetMapping("/api/questions/{id}")
    public Question getQuestion(@PathVariable int id) {
    	return questionRepository.findById(id);

    }

	@PostMapping("/api/comments")
	public Comment createComment(@RequestBody CommentRequestDto requestDto) {
		Comment comment = new Comment(requestDto);
		return commentRepository.save(comment);
	}

	@GetMapping("/api/comments")
	public List<Comment> getComments() {
		return commentRepository.findAllByOrderByModifiedAtDesc();
	}

	@PutMapping("/api/comments/{id}")
	public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
		commentService.update(id, requestDto);
		return id;
	}


	@DeleteMapping("/api/comments/{id}")
	public Long deleteComment(@PathVariable Long id) {
		commentRepository.deleteById(id);
		return id;
	}



}