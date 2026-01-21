package com.kalelogistics.main.domain;

public class Login {
	private String loginId;
	private String password;

	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(String loginId, String password) {
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
