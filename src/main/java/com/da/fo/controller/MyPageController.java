package com.da.fo.controller;

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

@Controller
public class MyPageController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CommonService commonService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/withdrawal")
	public String withdrawal() {
		return "thymeleaf/fo/myPage/secession";
	}
	
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
	
	
	
	
}
