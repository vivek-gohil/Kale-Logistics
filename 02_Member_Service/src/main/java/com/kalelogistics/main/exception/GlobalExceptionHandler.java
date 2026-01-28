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

	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<ProblemDetail> handleMemberNotFoundException(MemberNotFoundException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
		problemDetail.setTitle("Member Not Found");
		problemDetail.setDetail(e.getMessage());
		problemDetail.setProperty("errorCode", "MEMBER_NOT_FOUND");
		problemDetail.setProperty("timestamp", Instant.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
	}

	@ExceptionHandler(MemberInactiveException.class)
	public ResponseEntity<ProblemDetail> handleMemberInactiveException(MemberInactiveException e) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
		problemDetail.setTitle("Member is inactive");
		problemDetail.setDetail(e.getMessage());
		problemDetail.setProperty("errorCode", "MEMBER_INACTIVE");
		problemDetail.setProperty("timestamp", Instant.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
	}
}
