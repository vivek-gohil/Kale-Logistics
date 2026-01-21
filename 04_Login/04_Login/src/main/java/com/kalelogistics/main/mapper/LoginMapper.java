package com.kalelogistics.main.mapper;

import com.kalelogistics.main.domain.Login;
import com.kalelogistics.main.dto.LoginDTO;

public class LoginMapper {
	private LoginMapper() {

	}

	public static Login mapToLogin(LoginDTO loginDTO, Login login) {
		login.setLoginId(loginDTO.getLoginId());
		login.setPassword(loginDTO.getPassword());

		return login;
	}

	public static LoginDTO mapToLoginDTO(Login login, LoginDTO loginDTO) {
		loginDTO.setLoginId(login.getLoginId());
		loginDTO.setPassword(login.getPassword());

		return loginDTO;
	}
}
