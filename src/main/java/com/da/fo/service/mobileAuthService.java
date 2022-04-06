package com.da.fo.service;

import javax.servlet.http.HttpServletRequest;

import  com.da.fo.service.ResponseException;

public interface mobileAuthService {
	
	public String initMobileAuth(HttpServletRequest request) throws ResponseException;
	

}
