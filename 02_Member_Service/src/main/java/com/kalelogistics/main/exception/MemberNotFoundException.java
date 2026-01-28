package com.kalelogistics.main.exception;

public class MemberNotFoundException extends RuntimeException {
	public MemberNotFoundException(String memberCode) {
		super("Member not found: " + memberCode);
	}
}
