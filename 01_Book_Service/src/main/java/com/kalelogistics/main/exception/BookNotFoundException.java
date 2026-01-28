package com.kalelogistics.main.exception;

public class BookNotFoundException extends RuntimeException {
	public BookNotFoundException(String bookCode) {
		super("Book not found :: " + bookCode);
	}
}
