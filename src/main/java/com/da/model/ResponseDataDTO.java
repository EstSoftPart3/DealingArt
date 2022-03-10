package com.da.model;

import lombok.Data;

@Data
public class ResponseDataDTO<T> {

	private String responseCode;
	private T response;
	private String message;
}
