package com.da.bo.member.controller;

import java.util.HashMap;
import java.util.Iterator;
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
import com.da.util.CommonService;


@Controller
public class boMemberController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private boMemberService boMemberService;

	@RequestMapping("/admin/swordbass")
	public String swordbass() {
		return "bo/swordbass";
	}
	
	//회원 목록 페이지 이동
	@RequestMapping("/admin/member/memberList")
	public String openMemberList() {
		return "bo/member/memberList";
	}
	
	//탈퇴회원 목록 페이지 이동
	@RequestMapping("/admin/member/outMemberList")
	public String openOutMemberList() {
		return "bo/member/outMemberList";
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
	
	//회원 목록 검색
	@RequestMapping("/admin/member/memberSearch")
	@ResponseBody
	public ModelAndView memberSearch(@RequestParam Map<String, Object> param) {
		
		Map<String, Object> result = new HashMap<>();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		/*
		 * String searchGubun = (String) param.get("searchGubun");
		 * 
		 * if(searchGubun.equals("mbrNm")) { String searchWordEncrypt =
		 * commonService.encrypt((String) param.get("searchWord"));
		 * param.put("searchWord", searchWordEncrypt); }
		 */
				
		result = boMemberService.memberList(param);
									
		mv.addObject("memberData", result);
		
		return mv;
	}
	
	//회원 상세 보기
	@RequestMapping("/admin/member/memberContent")
	public String openMemberContent() {
		return "bo/member/memberContent";
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
		return "bo/member/memberInput";
	}
	
	//회원 아이디중복.닉네임 중복체크
	@RequestMapping("/admin/member/memberChkData")
	@ResponseBody
	public ModelAndView memberCheck(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		//이메일 암호화
		String mbrIdEncrypt = commonService.encrypt((String) param.get("mbrId"));
		param.put("mbrId", mbrIdEncrypt);
		
		result = boMemberService.memberCheck(param);
		
		mv.addObject("memberCheck", result);
		
		return mv;
	}
	
	
	//회원 등록
	@RequestMapping("/admin/member/memberInsertData")
	@ResponseBody
	public void memberInsertData(@RequestParam Map<String, Object> param) {
		
		//아이디 암호화
		String mbrIdEncrypt = commonService.encrypt((String) param.get("mbrId"));
		///회원 비밀번호 암호화
		String mbrPasswrdEncrypt = commonService.encrypt((String) param.get("mbrPasswrd"));
		//이메일 암호화
		String mbrEmailEncrypt = commonService.encrypt((String) param.get("mbrEmail"));
		//휴대전화번호 암호화
		String mbrCpNumEncrypt = commonService.encrypt((String) param.get("mbrCpNum"));
		//집주소 암호화
		String mbrHomeAddrEncrypt = commonService.encrypt((String) param.get("mbrHomeAddr"));
		
		param.put("mbrId", mbrIdEncrypt);
		param.put("mbrPasswrd", mbrPasswrdEncrypt);
		param.put("mbrEmail", mbrEmailEncrypt);
		param.put("mbrCpNum", mbrCpNumEncrypt);
		param.put("mbrHomeAddr", mbrHomeAddrEncrypt);

		
		boMemberService.memberInsert(param);
		
	}
	
	//회원 목록 페이지 이동
	@RequestMapping("/admin/member/memberUpdate")
	public String openMemberUpdate() {
		return "bo/member/memberUpdate";
	}
	
	//회원 수정
	@RequestMapping("/admin/member/memberUpdateData")
	@ResponseBody
	public void memberUpdateData(@RequestParam Map<String, Object> param) {
		
		
		//아이디 암호화
		String mbrIdEncrypt = commonService.encrypt((String) param.get("mbrId"));
		//이메일 암호화
		String mbrEmailEncrypt = commonService.encrypt((String) param.get("mbrEmail"));
		//휴대전화번호 암호화
		String mbrCpNumEncrypt = commonService.encrypt((String) param.get("mbrCpNum"));
		//집주소 암호화
		String mbrHomeAddrEncrypt = commonService.encrypt((String) param.get("mbrHomeAddr"));
				
		param.put("mbrId", mbrIdEncrypt);
		param.put("mbrEmail", mbrEmailEncrypt);
		param.put("mbrCpNum", mbrCpNumEncrypt);
		param.put("mbrHomeAddr", mbrHomeAddrEncrypt);
		
		boMemberService.memberUpdate(param);
		
	}
	//복호화
	@RequestMapping("/admin/member/memberDecrypt")
	@ResponseBody
	public String memberDecrypt(@RequestParam Map<String, Object> param) {
		
		String Decryptstr = (String) param.get("Decryptstr");
		
		String deStr = commonService.decrypt(Decryptstr);
		
		return deStr;
	}
	
}
