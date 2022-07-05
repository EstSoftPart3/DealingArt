package com.da.fo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.da.fo.service.MemberService;
import com.da.util.CommonService;
import com.da.vo.AutoLoginVo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.da.util.sendEmail;
import com.da.util.SendSmsUtil;

import com.da.mapper.MemberMapper;

@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private sendEmail sendEmail;
	
	@Autowired
	private SendSmsUtil sendSmsUtil;
	
	@Autowired
	MemberMapper memberMapper;
	
	//회원가입
	@RequestMapping("/main/memberInsertData")
	@ResponseBody
	public int memberInsertData(@RequestParam Map<String, Object> param) {
		
		//회원 아이디.이메일
		String mbrIdEncrypt = commonService.encrypt((String) param.get("mbrId"));
		//회원 이메일
		String mbrEmailEncrypt = commonService.encrypt((String) param.get("mbrId"));
		//회원 비밀번호 암호화
		String mbrPasswrdEncrypt = commonService.encrypt((String) param.get("mbrPasswrd"));
		//회원 이름
		String mbrNm = (String) param.get("mbrNm");
		//회원 활동명
		String mbrNcknm = (String) param.get("mbrNcknm");
		//휴대전화번호 암호화
		String mbrCpNumEncrypt = commonService.encrypt((String) param.get("mbrCpNum"));
		
		//이벤트, 프로모션 이메일 수신
		String mbrEmlAlarm = (String) param.get("mbrEmlAlarm");
		//이멘트 프로모션 SMS 수신
		String mbrCpAlarm = (String) param.get("mbrCpAlarm");
		
		param.put("mbrId", mbrIdEncrypt);
		param.put("mbrEmail", mbrEmailEncrypt);
		param.put("mbrPasswrd", mbrPasswrdEncrypt);
		param.put("mbrNm", mbrNm);
		param.put("mbrNcknm", mbrNcknm);
		param.put("mbrCpNum", mbrCpNumEncrypt);
		param.put("mbrCpCertDi", param.get("mbrCpCertDi").toString());
		//param.put("mbrDelivryCpNum", mbrCpNumEncrypt);
		param.put("useYn", "Y"); 
		param.put("gubun", "MEMINPUT");
		
		param.put("mbrEmlAlarm", mbrEmlAlarm);
		param.put("mbrCpAlarm", mbrCpAlarm);
		
		
		
		int insertState = -1;
		
		insertState = memberService.memberInsert(param);
		
		if(insertState == 1) {
		
		    //회원가입 환영 이메일
			Map<String, Object> eParam = new HashMap<>();
			
			//회원아이디
			eParam.put("mbrId", mbrIdEncrypt);
			//회웍입력 구분 코드
			eParam.put("gubun", "EMI");
			
			//이메일 Function Call
			sendEmail.emailSendUtil(eParam);
		
		}
		
		 return insertState;
	}
	
	
	//회원수정
	@RequestMapping("/myPage/memberUpdateData")
	@ResponseBody
	public void memberUpdateData(@RequestParam Map<String, Object> param) {
		
		//회원 아이디.이메일
		String mbrIdEncrypt = commonService.encrypt(param.get("mbrId").toString());
		//회원 이메일
		String mbrEmailEncrypt = commonService.encrypt(param.get("mbrId").toString());
		//회원 비밀번호 암호화
		String mbrPasswrdEncrypt = commonService.encrypt(param.get("mbrPasswrd").toString());
		//회원 이름
		String mbrNm = param.get("mbrNm").toString();
		//휴대전화번호 암호화
		String mbrCpNumEncrypt = commonService.encrypt(param.get("mbrCpNum").toString());
		//회원 순번
		String mbrSq = param.get("mbrSq").toString();
		//회원 주소
		//String mbrHomeAddr = commonService.encrypt(param.get("mbrHomeAddr"));
		String mbrDelivryAddr = param.get("mbrDelivryAddr").toString();
		//닉네임
		String mbrNcknm = param.get("mbrNcknm").toString();
		//휴대폰 인증 DI
		String mbrCpCertDi = param.get("mbrCpCertDi").toString();
		
		param.put("mbrSq", mbrSq);
		param.put("mbrId", mbrIdEncrypt);
		param.put("mbrEmail", mbrEmailEncrypt);
		param.put("mbrPasswrd", mbrPasswrdEncrypt);
		param.put("mbrNm", mbrNm);
		param.put("mbrCpNum", mbrCpNumEncrypt);
		param.put("useYn", "Y");
		param.put("mbrDelivryAddr", mbrDelivryAddr);
		param.put("mbrNcknm", mbrNcknm);
		param.put("mbrCpCertDi", mbrCpCertDi);
		
		memberService.memberUpdate(param);
	}
	
	//회원 알림설정
	@RequestMapping("/myPage/memberAlarmData")
	@ResponseBody
	public void memberAlarmData(@RequestParam Map<String, Object> param) {
		//회원 아이디.이메일
		String mbrIdEncrypt = commonService.encrypt((String) param.get("mbrId"));
		
		//휴대폰 인증 여부
		String mbrCpCertYn = (String) param.get("mbrCpCertYn");
		//휴대폰 인증 일자
		String mbrCpCertDate = (String) param.get("mbrCpCertDate");
		
		param.put("mbrId", mbrIdEncrypt);
				
		if(!commonService.isEmpty(mbrCpCertYn)) {
			param.put("mbrCpCertYn", mbrCpCertYn);
		}
		
		if(!commonService.isEmpty(mbrCpCertDate)) {
			param.put("mbrCpCertDate", mbrCpCertDate);
		}
		
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
	public ModelAndView login(@RequestParam Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("jsonView");
		String loginId = commonService.encrypt((String) param.get("loginId"));
		String loginPw = commonService.encrypt((String) param.get("loginPw"));
		String autoLoginYn = (String) param.getOrDefault("autoLoginYn", "N");
		param.put("loginId", loginId);
		param.put("loginPw", loginPw);
		param.put("email", loginId);
		param.put("password", loginPw);
		//탈퇴된 회원인지 체크
		int chk = memberService.memberWithdrawalCheck(param);
		if(chk > 0) { //탈퇴된 회원이면 2를 반환
			mv.addObject("login", "2");
			mv.addObject("sMbrSqVal", null);
			return mv;
		}else{
			Map<String, Object> result = memberService.login(param);
			
			if(result.get("error").toString().equals("none")) { //에러 코드가 없으면
				String mbrSq = result.get("mbrSq").toString();
				String authSq = result.get("authSq").toString();
				if(autoLoginYn.equals("Y")){
					
					long second = 60*60*24*7;
					Cookie cookie = new Cookie("AutoLoginCookie", session.getId());
					cookie.setPath("/");
					cookie.setMaxAge((int)second);
					response.addCookie(cookie);
					long millis = System.currentTimeMillis() + (second*1000);
					Date autoLoginDate = new Date(millis);
					System.out.println("@@@@@@@@@@@@@@@ autoLoginDate : " + autoLoginDate);
					AutoLoginVo autoLoginVo = new AutoLoginVo();
					autoLoginVo.setAutoLoginDate(autoLoginDate);
					autoLoginVo.setAutoLoginSsnId(session.getId());
					autoLoginVo.setAutoLoginYn("Y");
					autoLoginVo.setMbrSq(mbrSq);
					
					memberService.autoLogin(autoLoginVo);
				}
				if(authSq.equals("2")) {
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@authSQ : " + authSq);
					Map<String, Object> artstInfo = memberService.getArtistInfo(mbrSq);
					session.setAttribute("artstSq", artstInfo.get("artstSq").toString());
					session.setAttribute("artstActvtyNm", artstInfo.get("artstActvtyNm").toString());
					session.setAttribute("artstEnglsNm", artstInfo.get("artstEnglsNm").toString());
					session.setAttribute("artstBirthYear", artstInfo.get("artstBirthYear").toString());
					mv.addObject("artstSq", artstInfo.get("artstSq").toString());
					mv.addObject("artstActvtyNm", artstInfo.get("artstActvtyNm").toString());
					mv.addObject("artstEnglsNm", artstInfo.get("artstEnglsNm").toString());
					mv.addObject("artstBirthYear", artstInfo.get("artstBirthYear").toString());
				}
				session.setAttribute("mbrSq", mbrSq);
				session.setAttribute("authSq", authSq);
				mv.addObject("login", 1);
				mv.addObject("sMbrSqVal", mbrSq);
				mv.addObject("sAuthSqVal", authSq);
				return mv;
				
			}else{ //에러코드가 있으면
				mv.addObject("login", result.get("error").toString());
				mv.addObject("sMbrSqVal", null);
				mv.addObject("sAuthSqVal", null);
				return mv;
			}
			
		}
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		if(session.getAttribute("mbrSq") != null && session.getAttribute("mbrSq") != "") {
			Cookie cookie = WebUtils.getCookie(request, "AutoLoginCookie");
			if(cookie != null) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				AutoLoginVo autoLoginVo = new AutoLoginVo();
				autoLoginVo.setAutoLoginDate(new Date());
				autoLoginVo.setAutoLoginYn("N");
				autoLoginVo.setAutoLoginSsnId("NONE");
				autoLoginVo.setMbrSq((String) session.getAttribute("mbrSq"));
				memberService.autoLogin(autoLoginVo);
			}
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
		Cookie cookie = WebUtils.getCookie(request, "AutoLoginCookie");
		if(cookie != null) {
			AutoLoginVo autoLoginVo = memberService.getSessionId(cookie.getValue());
			session.setAttribute("mbrSq", autoLoginVo.getMbrSq());
		    session.setAttribute("authSq", autoLoginVo.getAuthSq());
		    mv.addObject("sMbrSqVal", autoLoginVo.getMbrSq().toString());
		    mv.addObject("sAuthSqVal", autoLoginVo.getAuthSq().toString());
			if(autoLoginVo.getAuthSq().equals("2")) {
				Map<String, Object> artstInfo = memberService.getArtistInfo(autoLoginVo.getMbrSq());
		    	mv.addObject("artstSq", artstInfo.get("artstSq").toString());
		    	mv.addObject("artstActvtyNm", artstInfo.get("artstActvtyNm").toString());
		    	mv.addObject("artstEnglsNm", artstInfo.get("artstEnglsNm").toString());
		    	mv.addObject("artstBirthYear", artstInfo.get("artstBirthYear").toString());
		    }
		}
		if(cookie == null && session.getAttribute("mbrSq") != null && session.getAttribute("mbrSq") != "") {        
		    String mbrSq = (String) session.getAttribute("mbrSq");
		    String authSq = (String) session.getAttribute("authSq");
		    if(session.getAttribute("artstSq") != null && session.getAttribute("artstSq") != "") {
		    	mv.addObject("artstSq", session.getAttribute("artstSq").toString());
		    	mv.addObject("artstActvtyNm", session.getAttribute("artstActvtyNm").toString());
		    	mv.addObject("artstEnglsNm", session.getAttribute("artstEnglsNm").toString());
		    	mv.addObject("artstBirthYear", session.getAttribute("artstBirthYear").toString());
		    }
		    session.setAttribute("sMbrSqVal", mbrSq);
		    session.setAttribute("authSq", authSq);
		    mv.addObject("sMbrSqVal", mbrSq);
		    mv.addObject("sAuthSqVal", authSq);
		}
		if(cookie == null && session.getAttribute("mbrSq") == null){
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
		
		String useYn = param.get("useYn").toString();
		
		if(saveState == 1 && useYn.equals("Y")) {
			
			Map<String, Object> result = new HashMap<>();
			
			//검색조건 : mbrSq, mbrId
			//회원정보 가져오기
			List<Map<String, Object>> memberContent = memberMapper.memberContent(param);
			
			String mbrCpNum = commonService.decrypt((String) memberContent.get(0).get("mbrCpNum")).replace("-", "");
			String mbrId = commonService.decrypt((String) memberContent.get(0).get("mbrId"));
			String mbrNm = (String) memberContent.get(0).get("mbrNm");
			
			//등록일시	
			//String regDt = (String) param.get("regDt");
			//낙찰일시
			//String sBidDt = (String) param.get("sBidDt");
			//작품명
			//String workNm = (String) param.get("workNm");
			//최종낙찰가
			//String bidPrc = (String) param.get("bidPrc");
			//만료일시
			//String dealEndngDt = (String) param.get("dealEndngDt");
			//응찰일시
			//String bidDt = (String) param.get("bidDt");
			
			//SMS보내기
			Map<String, Object> sendParams = new HashMap<String, Object>();
									
			sendParams.put("mbrCpNum", mbrCpNum);
			sendParams.put("mbrId", mbrId);
			sendParams.put("sndConCd", "SAA");
			
			sendSmsUtil.sendSmsProc(sendParams);
			
			
		}
		
		String mbrSq = param.get("mbrSq").toString();
		
		//회원정보 검색
		
		
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
	public int authoreduInfoSaveData(HttpServletRequest request, @RequestBody List<Map<String, Object>> list) throws Exception {
		
		int saveState = -1;
		
		Map <String, Object> param =  new HashMap<String, Object>();

		for(Map<String, Object> tList : list) {
			
			String eductnSq = tList.get("eductnSq").toString();
			String mbrSq = tList.get("mbrSq").toString();
			String artstSq = tList.get("artstSq").toString();
			String eductnNm = tList.get("eductnNm").toString();
			String eductnMajor = tList.get("eductnMajor").toString();
			
			param.put("eductnSq", eductnSq);
			param.put("mbrSq", mbrSq);
			param.put("artstSq", artstSq);
			param.put("eductnNm", eductnNm);
			param.put("eductnMajor", eductnMajor);
			
			saveState = memberService.authorEduInfoSaveData(param);
		}
		
		return saveState;
	}
	
	//작가학력정보 리스트
	@RequestMapping("/myPage/authorEduInfoViewData")
	@ResponseBody
	public ModelAndView authorEduInfoList(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = memberService.authorEduInfoList(param);
		
		mv.addObject("authorEdu", result);
		
		return mv;
	}
	
	//작가학력정보 삭제
	@RequestMapping("/myPage/authorEudInfoDeleteData")
	@ResponseBody
	public int authorEudInfoDelete(@RequestParam Map<String, Object> param) {
		
		int deleteState = -1;
		
		deleteState = memberService.authorEduInfoDelete(param);
		
		return deleteState;
	}
	
	//작가경력정보 입력
	@RequestMapping("/myPage/authorCareerInfoSaveData")
	@ResponseBody
	public int authorCareerInfoSaveData(HttpServletRequest request, @RequestBody List<Map<String, Object>> list) throws Exception {
		
		int saveState = -1;
		
		Map <String, Object> param =  new HashMap<String, Object>();

		for(Map<String, Object> tList : list) {
			
			String careerSq = tList.get("careerSq").toString();
			String mbrSq = tList.get("mbrSq").toString();
			String artstSq = tList.get("artstSq").toString();
			String careerTypCd = tList.get("careerTypCd").toString();
			String careerNm = tList.get("careerNm").toString();
			
			param.put("careerSq", careerSq);
			param.put("mbrSq", mbrSq);
			param.put("artstSq", artstSq);
			param.put("careerTypCd", careerTypCd);
			param.put("careerNm", careerNm);
			
			saveState = memberService.authorCareerInfoSaveData(param);
		}
		
		return saveState;
	}
	
	//작가경력 - 경력 리스트
	@RequestMapping("/myPage/authorCarrerInfoViewData")
	@ResponseBody
	public ModelAndView authorCarrerInfoList(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = memberService.authorCarrerInfoList(param);
		
		mv.addObject("authorCarrer", result);
		
		return mv;
	}
	
	//작가경력 - 경력 삭제
	@RequestMapping("/myPage/authorCarrerInfoDeleteData")
	@ResponseBody
	public int authorCarrerInfoDelete(@RequestParam Map<String, Object> param) {
		
		int deleteState = -1;
		
		deleteState = memberService.authorCarrerInfoDelete(param);
		
		return deleteState;
	}
	
	//작가경력정보 입력
	@RequestMapping("/myPage/authorExhbtnInfoSaveData")
	@ResponseBody
	public int authorExhbtnInfoSaveData(HttpServletRequest request, @RequestBody List<Map<String, Object>> list) throws Exception {
		
		int saveState = -1;
		
		Map <String, Object> param =  new HashMap<String, Object>();

		for(Map<String, Object> tList : list) {
			
			String exhbtnSq = tList.get("exhbtnSq").toString();
			String mbrSq = tList.get("mbrSq").toString();
			String artstSq = tList.get("artstSq").toString();
			String exhbtnTypCd = tList.get("exhbtnTypCd").toString();
			String exhbtnNm = tList.get("exhbtnNm").toString();
			
			param.put("exhbtnSq", exhbtnSq);
			param.put("mbrSq", mbrSq);
			param.put("artstSq", artstSq);
			param.put("exhbtnTypCd", exhbtnTypCd);
			param.put("exhbtnNm", exhbtnNm);
			
			saveState = memberService.authorExhbtnInfoSaveData(param);
		}
		
		return saveState;
	}
	
	//작가경력 - 경력 리스트
	@RequestMapping("/myPage/authorExhbtnInfoViewData")
	@ResponseBody
	public ModelAndView authorExhbtnInfoList(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = memberService.authorExhbtnInfoList(param);
		
		mv.addObject("author", result);
		
		return mv;
	}
	
	//작가경력 - 경력 삭제
	@RequestMapping("/myPage/authorExhbtnInfoDeleteData")
	@ResponseBody
	public int authorExhbtnInfoDelete(@RequestParam Map<String, Object> param) {
		
		int deleteState = -1;
		
		deleteState = memberService.authorExhbtnInfoDelete(param);
		
		return deleteState;
	}
	
	@RequestMapping("/scrapAdd")
	@ResponseBody
	public int scrapAdd(@RequestParam Map<String, Object> param) {
		int result = memberService.scrapAdd(param);
		return result;
	}
	
	@RequestMapping("/scrapDel")
	@ResponseBody
	public int scrapDel(@RequestParam Map<String, Object> param) {
		int result = memberService.scrapDel(param);
		return result;
	}
	
	//회원 아이디 찾기
	@RequestMapping("/findId")
	@ResponseBody
	public ModelAndView findId(@RequestParam String mbrCpCertDi) {
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> result = memberService.findId(mbrCpCertDi);
		result.put("mbrId", commonService.decrypt(result.get("mbrId").toString()));
		mv.addObject("result", result);
		return mv;
	}
	
	//회원 중복체크
	@RequestMapping("/memberDuplicateCheck")
	@ResponseBody
	public int memberDuplicateCheck(@RequestParam String mbrCpCertDi) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@ mbrCpCertDi :" + mbrCpCertDi);
		return memberService.memberDuplicateCheck(mbrCpCertDi);
	}
	
	//회원 비밀번호변경
	@RequestMapping("/changePasswrd")
	@ResponseBody
	public int changePasswrd(@RequestParam Map<String, Object> param) {
		param.put("mbrId", commonService.encrypt(param.get("mbrId").toString()));
		param.put("mbrPasswrd", commonService.encrypt(param.get("mbrPasswrd").toString()));
		return memberService.changePasswrd(param);
	}
	
	//회원 활동명 중복체크
	@RequestMapping("/mbrNcknmCheck")
	@ResponseBody
	public ModelAndView mbrNcknmCheck(@RequestParam String mbrNcknm) {
		ModelAndView mv = new ModelAndView("jsonView");
		int result = memberService.selectMbrNcknmCount(mbrNcknm);
		mv.addObject("result", result);
		return mv;
	}
}
