package com.kalelogistics.main.exception;

public class MemberInactiveException extends RuntimeException {
	public MemberInactiveException(String memberCode) {
		super("Member is inactive :: " + memberCode);
	}
}
