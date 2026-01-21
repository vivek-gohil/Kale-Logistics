package com.kalelogistics.main.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {
	@NotBlank(message = "Login id cannot be blank")
	private String loginId;
	@NotBlank(message = "Password cannot be blank")
	private String password;

	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}

	public LoginDTO(String loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", password=" + password + "]";
	}
}
