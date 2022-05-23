package com.da.fo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.da.fo.service.DealService;
import com.da.fo.service.MainService;


@Controller
public class MainController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MainService mainService;
	
	@Autowired
	private DealService dealService;
	
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
		List<Map<String, Object>> artstList = mainService.totalSearchArtist(searchKeyword);
		result.put("artstList", artstList);
		if(artstList.size() > 0) {
			result.put("totalCount", artstList.size());
		}else {
			result.put("totalCount", 0);
		}
		result.put("searchKeyword", searchKeyword);
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/totalSearch_work")
	@ResponseBody
	public ModelAndView totalSearchWork(@RequestParam(value="searchKeyword", required = false) String searchKeyword) {
		ModelAndView mv = new ModelAndView("thymeleaf/result_work");
		Map<String, Object> result = new HashMap<>();
		List<Map<String, Object>> workList = mainService.totalSearchWork(searchKeyword);
		result.put("workList", workList);
		if(workList.size() > 0) {
			result.put("totalCount", workList.size());
		}else {
			result.put("totalCount", 0);
		}
		result.put("searchKeyword", searchKeyword);
		mv.addObject("result", result);
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
	
	@RequestMapping("/totalSearch_work/searchOptions")
	public String totalSearchWorkSearchOptions(Model model, @RequestBody Map<String, Object> param) {
		Map<String,Object> result = new HashMap<>();
		List<Map<String, Object>> workList = dealService.dealSerach(param);
		result.put("workList", workList);
		if(workList.size() > 0) {
			result.put("totalCount", workList.size());
		}else{
			result.put("totalCount", 0);
		}
		result.put("searchKeyword", param.get("searchKeyword"));
		model.addAttribute("result", result);
		return "thymeleaf/result_work :: fragment-resultWork";
	}
}
