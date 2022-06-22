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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public void mainCheckplusSuccess(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
		out.println("<script> var result = new Object(); result.sName='"+sName+"'; result.sBirthDate='"+sBirthDate+"'; "
				+ "result.sDupInfo='"+sDupInfo+"'; result.sMobileNo='"+sMobileNo+"'; result.sCipherTime='"+sCipherTime+"'; "
				+ "opener.mainMobileAuthSuccess(result); window.close();</script>");
		out.flush();
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
		out.println("<script> opener.findPwdReturnValue(\"+sName+\"); window.close();</script>");
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
