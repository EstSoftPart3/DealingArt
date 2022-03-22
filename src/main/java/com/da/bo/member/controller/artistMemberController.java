package com.da.bo.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class artistMemberController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/admin/member/artistMemberInput")
	public String swordbass() {
		return "mAdminSystem/member/artistMemberInput";
	}

}
