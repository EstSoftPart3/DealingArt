package com.da.fo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/main")
	public String goMain() {
		logger.info("gogogogogogogogogogogo Main!!!!!");
		return "fo/main/main";
	}
}
