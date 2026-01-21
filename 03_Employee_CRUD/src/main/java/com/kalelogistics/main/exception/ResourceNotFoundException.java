package com.kalelogistics.main.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super(resourceName + " not found with " + fieldName + " : " + fieldValue);
	}
}
