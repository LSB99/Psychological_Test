package com.sparta.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sparta.domain.User;
import com.sparta.dto.UserRequestDto;
import com.sparta.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;

	@Transactional
	public String update(String userName, UserRequestDto requestDto) {
		User user = userRepository.findByUserName(userName);
		user.update(requestDto);
		return user.getUserName();
	}

	@Transactional
	public String updateCharacter(String userName, UserRequestDto requestDto) {
		User user = userRepository.findByUserName(userName);
		user.update(requestDto);
		return user.getUserName();
	}

}
