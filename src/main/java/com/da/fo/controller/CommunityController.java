package com.da.fo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.fo.service.CommunityService;

@Controller
public class CommunityController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CommunityService communityService;
	
	// 커뮤니티 홈 페이지
	@RequestMapping("/community/main")
	public String communityHome() {
		return "thymeleaf/fo/community/community_home";
	}
	
	// 커뮤니티 홈 목록 조회 (아직 테스트 중)
	@RequestMapping("/community/communityHomeList")
	@ResponseBody
	public ModelAndView communityHomeList() {
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> result = communityService.communityHomeList();
		mv.addObject("result", result);
		return mv;
	}
	
}
