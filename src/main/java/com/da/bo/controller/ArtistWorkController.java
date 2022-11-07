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
	
	@RequestMapping("/admin/artWorkList")
	public String openArtWorkList() {
		return "bo/artWork/list";
	}
	
	
	@RequestMapping("/admin/artWorkList/artWorkListData")
	@ResponseBody
	public ModelAndView memberData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = artistWorkService.artistWorkList(param);
									
		mv.addObject("workData", result);
		
		return mv;
	}
}
