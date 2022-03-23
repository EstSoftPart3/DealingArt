package com.da.fo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.fo.service.DealService;


@Controller
public class DealController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DealService dealService;
	
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
	
	@RequestMapping("/dealSearch")
	@ResponseBody
	public ModelAndView dealSerach(@RequestParam Map<String, Object> searchOptions) {
		ModelAndView mv = new ModelAndView("jsonView");
		System.out.println("################# dealSearchOption : " + searchOptions);
		Map<String, Object> result = dealService.dealSerach(searchOptions);
		mv.addObject("result", result);
		return mv;
	}
}
