package com.kalelogistics.main.exception;

public class BookNotIssuableException extends RuntimeException {
	public BookNotIssuableException(String bookCode) {
		super("Book is not issuable: " + bookCode);
	}
}
