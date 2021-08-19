package com.sparta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparta.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	List<Comment> findAllByOrderByModifiedAtDesc();
}