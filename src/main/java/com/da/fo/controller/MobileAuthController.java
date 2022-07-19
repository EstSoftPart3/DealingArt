package com.da.fo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import  com.da.fo.service.ResponseException;

import com.da.fo.service.mobileAuthService;

@Controller
public class MobileAuthController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	mobileAuthService mobileAuthService;
	
	
	//Nice Id 인증
	@RequestMapping(value = "/auth/phone", method = RequestMethod.POST) 
	@ResponseBody
	public String mobileAuth(HttpServletRequest request) throws ResponseException {
		
		return mobileAuthService.initMobileAuth(request);
	}
		
	@RequestMapping("/auth/checkplus_success")
	public String checkplusSuccess() {
		return "checkplus_success";
	}
	
	@RequestMapping("/auth/checkplus_fail")
	public String checkplusFail() {
		return "checkplus_fail";
	}
	
	
	@RequestMapping(value = "/main/auth/phone", method = RequestMethod.POST) 
	@ResponseBody
	public String mainMobileAuth(HttpServletRequest request) throws ResponseException {
		return mobileAuthService.initMobileAuth(request);
	}
		
	@RequestMapping("/auth/main_checkplus_success")
	@ResponseBody
	public void mainCheckplusSuccess(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		NiceID.Check.CPClient niceCheck = new  NiceID.Check.CPClient();
		
		HttpSession session = request.getSession();
		
		String sEncodeData = requestReplace(request.getParameter("EncodeData"), "encodeData");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@ sEncodeData :"+sEncodeData);
		String sSiteCode = "BX378";				// NICE로부터 부여받은 사이트 코드
	    String sSitePassword = "HvfnaXXO0eA6";			// NICE로부터 부여받은 사이트 패스워드

	    String sCipherTime = "";			// 복호화한 시간
	    String sRequestNumber = "";			// 요청 번호
	    String sResponseNumber = "";		// 인증 고유번호
	    String sAuthType = "";				// 인증 수단
	    String sName = "";					// 성명
	    String sDupInfo = "";				// 중복가입 확인값 (DI_64 byte)
	    String sConnInfo = "";				// 연계정보 확인값 (CI_88 byte)
	    String sBirthDate = "";				// 생년월일(YYYYMMDD)
	    String sGender = "";				// 성별
	    String sNationalInfo = "";			// 내/외국인정보 (개발가이드 참조)
		String sMobileNo = "";				// 휴대폰번호
		String sMobileCo = "";				// 통신사
	    String sMessage = "";
	    String sPlainData = "";
	    
	    int iReturn = niceCheck.fnDecode(sSiteCode, sSitePassword, sEncodeData);

	    if( iReturn == 0 ){
	        sPlainData = niceCheck.getPlainData();
	        sCipherTime = niceCheck.getCipherDateTime();
	        
	        // 데이타를 추출합니다.
	        java.util.HashMap mapresult = niceCheck.fnParse(sPlainData);
	        
	        sRequestNumber  = (String)mapresult.get("REQ_SEQ");
	        sResponseNumber = (String)mapresult.get("RES_SEQ");
	        sAuthType		= (String)mapresult.get("AUTH_TYPE");
	        sName			= (String)mapresult.get("NAME");
			//sName			= (String)mapresult.get("UTF8_NAME"); //charset utf8 사용시 주석 해제 후 사용
	        sBirthDate		= (String)mapresult.get("BIRTHDATE");
	        sGender			= (String)mapresult.get("GENDER");
	        sNationalInfo  	= (String)mapresult.get("NATIONALINFO");
	        sDupInfo		= (String)mapresult.get("DI");
	        sConnInfo		= (String)mapresult.get("CI");
	        sMobileNo		= (String)mapresult.get("MOBILE_NO");
	        sMobileCo		= (String)mapresult.get("MOBILE_CO");
	        
	        String session_sRequestNumber = (String)session.getAttribute("REQ_SEQ");
	        if(!sRequestNumber.equals(session_sRequestNumber)){
	            sMessage = "세션값 불일치 오류입니다.";
	            sResponseNumber = "";
	            sAuthType = "";
	        }
	    }else if( iReturn == -1){
	        sMessage = "복호화 시스템 오류입니다.";
	    }else if( iReturn == -4){
	        sMessage = "복호화 처리 오류입니다.";
	    }else if( iReturn == -5){
	        sMessage = "복호화 해쉬 오류입니다.";
	    }else if( iReturn == -6){
	        sMessage = "복호화 데이터 오류입니다.";
	    }else if( iReturn == -9){
	        sMessage = "입력 데이터 오류입니다.";
	    }else if( iReturn == -12){
	        sMessage = "사이트 패스워드 오류입니다.";
	    }else{
	        sMessage = "알수 없는 에러 입니다. iReturn : " + iReturn;
	    }
	    
	    
	    out.println("\r\n"
	    		+ "<html lang=\"ko\" xmlns:th=\"http://www.thymeleaf.org\" xmlns:layout=\"http://www.ultraq.net.nz/thymeleaf/layout\">\r\n"
	    		+ " <head>\r\n"
	    		+ "	<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
	    		+ " </head>\r\n"
	    		+ " <body>\r\n"
	    		+ "	<form name=\"thisForm\" action=\"/joinStepProc\" target=\"join1\" method=\"post\">\r\n"
	    		+ "		<input type=\"hidden\" name=\"sName\" id=\"sName\" value='"+sName+"' th:field=\"*{sName}\">\r\n"
	    		+ "		<input type=\"hidden\" name=\"sBirthDate\" id=\"sBirthDate\" value='"+sBirthDate+"'>\r\n"
	    		+ "		<input type=\"hidden\" name=\"sDupInfo\" id=\"sDupInfo\" value='"+sDupInfo+"'>\r\n"
	    		+ "		<input type=\"hidden\" name=\"sMobileNo\" id=\"sMobileNo\" value='"+sMobileNo+"'>\r\n"
	    		+ "		<input type=\"hidden\" name=\"sCipherTime\" id=\"sCipherTime\" value='"+sCipherTime+"'>\r\n"
	    		+ "	</form>\r\n"
	    		+ "	<script>\r\n"
	    		+ "		\r\n"
	    		+ "		var isMobile = /Android|webOS|iPhone|iPad|iPod|BlackBerry/i.test(navigator.userAgent) ? true : false;\r\n"
	    		+ "		jQuery(document).ready(function($){\r\n"
	    		+ "		     if(isMobile) {\r\n"
	    		+ "		        document.thisForm.submit();\r\n"
	    		+ "		     } else {\r\n"
	    		+ "		     	 document.thisForm.submit();\r\n"
	    		+ "				window.close();\r\n"
	    		+ "		     }\r\n"
	    		+ "		});\r\n"
	    		+ "    </script>\r\n"
	    		+ " </body>\r\n"
	    		+ "</html>");
	    
	    out.flush();
		
//	    out.println("<script>var result = new Object(); result.sName='"+sName+"'; result.sBirthDate='"+sBirthDate+"'; "
//				+ "result.sDupInfo='"+sDupInfo+"'; result.sMobileNo='"+sMobileNo+"'; result.sCipherTime='"+sCipherTime+"'; "
//				+ "window.opener.mainMobileAuthSuccess(result); window.close();</script>");
//		out.flush();
	    
	    
	    //model.addAttribute("sName",sName);
	    
	    //return"redirect:/join";
	    
	}
	

	 @RequestMapping("/joinStepProc")
	 public ModelAndView doJoinStepProc(HttpServletRequest request,HttpServletResponse response, RedirectAttributes redirect, Model model) throws Exception {
		 
		 Map<String, String> map = new HashMap<String, String>();
	     
		 //가잆자 성명
		 String sName = request.getParameter("sName");
		 //가입자 생년월일
		 String sBirthDate = request.getParameter("sBirthDate");
		 //가입자 휴대폰 인증정보 키
		 String sDupInfo = request.getParameter("sDupInfo");
		 //휴대전화번호
		 String sMobileNo = request.getParameter("sMobileNo");
		 //본인인증 날짜
		 String sCipherTime = request.getParameter("sCipherTime");
		 
		 model.addAttribute("sName", sName);
		 model.addAttribute("sBirthDate", sBirthDate);
		 model.addAttribute("sDupInfo", sDupInfo);
		 model.addAttribute("sMobileNo", sMobileNo);
		 model.addAttribute("sCipherTime", sCipherTime);

	    return new ModelAndView("forward:/joinStep2");
		 
		
	 }
	
	@RequestMapping("/auth/main_checkplus_fail")
	public String mainCheckplusFail() {
		return "main_checkplus_fail";
	}
	
	@RequestMapping(value = "/findId/auth/phone", method = RequestMethod.POST) 
	@ResponseBody
	public String findIdMobileAuth(HttpServletRequest request) throws ResponseException {
		return mobileAuthService.initMobileAuth(request);
	}
		
	@RequestMapping("/auth/findId_checkplus_success")
	public void findIdCheckplusSuccess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		NiceID.Check.CPClient niceCheck = new  NiceID.Check.CPClient();
		
		HttpSession session = request.getSession();
		
		String sEncodeData = requestReplace(request.getParameter("EncodeData"), "encodeData");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@ sEncodeData :"+sEncodeData);
		String sSiteCode = "BX378";				// NICE로부터 부여받은 사이트 코드
	    String sSitePassword = "HvfnaXXO0eA6";			// NICE로부터 부여받은 사이트 패스워드

	    String sCipherTime = "";			// 복호화한 시간
	    String sRequestNumber = "";			// 요청 번호
	    String sResponseNumber = "";		// 인증 고유번호
	    String sAuthType = "";				// 인증 수단
	    String sName = "";					// 성명
	    String sDupInfo = "";				// 중복가입 확인값 (DI_64 byte)
	    String sConnInfo = "";				// 연계정보 확인값 (CI_88 byte)
	    String sBirthDate = "";				// 생년월일(YYYYMMDD)
	    String sGender = "";				// 성별
	    String sNationalInfo = "";			// 내/외국인정보 (개발가이드 참조)
		String sMobileNo = "";				// 휴대폰번호
		String sMobileCo = "";				// 통신사
	    String sMessage = "";
	    String sPlainData = "";
	    
	    int iReturn = niceCheck.fnDecode(sSiteCode, sSitePassword, sEncodeData);

	    if( iReturn == 0 ){
	        sPlainData = niceCheck.getPlainData();
	        sCipherTime = niceCheck.getCipherDateTime();
	        
	        // 데이타를 추출합니다.
	        java.util.HashMap mapresult = niceCheck.fnParse(sPlainData);
	        
	        sRequestNumber  = (String)mapresult.get("REQ_SEQ");
	        sResponseNumber = (String)mapresult.get("RES_SEQ");
	        sAuthType		= (String)mapresult.get("AUTH_TYPE");
	        sName			= (String)mapresult.get("NAME");
			//sName			= (String)mapresult.get("UTF8_NAME"); //charset utf8 사용시 주석 해제 후 사용
	        sBirthDate		= (String)mapresult.get("BIRTHDATE");
	        sGender			= (String)mapresult.get("GENDER");
	        sNationalInfo  	= (String)mapresult.get("NATIONALINFO");
	        sDupInfo		= (String)mapresult.get("DI");
	        sConnInfo		= (String)mapresult.get("CI");
	        sMobileNo		= (String)mapresult.get("MOBILE_NO");
	        sMobileCo		= (String)mapresult.get("MOBILE_CO");
	        
	        String session_sRequestNumber = (String)session.getAttribute("REQ_SEQ");
	        if(!sRequestNumber.equals(session_sRequestNumber)){
	            sMessage = "세션값 불일치 오류입니다.";
	            sResponseNumber = "";
	            sAuthType = "";
	        }
	    }else if( iReturn == -1){
	        sMessage = "복호화 시스템 오류입니다.";
	    }else if( iReturn == -4){
	        sMessage = "복호화 처리 오류입니다.";
	    }else if( iReturn == -5){
	        sMessage = "복호화 해쉬 오류입니다.";
	    }else if( iReturn == -6){
	        sMessage = "복호화 데이터 오류입니다.";
	    }else if( iReturn == -9){
	        sMessage = "입력 데이터 오류입니다.";
	    }else if( iReturn == -12){
	        sMessage = "사이트 패스워드 오류입니다.";
	    }else{
	        sMessage = "알수 없는 에러 입니다. iReturn : " + iReturn;
	    }
		out.println("<script> var diValue='"+sDupInfo+"'; window.opener.findIdReturnValue(diValue); window.close();</script>");
		out.flush();
	}
	
	@RequestMapping("/auth/findId_checkplus_fail")
	public String findIdCheckplusFail() {
		return "findId_checkplus_fail";
	}
	
	@RequestMapping(value = "/findPwd/auth/phone", method = RequestMethod.POST) 
	@ResponseBody
	public String findPwdMobileAuth(HttpServletRequest request) throws ResponseException {
		return mobileAuthService.initMobileAuth(request);
	}
		
	@RequestMapping("/auth/findPwd_checkplus_success")
	@ResponseBody
	public void findPwdCheckplusSuccess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		NiceID.Check.CPClient niceCheck = new  NiceID.Check.CPClient();
		
		HttpSession session = request.getSession();
		
		String sEncodeData = requestReplace(request.getParameter("EncodeData"), "encodeData");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@ sEncodeData :"+sEncodeData);
		String sSiteCode = "BX378";				// NICE로부터 부여받은 사이트 코드
	    String sSitePassword = "HvfnaXXO0eA6";			// NICE로부터 부여받은 사이트 패스워드

	    String sCipherTime = "";			// 복호화한 시간
	    String sRequestNumber = "";			// 요청 번호
	    String sResponseNumber = "";		// 인증 고유번호
	    String sAuthType = "";				// 인증 수단
	    String sName = "";					// 성명
	    String sDupInfo = "";				// 중복가입 확인값 (DI_64 byte)
	    String sConnInfo = "";				// 연계정보 확인값 (CI_88 byte)
	    String sBirthDate = "";				// 생년월일(YYYYMMDD)
	    String sGender = "";				// 성별
	    String sNationalInfo = "";			// 내/외국인정보 (개발가이드 참조)
		String sMobileNo = "";				// 휴대폰번호
		String sMobileCo = "";				// 통신사
	    String sMessage = "";
	    String sPlainData = "";
	    
	    int iReturn = niceCheck.fnDecode(sSiteCode, sSitePassword, sEncodeData);

	    if( iReturn == 0 ){
	        sPlainData = niceCheck.getPlainData();
	        sCipherTime = niceCheck.getCipherDateTime();
	        
	        // 데이타를 추출합니다.
	        java.util.HashMap mapresult = niceCheck.fnParse(sPlainData);
	        
	        sRequestNumber  = (String)mapresult.get("REQ_SEQ");
	        sResponseNumber = (String)mapresult.get("RES_SEQ");
	        sAuthType		= (String)mapresult.get("AUTH_TYPE");
	        sName			= (String)mapresult.get("NAME");
			//sName			= (String)mapresult.get("UTF8_NAME"); //charset utf8 사용시 주석 해제 후 사용
	        sBirthDate		= (String)mapresult.get("BIRTHDATE");
	        sGender			= (String)mapresult.get("GENDER");
	        sNationalInfo  	= (String)mapresult.get("NATIONALINFO");
	        sDupInfo		= (String)mapresult.get("DI");
	        sConnInfo		= (String)mapresult.get("CI");
	        sMobileNo		= (String)mapresult.get("MOBILE_NO");
	        sMobileCo		= (String)mapresult.get("MOBILE_CO");
	        
	        String session_sRequestNumber = (String)session.getAttribute("REQ_SEQ");
	        if(!sRequestNumber.equals(session_sRequestNumber)){
	            sMessage = "세션값 불일치 오류입니다.";
	            sResponseNumber = "";
	            sAuthType = "";
	        }
	    }else if( iReturn == -1){
	        sMessage = "복호화 시스템 오류입니다.";
	    }else if( iReturn == -4){
	        sMessage = "복호화 처리 오류입니다.";
	    }else if( iReturn == -5){
	        sMessage = "복호화 해쉬 오류입니다.";
	    }else if( iReturn == -6){
	        sMessage = "복호화 데이터 오류입니다.";
	    }else if( iReturn == -9){
	        sMessage = "입력 데이터 오류입니다.";
	    }else if( iReturn == -12){
	        sMessage = "사이트 패스워드 오류입니다.";
	    }else{
	        sMessage = "알수 없는 에러 입니다. iReturn : " + iReturn;
	    }
		out.println("<script> opener.findPwdReturnValue('"+sDupInfo+"'); window.close();</script>");
		out.flush();
	}
	
	@RequestMapping("/auth/findPwd_checkplus_fail")
	public String findPwdCheckplusFail() {
		return "findPwd_checkplus_fail";
	}
	
	public String requestReplace (String paramValue, String gubun) {

        String result = "";
        
        if (paramValue != null) {
        	
        	paramValue = paramValue.replaceAll("<", "&lt;").replaceAll(">", "&gt;");

        	paramValue = paramValue.replaceAll("\\*", "");
        	paramValue = paramValue.replaceAll("\\?", "");
        	paramValue = paramValue.replaceAll("\\[", "");
        	paramValue = paramValue.replaceAll("\\{", "");
        	paramValue = paramValue.replaceAll("\\(", "");
        	paramValue = paramValue.replaceAll("\\)", "");
        	paramValue = paramValue.replaceAll("\\^", "");
        	paramValue = paramValue.replaceAll("\\$", "");
        	paramValue = paramValue.replaceAll("'", "");
        	paramValue = paramValue.replaceAll("@", "");
        	paramValue = paramValue.replaceAll("%", "");
        	paramValue = paramValue.replaceAll(";", "");
        	paramValue = paramValue.replaceAll(":", "");
        	paramValue = paramValue.replaceAll("-", "");
        	paramValue = paramValue.replaceAll("#", "");
        	paramValue = paramValue.replaceAll("--", "");
        	paramValue = paramValue.replaceAll("-", "");
        	paramValue = paramValue.replaceAll(",", "");
        	
        	if(gubun != "encodeData"){
        		paramValue = paramValue.replaceAll("\\+", "");
        		paramValue = paramValue.replaceAll("/", "");
            paramValue = paramValue.replaceAll("=", "");
        	}
        	
        	result = paramValue;
            
        }
        return result;
  }
}
