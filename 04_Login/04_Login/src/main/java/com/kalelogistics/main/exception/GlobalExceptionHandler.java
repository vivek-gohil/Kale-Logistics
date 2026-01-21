package com.kalelogistics.main.exception;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<ObjectError> errorList = ex.getAllErrors();
		Map<String, String> validationErrors = new HashMap<String, String>();

		for (ObjectError objectError : errorList) {
			FieldError error = (FieldError) objectError;
			String field = error.getField();
			String message = error.getDefaultMessage();
			validationErrors.put(field, message);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ProblemDetail> handleResourceNotFoundException(
			ResourceNotFoundException resourceNotFoundException, WebRequest request) {
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
		problemDetail.setTitle("Resource Not Found");
		problemDetail.setInstance(URI.create("http://localhost:8080/loginapi/login"));
		problemDetail.setDetail(resourceNotFoundException.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);

	}

}
