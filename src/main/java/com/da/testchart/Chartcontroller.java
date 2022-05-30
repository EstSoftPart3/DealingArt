package com.da.testchart;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Chartcontroller {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/sampleChart")
	public String openBoardList(HttpServletRequest req) {

		return "sample/sample";
	}
	
}
