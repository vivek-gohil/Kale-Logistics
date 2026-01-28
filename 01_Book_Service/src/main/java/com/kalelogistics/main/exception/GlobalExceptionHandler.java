package com.kalelogistics.main.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ProblemDetail> handleBookNotFoundException(BookNotFoundException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
		problemDetail.setTitle("Book Not Found");
		problemDetail.setDetail(e.getMessage());
		problemDetail.setProperty("errorCode", "BOOK_NOT_FOUND");
		problemDetail.setProperty("timestamp", Instant.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
	}

	@ExceptionHandler(BookNotIssuableException.class)
	public ResponseEntity<ProblemDetail> handleBookNotIssuableException(BookNotIssuableException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
		problemDetail.setTitle("Book Not Issuable");
		problemDetail.setDetail(e.getMessage());
		problemDetail.setProperty("errorCode", "BOOK_NOT_ISSUABLE");
		problemDetail.setProperty("timestamp", Instant.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
	}

	@ExceptionHandler(BookAlreadyIssuedException.class)
	public ResponseEntity<ProblemDetail> handleBookAlreadyIssuedException(BookAlreadyIssuedException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
		problemDetail.setTitle("Book Already Issued");
		problemDetail.setDetail(e.getMessage());
		problemDetail.setProperty("errorCode", "BOOK_ALREADY_ISSUED");
		problemDetail.setProperty("timestamp", Instant.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
	}
}
