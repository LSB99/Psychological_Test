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
	public int update(int id, CommentRequestDto requestDto) {
		Comment comment = commentRepository.findById(id).orElseThrow(
		() -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
		);
		comment.update(requestDto);
		return comment.getId();
	}
}
