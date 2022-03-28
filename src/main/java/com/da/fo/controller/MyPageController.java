package com.da.fo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/withdrawal")
	public String withdrawal() {
		return "thymeleaf/fo/myPage/secession";
	}
	
	@RequestMapping("/withdrawal2")
	public String withdrawal2() {
		return "thymeleaf/fo/myPage/secession2";
	}
}
