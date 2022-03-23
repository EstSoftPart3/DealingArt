package com.da.fo.controller;

import java.util.Map;

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
public class foMemberController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MemberService MemberService;
	
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
		
		
		MemberService.memberInsert(param);
	}
	@RequestMapping("/login")
	@ResponseBody
	public int login(@RequestParam Map<String, Object> param) {
		String loginId = commonService.encrypt((String) param.get("loginId"));
		String loginPw = commonService.encrypt((String) param.get("loginPw"));
		param.put("loginId", loginId);
		param.put("loginPw", loginPw);
		return MemberService.login(param);
	}

}
