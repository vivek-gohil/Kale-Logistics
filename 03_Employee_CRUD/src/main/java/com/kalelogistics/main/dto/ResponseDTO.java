package com.kalelogistics.main.dto;

public class ResponseDTO {
	private String message;

	public ResponseDTO() {
		// TODO Auto-generated constructor stub
	}

	public ResponseDTO(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
