package com.da.fo.service;

public class ResponseException extends Exception {
	
	private String message;
	
	public ResponseException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
