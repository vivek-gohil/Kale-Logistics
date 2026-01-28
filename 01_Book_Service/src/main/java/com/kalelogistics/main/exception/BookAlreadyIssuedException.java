package com.kalelogistics.main.exception;

public class BookAlreadyIssuedException extends RuntimeException {
	public BookAlreadyIssuedException(String bookCode) {
		super("Book is already issued: " + bookCode);
	}
}
