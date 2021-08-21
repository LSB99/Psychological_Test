package com.sparta.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sparta.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	List<Comment> findAllByOrderByModifiedAtDesc();

	@Modifying
	@Query(value = "delete from comment where userName=:userName", nativeQuery = true)
	@Transactional
	void deleteByUserName(String userName);

	Comment findByUserName(String userName);
}