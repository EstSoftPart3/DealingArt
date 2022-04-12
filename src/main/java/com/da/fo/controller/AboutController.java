package com.da.fo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/customerService")
	public String customerService() {
		return "thymeleaf/fo/about/customerService";
	}
	
	@RequestMapping("/serviceIntro")
	public String serviceIntro() {
		return "thymeleaf/fo/about/serviceIntro";
	}
	
	@RequestMapping("/notice")
	public String notice() {
		return "thymeleaf/fo/about/notice";
	}
}
