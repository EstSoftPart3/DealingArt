package com.da.fo.controller;

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


import com.da.fo.service.MemberService;
import com.da.sample.service.CommonService;

@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MemberService memberService;
	
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
	@RequestMapping("/login")
	@ResponseBody
	public int login(@RequestParam Map<String, Object> param, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String loginId = commonService.encrypt((String) param.get("loginId"));
		String loginPw = commonService.encrypt((String) param.get("loginPw"));
		param.put("loginId", loginId);
		param.put("loginPw", loginPw);
		param.put("email", loginId);
		param.put("email", loginId);
		param.put("password", loginPw);
		int chk = memberService.memberWithdrawalCheck(param);
		if(chk > 0) {
			return 2;
		}else{
			int result = memberService.login(param);
			
			if(result == 1) {
				session.setAttribute("loginId", loginId);
			}
			return result;
		}
	}

	@RequestMapping("/loginCheck")
	@ResponseBody
	public String loginCheck(HttpSession session) {
		System.out.println("############# loginSessionId : " + (String) session.getAttribute("loginId"));
		if((String) session.getAttribute("loginId") != null && (String) session.getAttribute("loginId") != "") {
			System.out.println("############# loginSessionId : " + (String) session.getAttribute("loginId"));
			return (String) session.getAttribute("loginId");
		}else {
			return null;
		}
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session) {
		if((String) session.getAttribute("loginId") != null && (String) session.getAttribute("loginId") != "") {
			session.invalidate();
			return "success";
		}else {
			return null;
		}
	}
	
}
