package com.da.fo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
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
	public ModelAndView dealSerach(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		System.out.println("################# param : " + param);
		Map<String, Object> searchOptions = new HashMap<>();
		List<String> dealTypCds = new ArrayList<>();
		List<String> dealSttsCds = new ArrayList<>();
		List<String> workShpCds = new ArrayList<>();
		List<String> workClsfcCds = new ArrayList<>();
		if(param.get("dealTypCds") != null) {
			dealTypCds = Arrays.asList(param.get("dealTypCds").toString().replaceAll("\\[|\\]|\"", "").split(","));
		}
		if(param.get("dealSttsCds") != null) {
			dealSttsCds = Arrays.asList(param.get("dealSttsCds").toString().replaceAll("\\[|\\]|\"", "").split(","));
		}
		if(param.get("workShpCds") != null) {
			workShpCds = Arrays.asList(param.get("workShpCds").toString().replaceAll("\\[|\\]|\"", "").split(","));
		}
		if(param.get("workClsfcCds") != null) {
			workClsfcCds = Arrays.asList(param.get("workClsfcCds").toString().replaceAll("\\[|\\]|\"", "").split(","));
		}
		searchOptions.put("mbrSprtn", param.get("mbrSprtn"));
		searchOptions.put("dealTypCds", dealTypCds);
		searchOptions.put("dealSttsCds", dealSttsCds);
		searchOptions.put("workShpCds", workShpCds);
		searchOptions.put("workClsfcCds", workClsfcCds);
		System.out.println("################# searchOptions : " + searchOptions);
		Map<String, Object> result = dealService.dealSerach(searchOptions);
		mv.addObject("result", result);
		return mv;
	}
}
