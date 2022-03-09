package com.da.fo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DealController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/deal")
	public String goDeal() {
		logger.info("gogogogogogogogogogogo Deal!!!!!");
		return "fo/deal/deal";
	}
	
	@RequestMapping("/dealConfirmed")
	public String goDealConfirmed() {
		logger.info("gogogogogogogogogogogo Confrimed!!!!!");
		return "fo/deal/dealConfirmed";
	}
}
