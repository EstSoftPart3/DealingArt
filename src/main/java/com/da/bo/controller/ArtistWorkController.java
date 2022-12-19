package com.da.bo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.bo.service.ArtistWorkService;
import com.da.util.CommonService;

@Controller
public class ArtistWorkController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private ArtistWorkService artistWorkService;
	
	//작가 리스트 
	@RequestMapping("/admin/artWorkList")
	public String openArtWorkList() {
		return "bo/artWork/list";
	}
	
	//작가 리스트 DATA
	@RequestMapping("/admin/artWorkList/artWorkListData")
	@ResponseBody
	public ModelAndView artWorkListData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = artistWorkService.artistWorkList(param);
									
		mv.addObject("workData", result);
		
		return mv;
	}
	
	
	//작가 정보 내용
	@RequestMapping("/admin/artDetailInfo")
	public String openArtDetailInfo() {
		return "bo/artWork/detail";
	}
	
	//작가정보리스트
	@RequestMapping("/admin/artWorkList/artWorkContentData")
	@ResponseBody
	public ModelAndView artWorkContentData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = artistWorkService.artistWorkDetail(param);
									
		mv.addObject("artist", result);
		
		return mv;
	}
	
	
	@RequestMapping("/admin/artWorkList/artWorkData")
	@ResponseBody
	public ModelAndView artWorkData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = artistWorkService.workList(param);
									
		mv.addObject("work", result);
		
		return mv;
	}
}
