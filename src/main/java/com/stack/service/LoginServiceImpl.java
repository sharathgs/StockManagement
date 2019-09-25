package com.stack.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stack.dto.LoginDetailsDto;
import com.stack.dto.LoginDto;
import com.stack.entity.User;
import com.stack.respository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository userRepository;

	@Override
	public LoginDetailsDto login(LoginDto loginDto) {
		
		LoginDetailsDto loginResponseDto = new LoginDetailsDto();
		Optional<User> user = userRepository.findByEmailAndPassword(loginDto.getEmailId(), loginDto.getPassword());

		if (user.isPresent()) {
			log.info("user fetched");
			loginResponseDto.setUserId(user.get().getUserId());
			loginResponseDto.setMessage("LoggedIn Successfully..");
			loginResponseDto.setStatus("SUCCESS");
			loginResponseDto.setStatusCode(200);
			return loginResponseDto;
		} else {
			loginResponseDto.setMessage("Login Failed...");
			loginResponseDto.setStatus("FAILURE");
			loginResponseDto.setStatusCode(200);
			return loginResponseDto;
		}

	}

}
