package com.da.fo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MegazineController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/insights")
	public String openInsights() {
		return "thymeleaf/fo/mgz/insights";
	}
	
	@RequestMapping("/media")
	public String openMedia() {
		return "thymeleaf/fo/mgz/media";
	}
	
	@RequestMapping("/exhibition")
	public String openExhibition() {
		return "thymeleaf/fo/mgz/exhibition";
	}

}
