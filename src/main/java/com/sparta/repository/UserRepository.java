package com.sparta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparta.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String currentUserName);

}
