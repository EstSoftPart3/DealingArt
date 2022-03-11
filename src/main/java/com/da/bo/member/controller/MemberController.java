package com.da.bo.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.bo.service.boMemberService;

@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private boMemberService boMemberService;

	@RequestMapping("/admin/swordbass")
	public String swordbass() {
		//logger.info("sample");
		//샘플페이지.jsp 화면 경로를 리턴한다
		return "mAdminSystem/swordbass";
	}
	
	@RequestMapping("/admin/member/memberList")
	public String openMemberList() {
		//logger.info("sample");
		//샘플페이지.jsp 화면 경로를 리턴한다
		return "mAdminSystem/member/memberList";
	}
	
	@RequestMapping("/admin/member/memberData")
	@ResponseBody
	public ModelAndView memberData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = boMemberService.memberList(param);
		
		mv.addObject("memberData", result);
		
		return mv;
	}
}
