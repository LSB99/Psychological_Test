package com.sparta.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sparta.domain.Comment;
import com.sparta.dto.CommentRequestDto;
import com.sparta.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {
	private final CommentRepository commentRepository;
	@Transactional
	public String update(String userName, CommentRequestDto requestDto) {
		Comment comment = commentRepository.findByUserName(userName);
		comment.update(requestDto);
		return comment.getUserName();
	}
}
