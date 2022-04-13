package com.da.fo.controller;

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

import com.da.fo.service.MemberService;
import com.da.sample.service.CommonService;

@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MemberService memberService;
	
	//회원가입
	@RequestMapping("/main/memberInsertData")
	@ResponseBody
	public void memberInsertData(@RequestParam Map<String, Object> param) {
		
		//회원 아이디.이메일
		String mbrIdEncrypt = commonService.encrypt((String) param.get("mbrId"));
		//회원 이메일
		String mbrEmailEncrypt = commonService.encrypt((String) param.get("mbrId"));
		//회원 비밀번호 암호화
		String mbrPasswrdEncrypt = commonService.encrypt((String) param.get("mbrPasswrd"));
		//회원 이름
		String mbrNm = (String) param.get("mbrNm");
		//휴대전화번호 암호화
		String mbrCpNumEncrypt = commonService.encrypt((String) param.get("mbrCpNum"));
		
		param.put("mbrId", mbrIdEncrypt);
		param.put("mbrEmail", mbrEmailEncrypt);
		param.put("mbrPasswrd", mbrPasswrdEncrypt);
		param.put("mbrNm", mbrNm);
		param.put("mbrCpNum", mbrCpNumEncrypt);
		param.put("useYn", "Y"); 
		
		
		memberService.memberInsert(param);
	}
	
	
	//회원수정
	@RequestMapping("/myPage/memberUpdateData")
	@ResponseBody
	public void memberUpdateData(@RequestParam Map<String, Object> param) {
		
		//회원 아이디.이메일
		String mbrIdEncrypt = commonService.encrypt((String) param.get("mbrId"));
		//회원 이메일
		String mbrEmailEncrypt = commonService.encrypt((String) param.get("mbrId"));
		//회원 비밀번호 암호화
		String mbrPasswrdEncrypt = commonService.encrypt((String) param.get("mbrPasswrd"));
		//회원 이름
		String mbrNm = (String) param.get("mbrNm");
		//휴대전화번호 암호화
		String mbrCpNumEncrypt = commonService.encrypt((String) param.get("mbrCpNum"));
		
		//회원 순번
		String mbrSq = (String) param.get("mbrSq");
		//휴대폰 인증 여부
		String mbrCpCertYn = (String) param.get("mbrCpCertYn");
		//휴대폰 인증 일자
		String mbrCpCertDate = (String) param.get("mbrCpCertDate");
		
		param.put("mbrSq", mbrSq);
		param.put("mbrId", mbrIdEncrypt);
		param.put("mbrEmail", mbrEmailEncrypt);
		param.put("mbrPasswrd", mbrPasswrdEncrypt);
		param.put("mbrNm", mbrNm);
		param.put("mbrCpNum", mbrCpNumEncrypt);
		param.put("useYn", "Y"); 
		param.put("mbrCpCertYn", mbrCpCertYn);
		param.put("mbrCpCertDate", mbrCpCertDate);
		
		memberService.memberUpdate(param);
	}
		
	//회원상세
	@RequestMapping("/myPage/memberContentData")
	@ResponseBody
	public ModelAndView memberContentData(@RequestParam Map<String, Object> param,HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = memberService.memberContent(param);
		
//		HttpSession session = request.getSession();
//	    String sessionMbrSq = (String) session.getAttribute("mbrSq");
//	    session.setAttribute("ssVar", sessionMbrSq);
	    
		mv.addObject("memberContentData", result);
		
		return mv;
	}
	
	
	@RequestMapping("/login")
	@ResponseBody
	public ModelAndView login(@RequestParam Map<String, Object> param, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("jsonView");
		String loginId = commonService.encrypt((String) param.get("loginId"));
		String loginPw = commonService.encrypt((String) param.get("loginPw"));
		param.put("loginId", loginId);
		param.put("loginPw", loginPw);
		param.put("email", loginId);
		param.put("email", loginId);
		param.put("password", loginPw);
		//탈퇴된 회원인지 체크
		int chk = memberService.memberWithdrawalCheck(param);
		if(chk > 0) { //탈퇴된 회원이면 2를 반환
			mv.addObject("login", "2");
			mv.addObject("sMbrSqVal", "");
			return mv;
		}else{
			Map<String, Object> result = memberService.login(param);
			
			if(result != null) {
				String mbrSq = result.get("mbrSq").toString();
				String authSq = result.get("authSq").toString();
				session.setAttribute("mbrSq", mbrSq);
				session.setAttribute("authSq", authSq);
				mv.addObject("login", "1");
				mv.addObject("sMbrSqVal", mbrSq);
				mv.addObject("sAuthSqVal", authSq);
				return mv;
			}else{
				mv.addObject("login", "0");
				mv.addObject("sMbrSqVal", null);
				mv.addObject("sAuthSqVal", null);
				return mv;
			}
			
		}
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session) {
		if(session.getAttribute("mbrSq") != null && session.getAttribute("mbrSq") != "") {
			session.invalidate();
			return "success";
		}else {
			return null;
		}
	}
	
	//Session GET
	@RequestMapping(value = "/loginSession")
	public ModelAndView loginSession(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("jsonView");
		if(session.getAttribute("mbrSq") != null && session.getAttribute("mbrSq") != "") {        
		    String mbrSq = (String) session.getAttribute("mbrSq");
		    String authSq = (String) session.getAttribute("authSq");
		    session.setAttribute("sMbrSqVal", mbrSq);
		    session.setAttribute("authSq", authSq);
		    mv.addObject("sMbrSqVal", mbrSq);
		    mv.addObject("sAuthSqVal", authSq);
		}else{
			mv.addObject("sMbrSqVal", null);
			mv.addObject("sAuthSqVal", null);
		}
		
		return mv;
	}

	//회원 아이디중복.닉네임 중복체크
	@RequestMapping("/myPage/memberIdChkData")
	@ResponseBody
	public ModelAndView memberIdCheck(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		//이메일 암호화
		String mbrIdEncrypt = commonService.encrypt((String) param.get("mbrId"));
		param.put("mbrId", mbrIdEncrypt);
		
		result = memberService.memberIdCheck(param);
		
		mv.addObject("memberCheck", result);
		
		return mv;
	}
	
	
	//작가기본정보 입력
	@RequestMapping("/myPage/authorInfoBaseSaveData")
	@ResponseBody
	public int authorInfoBaseSaveData(@RequestParam Map<String, Object> param) {
		
		int saveState = -1;
		
		saveState = memberService.authorInfoBaseSave(param);
		
		return saveState;
	}
	
	//작가기본정보 VIEW
	@RequestMapping("/myPage/authorInfoBaseViewData")
	@ResponseBody
	public ModelAndView authorBaseInfoView(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = memberService.authorBaseInfoView(param);
		
		mv.addObject("authorBase", result);
		
		return mv;
	}
	
	//작가학력정보 입력
	@RequestMapping("/myPage/authorEduInfoSaveData")
	@ResponseBody
	public int authoreduInfoSaveData(@RequestParam Map<String, Object> param) {
		
		int saveState = -1;
		
		//param.put("mbrSq", mbrSq);
//		//회원 순번
//		String mbrSq = (String) param.get("mbrSq");
//		//작가 순번
//		String artstSq = (String) param.get("artstSq");
//		//학력 명
//		String eductnNm = (String) param.get("eductnNm");
//				
//			
//		param.put("mbrSq", mbrSq);
//		param.put("artstSq", artstSq);
//		param.put("eductnNm", eductnNm);
		
		

		
		
				
		
		saveState = memberService.authorEduInfoSaveData(param);
		
		return saveState;
	}
	
}
