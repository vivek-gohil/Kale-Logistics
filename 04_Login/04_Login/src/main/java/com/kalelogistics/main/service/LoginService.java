package com.kalelogistics.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kalelogistics.main.domain.Login;
import com.kalelogistics.main.dto.LoginDTO;
import com.kalelogistics.main.mapper.LoginMapper;
import com.kalelogistics.main.repository.LoginRepository;

@Component
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public LoginDTO validateUser(LoginDTO loginDTO) {
		Login login = loginRepository.validateUser(LoginMapper.mapToLogin(loginDTO, new Login()));

		return LoginMapper.mapToLoginDTO(login, new LoginDTO());
	}
}
