package com.da.bo.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.bo.service.loginService;
import com.da.common.AwsS3Service;
import com.da.util.CommonService;

@Controller
public class login {
	
private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private loginService loginService;
	
	//LOGIN PAGE
	@RequestMapping("/admin/")
	public String openLogin() {
		
		return "bo/login/login";
	}
	
	
	//LOGIN DATA
	@RequestMapping("/admin/loginData")
	@ResponseBody
	public String loginData(@RequestParam Map<String, Object> param,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		//아이디 암호화
		String mbrIdEncrypt = commonService.encrypt((String) param.get("mbrId"));
		//회원 비밀번호 암호화
		String mbrPasswrdEncrypt = commonService.encrypt((String) param.get("mbrPasswrd"));
		
		param.put("mbrId", mbrIdEncrypt);
		param.put("mbrPasswrd", mbrPasswrdEncrypt);
		
		String mbrSq = loginService.memberLogin(param);
		
		if(mbrSq != null) {
			
			session.setAttribute("mbrSq", mbrSq);
			
		} 
		return mbrSq;
		
		
	}

}
