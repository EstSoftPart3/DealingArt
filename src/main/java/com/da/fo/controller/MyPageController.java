package com.da.fo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.da.fo.service.MemberService;
import com.da.sample.service.CommonService;
import com.da.util.SendMailUtil;
import com.da.util.SendSmsUtil;

@Controller
public class MyPageController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private SendSmsUtil sendSmsUtil;
	
	@Autowired
	private SendMailUtil sendMailUtil;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/withdrawal")
	public String withdrawal() {
		return "thymeleaf/fo/myPage/secession";
	}
	
	//회원수정 페이지
	@RequestMapping("/memberEdit")
	public String memberEdit() {
		return "thymeleaf/fo/myPage/memberEdit";
	}
	
	@RequestMapping("/withdrawalSubmit")
	@ResponseBody
	public int withdrawalSubmit(@RequestParam @Nullable Map<String, Object> param) {
		System.out.println("############## param : " + param);
		param.put("email", commonService.encrypt((String) param.get("email")));
		param.put("password", commonService.encrypt((String) param.get("password")));
		int chk = memberService.memberWithdrawalCheck(param);
		if(chk > 0) {
			return 2;
		}else {
			return memberService.memberWithdrawal(param); 
		}
	}
	
	
	//회원수정 이메일인증 메일보내기 테스트 
	@RequestMapping("/myPage/memberUpdatEmailCertification")
	@ResponseBody
	public String emailCertification(@RequestParam Map<String, Object> param) {
		
		String result = "";
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		Map<String, Object> tomap = new HashMap<String, Object>();
		List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
		Map<String, Object> params = new HashMap<String, Object>();
		
		int serti = (int)((Math.random()* (99999 - 10000 + 1)) + 10000);
		
		String title = "Dealing Art 회원수정시 필요한 인증번호 입니다.";
		String content = "[인증번호] "+ serti +" 입니다. <br/> 인증번호 확인란에 기입해주십시오.";
				
		String memberEmail = (String) param.get("mbrId");
		
		tomap.put("type", "R");
		tomap.put("address", memberEmail);
		mList.add(tomap);
		
		params.put("title", title);
		params.put("body", content);
		params.put("recipients", mList);
		
		rtnMap = sendMailUtil.sendMail(params);
		if(((int) Double.parseDouble(rtnMap.get("count").toString()) < 0)){
			result = "error";
		}else {
			String sertiString = Integer.toString(serti);
			result = sertiString;
		}
		int paramStatus = -1; 
		
		return result;
	}
	
}
