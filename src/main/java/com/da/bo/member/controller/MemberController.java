package com.da.bo.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		return "mAdminSystem/swordbass";
	}
	
	//회원 목록 페이지 이동
	@RequestMapping("/admin/member/memberList")
	public String openMemberList() {
		return "mAdminSystem/member/memberList";
	}
	
	//회원 목록 데이터
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
	
	//회원 상세 보기
	@RequestMapping("/admin/member/memberContent")
	public String openMemberContent() {
		return "mAdminSystem/member/memberContent";
	}
	
	@RequestMapping("/admin/member/memberContentData")
	@ResponseBody
	public ModelAndView memberContentData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = boMemberService.memberContent(param);
		
		mv.addObject("memberContentData", result);
		
		return mv;
	}
	
	//회원 등록 페이지 이동
	@RequestMapping("/admin/member/memberInput")
	public String openMemberInput() {
		return "mAdminSystem/member/memberInput";
	}
	
	//회원 아이디중복.닉네임 중복체크
	@RequestMapping("/admin/member/memberChkData")
	@ResponseBody
	public ModelAndView memberCheck(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = boMemberService.memberCheck(param);
		
		mv.addObject("memberCheck", result);
		
		return mv;
	}
	
	
	//회원 등록
	@RequestMapping("/admin/member/memberInsertData")
	@ResponseBody
	public void memberInsertData(@RequestParam Map<String, Object> param) {
		
		boMemberService.memberInsert(param);
		
	}
	
	//회원 목록 페이지 이동
	@RequestMapping("/admin/member/memberUpdate")
	public String openMemberUpdate() {
		return "mAdminSystem/member/memberUpdate";
	}
	
	//회원 등록
	@RequestMapping("/admin/member/memberUpdateData")
	@ResponseBody
	public void memberUpdateData(@RequestParam Map<String, Object> param) {
		
		boMemberService.memberUpdate(param);
		
	}
	
	
}
