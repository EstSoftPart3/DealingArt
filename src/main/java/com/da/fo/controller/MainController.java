package com.da.fo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.fo.service.MainService;


@Controller
public class MainController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MainService mainService;
	
	@RequestMapping("/main")
	public String openMain() {
		return "thymeleaf/index";
	}
	
	@RequestMapping("/main/mainData")
	@ResponseBody
	public ModelAndView mainData(@RequestParam @Nullable Map<String, Object>  param) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		Map<String, Object> result = new HashMap<>();
		result = mainService.openMain(param);
		mv.addObject("mainData", result);
		
		return mv;
	}
	
	@RequestMapping("/fileUpload")
	public String openfileUpload() {
		return "fo/main/fileUpload";
	}
	
	@RequestMapping("/totalSearch_artist")
	@ResponseBody
	public ModelAndView totalSearchArtist(@RequestParam(value="searchKeyword", required = false) String searchKeyword) {
		ModelAndView mv = new ModelAndView("thymeleaf/result_artist");
		Map<String, Object> result = new HashMap<>();
		List artstList = mainService.totalSearchArtist(searchKeyword);
		Map<String, Object> totalCount = mainService.totalSearchArtistCount(searchKeyword);
		result.put("artstList", artstList);
		result.put("totalCount", totalCount);
		mv.addObject("result", result);
		mv.addObject("searchKeyword", searchKeyword.replaceAll("\\*", ""));
		return mv;
	}
	
	@RequestMapping("/totalSearch_work")
	@ResponseBody
	public ModelAndView totalSearchWork(@RequestParam(value="searchKeyword", required = false) String searchKeyword) {
		ModelAndView mv = new ModelAndView("thymeleaf/result_work");
		Map<String, Object> result = new HashMap<>();
		List workList = mainService.totalSearchWork(searchKeyword);
		Map<String, Object> totalCount = mainService.totalSearchWorkCount(searchKeyword);
		result.put("workList", workList);
		result.put("totalCount", totalCount);
		mv.addObject("result", result);
		mv.addObject("searchKeyword", searchKeyword.replaceAll("\\*", ""));
		return mv;
	}
	
	@RequestMapping("/totalSearchAutocomplete")
	@ResponseBody
	public ModelAndView totalSearchAutocomplete(@RequestParam String searchKeyword) {
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String,Object> result = mainService.totalSearchAutocomplete(searchKeyword);
		mv.addObject("result", result);
		return mv;
	}
	
}
