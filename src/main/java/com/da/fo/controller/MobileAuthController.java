package com.da.fo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import  com.da.fo.service.ResponseException;

import com.da.fo.service.mobileAuthService;

@Controller
public class MobileAuthController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	mobileAuthService mobileAuthService;
	
	
	//Nice Id 인증
	@RequestMapping(value = "/auth/phone", method = RequestMethod.POST) 
	@ResponseBody
	public String mobileAuth(HttpServletRequest request) throws ResponseException {
		
		return mobileAuthService.initMobileAuth(request);
	}
		
	@RequestMapping("/auth/checkplus_success")
	public String checkplusSuccess() {
		return "checkplus_success";
	}
	
	@RequestMapping("/auth/checkplus_fail")
	public String checkplusFail() {
		return "checkplus_fail";
	}
	
	
	@RequestMapping(value = "/main/auth/phone", method = RequestMethod.POST) 
	@ResponseBody
	public String mainMobileAuth(HttpServletRequest request) throws ResponseException {
		return mobileAuthService.initMobileAuth(request);
	}
		
	@RequestMapping("/auth/main_checkplus_success")
	public String mainCheckplusSuccess() {
		return "main_checkplus_success"; 
	}
	
	@RequestMapping("/auth/main_checkplus_fail")
	public String mainCheckplusFail() {
		return "main_checkplus_fail";
	}
	
	@RequestMapping(value = "/findId/auth/phone", method = RequestMethod.POST) 
	@ResponseBody
	public String findIdMobileAuth(HttpServletRequest request) throws ResponseException {
		return mobileAuthService.initMobileAuth(request);
	}
		
	@RequestMapping("/auth/findId_checkplus_success")
	public String findIdCheckplusSuccess() {
		return "findId_checkplus_success"; 
	}
	
	@RequestMapping("/auth/findId_checkplus_fail")
	public String findIdCheckplusFail() {
		return "findId_checkplus_fail";
	}
	
	@RequestMapping(value = "/findPwd/auth/phone", method = RequestMethod.POST) 
	@ResponseBody
	public String findPwdMobileAuth(HttpServletRequest request) throws ResponseException {
		return mobileAuthService.initMobileAuth(request);
	}
		
	@RequestMapping("/auth/findPwd_checkplus_success")
	public String findPwdCheckplusSuccess() {
		return "findPwd_checkplus_success"; 
	}
	
	@RequestMapping("/auth/findPwd_checkplus_fail")
	public String findPwdCheckplusFail() {
		return "findPwd_checkplus_fail";
	}
}
