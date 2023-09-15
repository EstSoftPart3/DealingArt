package com.da.fo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.da.common.AwsS3Service;
import com.da.fo.service.MemberService;
import com.da.fo.service.MyPageService;
import com.da.mapper.MainMapper;
import com.da.mapper.MainPayMapper;
import com.da.mapper.MyPageMapper;
import com.da.util.CommonService;
import com.da.util.SendMailUtil;
import com.da.util.SendSmsUtil;
import com.da.vo.FileVo;

@Controller
public class MyPageController {

	@Autowired
	private AwsS3Service awsS3Service;

	@Autowired
	private MemberService memberService;

	@Autowired
	private CommonService commonService;

	@Autowired
	private SendSmsUtil sendSmsUtil;

	@Autowired
	private SendMailUtil sendMailUtil;

	@Autowired
	private MyPageService myPageService;
	
	@Autowired
	private MainMapper mainMapper;
	
	@Autowired
	private MyPageMapper myPageMapper;
	
	@Autowired
	private MainPayMapper mainPayMapper;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 마이페이지 모두보기 페이지
	@RequestMapping("/myPage/main")
	public String mypage_main(){
		
		return "thymeleaf/fo/myPage/mypage_main";
	}
	// 마이페이지 모두보기 페이지 모바일
	@RequestMapping("/myPage/myPageMobile")
	public String mypage_mainMobile(){
		
		return "thymeleaf/fo/myPage/mypage_main_mo";
	}
	
	
	//마이페이지 메인 마이 데이터
	@RequestMapping("/myPage/main/myInfo")
	@ResponseBody
	public ModelAndView myPageMain_MyInfo(HttpServletRequest request, @Nullable @RequestParam(value="mbrSq") String param){
		ModelAndView mv = new ModelAndView("jsonView");
		HttpSession session = request.getSession();
		String mbrSq = "";
		if(param != null && !param.equals("")){
			mbrSq = param;
		}else{
			mbrSq = session.getAttribute("mbrSq").toString(); //로그인한 회원 순번 가져오기
		}
		 
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mbrSq", mbrSq); //로그인한 회원 순번 넣기
		
		Map<String, Object> myInfo = myPageService.myPageMain_myInfo(mbrSq); //나의 정보 조회
		
		mv.addObject("myInfo", myInfo);

		return mv;
	}
	
	//마이페이지 메인 활동내역 데이터
	@RequestMapping("/myPage/main/MyInfoAction")
	@ResponseBody
	public ModelAndView myPageMain_MyInfo_Action(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("jsonView");
		HttpSession session = request.getSession();
		
		String mbrSq = session.getAttribute("mbrSq").toString(); //로그인한 회원 순번 가져오기
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mbrSq", mbrSq); //로그인한 회원 순번 넣기
		paramMap.put("workTypCd","");
		
		List<Map<String, Object>> myWorks = myPageService.myPageMain_myWorks(mbrSq); //나의 작품 리스트 조회
		int myWorksTotal = myPageService.myPageMain_myWorksTotal(paramMap); //나의 작품 총 갯수 조회
		
		paramMap.put("comtTypCd", "BOA"); //커뮤니티 구분 코드 자랑하기로 변경
		paramMap.put("limit", 3); //LIMIT 넣기
		List<Map<String, Object>> myBoast = myPageService.myPageMain_myCommunitys(paramMap); //나의 자랑하기 조회
		int myBoastTotal = myPageService.myPageMain_myCommunitysTotal(paramMap); //나의 자랑하기 총 갯수 조회
		
		paramMap.put("comtTypCd", "EXH"); //커뮤니티 구분 코드 전시후기로 변경
		paramMap.put("limit", 3); //LIMIT 넣기
		List<Map<String, Object>> myExhbn = myPageService.myPageMain_myCommunitys(paramMap); //나의 전시후기 조회
		int myExhbnTotal = myPageService.myPageMain_myCommunitysTotal(paramMap); //나의 전시후기 총 갯수 조회
		
		paramMap.put("comtTypCd", "ISS"); //커뮤니티 구분 코드 이슈로 변경
		paramMap.put("limit", 3); //LIMIT 넣기
		List<Map<String, Object>> myIssue = myPageService.myPageMain_myCommunitys(paramMap); //나의 이슈 조회
		int myIssueTotal = myPageService.myPageMain_myCommunitysTotal(paramMap); //나의 이슈 총 갯수 조회
		
		
		//paramMap.put("limit", 3); //LIMIT 넣기
		//List<Map<String, Object>> myNoti = myPageService.myPageMain_myNoti(paramMap); //나의 이슈 조회
		//int myNotiTotal = myPageService.myPageMain_myCommunitysTotal(paramMap); //나의 이슈 총 갯수 조회
		
		
		mv.addObject("myWorks", myWorks);
		mv.addObject("myWorksTotal", myWorksTotal);
		mv.addObject("myBoast", myBoast);
		mv.addObject("myBoastTotal", myBoastTotal);
		mv.addObject("myExhbn", myExhbn);
		mv.addObject("myExhbnTotal", myExhbnTotal);
		mv.addObject("myIssue", myIssue);
		mv.addObject("myIssueTotal", myIssueTotal);
		
		return mv;
	}
	

	//마이페이지 전시후기 페이지
	@RequestMapping("/myPage/exhintMobile")
	public String exhintMobile() {
		return "thymeleaf/fo/myPage/mypage_exhint_mo";
	}
	//마이페이지 전시후기 페이지
		@RequestMapping("/myPage/exhintMobileReg")
		public String exhintMobileReg() {
			return "thymeleaf/fo/myPage/mypage_exhint_page2_mo";
		}
	//마이페이지 이슈 페이지
	@RequestMapping("/myPage/issueMobile")
	public String issueMobile() {
		return "thymeleaf/fo/myPage/mypage_issue_mo";
	}//마이페이지 이슈 페이지
	@RequestMapping("/myPage/issueMobileReg")
	public String issueMobileReg() {
		return "thymeleaf/fo/myPage/mypage_issue_page2_mo";
	}
	// 마이페이지 자랑하기 페이지
	@RequestMapping("/myPage/show_off")
	public String mypage_showingoff() {
		return "thymeleaf/fo/myPage/mypage_showingoff";
	}
	
	// 마이페이지 전시후기/소개 페이지
	@RequestMapping("/myPage/exhint")
	public String mypage_exhint() {
		return "thymeleaf/fo/myPage/mypage_exhint";
	}
	
	// 마이페이지 이슈 페이지
	@RequestMapping("/myPage/issue")
	public String mypage_issue() {
		return "thymeleaf/fo/myPage/mypage_issue";
	}
	
	@RequestMapping("/myPage/trnsprtTypCdUpdate")
	@ResponseBody
	public ModelAndView trnsprtTypCdUpdate(@RequestBody Map<String, Object> param) {
		System.out.println(param);
		ModelAndView mv = new ModelAndView("jsonView");
		int result = myPageService.trnsprtTypCdUpdate(param);
		System.out.println(result);
		mv.addObject("result", result);
		return mv;
	}
	
	//회원 탈퇴
	@RequestMapping("/myPage/withdrawal")
	public String withdrawal() {
		return "thymeleaf/fo/myPage/secession";
	}

	// 회원수정 페이지
	@RequestMapping("/myPage/memberEdit")
	public String memberEdit() {
		return "thymeleaf/fo/myPage/memberEdit";
	}

	// 소장품 등록 페이지 오픈
	@RequestMapping("/myPage/collection_reg")
	public String collectionReg() {
		return "thymeleaf/fo/myPage/collection_reg";
	}

	// 나의 작품 등록 페이지 오픈
	@RequestMapping("/myPage/myWork_reg")
	public String myWorkReg() {
		return "thymeleaf/fo/myPage/myWork_reg";
	}

	// 알림
	@RequestMapping("/myPage/alarm")
	public String alarm() {
		return "thymeleaf/fo/myPage/alarm";
	}

	// 쿠폰
	@RequestMapping("/myPage/coupon")
	public String coupon() {
		return "thymeleaf/fo/myPage/coupon";
	}
	
	//모바일 마이페이지
	@RequestMapping("/myPage/mMyPage")
	public String mobileMyPage() {
		return "thymeleaf/fo/myPage/mypage_mobile";
	}

	//마이페이지 레프트 메뉴 불러오기
	@RequestMapping("/myPage/mypage_common_left")
	@ResponseBody
	public ModelAndView mypage_common_left(@Nullable @RequestParam(value="mbrSq") String mbrSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/mypage_common_left");
		mv.addObject("mbrSq", mbrSq);
		return mv;
	}
	
	//모바일 마이페이지
	@RequestMapping("/myPage/mypage_profile_edit")
	public String mypage_profile_edit() {
		return "thymeleaf/fo/myPage/mypage_profile_edit";
	}
	
	/*
	 * 결제 시, 로그인한 회원의 사용가능한 쿠폰 리스트를 보여준다.
	 * param : mbrSq, cuponTypCd(DD:거래수수료할인/TD:운송수수료할인)
	 * return : 쿠폰목록
	 */
	@RequestMapping("/myPage/myCouponList_payment")
	@ResponseBody
	public ModelAndView myCouponList_payment(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		System.out.println("############# param : " + param);
		
		List result = myPageService.myCouponList_payment(param);
		mv.addObject("result", result);
		
		return mv;
	}
	
	// 쿠폰 리스트 조회
	@RequestMapping("/myPage/myCouponList")
	@ResponseBody
	public ModelAndView myCouponList(@RequestParam(value = "mbrSq", required = false) String mbrSq) {
		ModelAndView mv = new ModelAndView("jsonView");
		System.out.println("############# mbrSq : " + mbrSq);
		List result = myPageService.myCouponList(mbrSq);
		mv.addObject("result", result);
		return mv;
	}
	
	// 쿠폰 등록
	@RequestMapping("/myPage/myRegCoupon")
	@ResponseBody
	public ModelAndView myRegCoupon(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		System.out.println("############# param : " + param);
		
		Map<String, String> result = myPageService.myRegCoupon(param);
		mv.addObject("result", result);
		return mv;
	}
	
	// 소장품
	@RequestMapping("/myPage/myCollection")
	@ResponseBody
	public ModelAndView myCollection(@RequestParam(value = "SqNumber", required = false) String mbrSq) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@ mbrSq : " + mbrSq);
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/myGallery_myCollection");
		List result = myPageService.myCollection(mbrSq);
		mv.addObject("result", result);
		return mv;
	}

	//통합 나의 작품 화면 오픈
	@RequestMapping("/myPage/workList")
	public String myWorkList(HttpServletRequest request) {
		
		String mv = "thymeleaf/fo/myPage/mypage_myworks";
		
		return mv;
	}
	//통합 나의 작품 모바일 화면 오픈
		@RequestMapping("/myPage/myWorkListMobile")
		public String myWorkListMobile() {
		
			String mv = "thymeleaf/fo/myPage/mypage_myworks_mo";
			
			return mv;
		}
	
	//통합 나의 작품 화면 오픈
	@RequestMapping("/tempold/myWorkList")
	public String myWorkList() {
		return "thymeleaf/fo/myPage/myWorkList";
	}
	
	//통합 나의 작품 검색
	@RequestMapping("/myPage/myWorkListSearch")
	@ResponseBody
	public ModelAndView myWorkListSearch(@RequestParam Map<String, Object> param) {
		System.out.println(param);
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> result = myPageService.myWorkList(param);
		
		
		param.put("workTypCd","");
		int myTotal = myPageService.myPageMain_myWorksTotal(param); //나의 작품 총 갯수 조회
		
		param.put("workTypCd","COLL");
		int myCollTotal = myPageService.myPageMain_myWorksTotal(param); //나의 작품 콜렉션 총 갯수 조회
		
		param.put("workTypCd","WORK");
		int myWorksTotal = myPageService.myPageMain_myWorksTotal(param); //나의 작품 작업 총 갯수 조회

		mv.addObject("result", result);
		mv.addObject("myTotal", myTotal);
		mv.addObject("myCollTotal", myCollTotal);
		mv.addObject("myWorksTotal", myWorksTotal);

		return mv;
	}
	
	//통합 나의 작품 작품 공개/비공개 처리
	@RequestMapping("/myPage/myWorkOpenYn")
	@ResponseBody
	public ModelAndView myWorkOpenYn(@RequestParam(value = "workSqList[]", required = false) List<String> workSqList,
									@RequestParam(value = "workOpenYn", required = false) String workOpenYn) {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> paramList = new ArrayList<Map<String,Object>>();
		for(int i=0; i<workSqList.size(); i++) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("workOpenYn", workOpenYn);
			param.put("workSq", workSqList.get(i));
			paramList.add(param);
		}
		int result = myPageService.myWorkOpenYn(paramList);
		mv.addObject("result", result);
		return mv;
	}
	
	//통합 나의 작품 삭제 처리
	@RequestMapping("/myPage/myWorkDelYn")
	@ResponseBody
	public ModelAndView myWorkDelYn(@RequestParam(value = "workSqList[]", required = false) List<String> workSqList, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("jsonView");
		HttpSession session = request.getSession();
		List<Map<String, Object>> paramList = new ArrayList<Map<String,Object>>();
		for(int i=0; i<workSqList.size(); i++) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("mbrSq", session.getAttribute("mbrSq").toString());
			param.put("workSq", workSqList.get(i));
			paramList.add(param);
		}
		
		int result = myPageService.myWorkDelYn(paramList);
		mv.addObject("result", result);
		return mv;
	}
	
	//통합 나의 작품 판매중단 처리
	@RequestMapping("/myPage/myWorkDealDelete")
	@ResponseBody
	public ModelAndView myWorkDealDelete(@RequestParam(value = "dealSqList[]", required = false) List<String> dealSqList) {
		ModelAndView mv = new ModelAndView("jsonView");
		System.out.println(dealSqList);
		List<Map<String, Object>> result = myPageService.myWorkDealDelete(dealSqList);
		mv.addObject("result", result);
		return mv;
	}
	

	//통합 나의 작품 등록 페이지	  
	@RequestMapping("/myPage/myWorkListReg") public String myWorkListReg() {
	return "thymeleaf/fo/myPage/myWorkReg"; 
	}


	// 스크랩

	@RequestMapping("/myPage/scrap")
	@ResponseBody
	public ModelAndView scrap(@RequestParam(value = "SqNumber", required = false) String mbrSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/myGallery_scrap");
		List<Map<String, Object>> result = myPageService.scrapList(mbrSq);
		mv.addObject("result", result);
		return mv;
	}
	// 스크랩 모바일 	
	@RequestMapping("/myPage/scrapMobile")
	public String scrapMobile() {
		return "thymeleaf/fo/myPage/mypage_scrap_mo"; 
		}

//	@RequestMapping("/myPage/scrap")
//	@ResponseBody
//	public ModelAndView scrap(@RequestParam(value = "SqNumber", required = false) String mbrSq) {
//		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/myGallery_scrap");
//		List<Map<String, Object>> result = myPageService.scrapList(mbrSq);
//		mv.addObject("result", result);
//		return mv;
//	}


	// 나의 작품
	@RequestMapping("/myPage/myWork")
	@ResponseBody
	public ModelAndView myWork(@RequestParam(value = "SqNumber", required = false) String artstSq) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@ artstSq : " + artstSq);
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/portfolio_myWork");
		List result = myPageService.myWork(artstSq);
		mv.addObject("result", result);
		return mv;
	}
	
	//통합 나의 커뮤니티 관련 검색
	@RequestMapping("/myPage/MyShowListserch")
	@ResponseBody
	public ModelAndView MyShowListserch(@RequestParam Map<String, Object> param) {
		System.out.println(param);
		ModelAndView mv = new ModelAndView("jsonView");
		
		List<Map<String, Object>> result = myPageService.myPage_myCommunitysList(param);
		
		
		param.put("workTypCd","");

		int myTotal = myPageService.myPageMain_myCommunitysTotal(param); //나의 작품 총 갯수 조회
		
		param.put("workTypCd","COLL");
		int myCollTotal = myPageService.myPageMain_myCommunitysTotal(param); //나의 작품 콜렉션 총 갯수 조회
		
		param.put("workTypCd","WORK");
		int myWorksTotal = myPageService.myPageMain_myCommunitysTotal(param); //나의 작품 작업 총 갯수 조회
		 
		
		mv.addObject("result", result);
		mv.addObject("myTotal", myTotal);
		mv.addObject("myCollTotal", myCollTotal);
		mv.addObject("myWorksTotal", myWorksTotal);

		return mv;
	}
	
	//통합 나의 작품 작품 공개/비공개 처리
	@RequestMapping("/myPage/myComtOpenYn")
	@ResponseBody
	public ModelAndView myShowOpenYn(@RequestParam(value = "comtSqList[]", required = false) List<String> comtSqList,
									@RequestParam(value = "comtOpenYn", required = false) String comtOpenYn) {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> paramList = new ArrayList<Map<String,Object>>();
		for(int i=0; i<comtSqList.size(); i++) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("comtOpenYn", comtOpenYn);
			param.put("comtSq", comtSqList.get(i));
			paramList.add(param);
		}
		int result = myPageService.myComtOpenYn(paramList);
		mv.addObject("result", result);
		return mv;
	}
	
	//통합 나의 작품 삭제 처리
	@RequestMapping("/myPage/myComtDelYn")
	@ResponseBody
	public ModelAndView myComtDelYn(@RequestParam(value = "comtSqList[]", required = false) List<String> comtSqList, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("jsonView");
		HttpSession session = request.getSession();
		System.out.println("myComtDelYn 체크");
		System.out.println("comtSqList[] 체크:"+comtSqList);

		List<Map<String, Object>> paramList = new ArrayList<Map<String,Object>>();
		for(int i=0; i<comtSqList.size(); i++) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("mbrSq", session.getAttribute("mbrSq").toString());
			param.put("comtSq", comtSqList.get(i));
			paramList.add(param);
		}
		
		int result = myPageService.myComtDelYn(paramList);
		mv.addObject("result", result);
		return mv;
	}

	//거래내역
	@RequestMapping("/myPage/myDeal")
	public String myDeal() {
		return "thymeleaf/fo/myPage/myDeal_list";
	}

	@RequestMapping("/myPage/myDealSearchList")
	@ResponseBody
	public ModelAndView myDealSearchList(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		System.out.println("############# param : " + param);
		List result = myPageService.myDealSearchList(param);
		mv.addObject("result", result);
		return mv;
	}

	// 작가정보등록
	@RequestMapping("/myPage/information")
	public String information() {
		return "thymeleaf/fo/myPage/portfolio_info";
	}

	//회원탈퇴
	@RequestMapping("/myPage/withdrawalSubmit")
	@ResponseBody
	public int withdrawalSubmit(@RequestParam @Nullable Map<String, Object> param, HttpSession session) {
		System.out.println("############## param : " + param);
		param.put("email", commonService.encrypt((String) param.get("email")));
		param.put("password", commonService.encrypt((String) param.get("password")));
		int chk = memberService.memberWithdrawalCheck(param);
		if (chk > 0) {
			return 2;
		} else {
			session.invalidate();
			return memberService.memberWithdrawal(param);
		}
	}

	// 회원수정 이메일인증 메일보내기 테스트
	@RequestMapping("/myPage/memberUpdatEmailCertification")
	@ResponseBody
	public String emailCertification(@RequestParam Map<String, Object> param) {

		String result = "";
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		Map<String, Object> tomap = new HashMap<String, Object>();
		List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
		Map<String, Object> params = new HashMap<String, Object>();

		int serti = (int) ((Math.random() * (99999 - 10000 + 1)) + 10000);

		String title = "Dealing Art 회원수정시 필요한 인증번호 입니다.";
		String content = "[인증번호] " + serti + " 입니다. <br/> 인증번호 확인란에 기입해주십시오.";

		String memberEmail = (String) param.get("mbrId");

		tomap.put("type", "R");
		tomap.put("address", memberEmail);
		mList.add(tomap);

		params.put("title", title);
		params.put("body", content);
		params.put("recipients", mList);

		rtnMap = sendMailUtil.sendMail(params);
		if (((int) Double.parseDouble(rtnMap.get("count").toString()) < 0)) {
			result = "error";
		} else {
			String sertiString = Integer.toString(serti);
			result = sertiString;
		}
		int paramStatus = -1;

		return result;
	}
	
	//회원수정 이메일인증 메일보내기 테스트 
		@RequestMapping("/emailTest")
		@ResponseBody
		public String emailTest() {
			
			String result = "";
			Map<String, Object> rtnMap = new HashMap<String, Object>();
			Map<String, Object> tomap = new HashMap<String, Object>();
			List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
			Map<String, Object> params = new HashMap<String, Object>();
			
			int serti = (int)((Math.random()* (99999 - 10000 + 1)) + 10000);
			
			String title = "Dealing Art HTML 테스트 메일입니다..";
			//String content = "[인증번호] "+ serti +" 입니다. <br/> 인증번호 확인란에 기입해주십시오.";
			String content = "<!DOCTYPE html>"
					+ "<html>"
					+ "    <head><meta content='width=device-width, initial-scale=1, maximum-scale=1' name='viewport'><meta charset='UTF-8'><style>"
					+ "            @media only screen and(max-width:640px) {"
					+ "                .stb-left-cell,"
					+ "                .stb-right-cell {"
					+ "                    max-width: 100% !important;"
					+ "                    width: 100% !important;"
					+ "                }"
					+ "                .stb-left-cell img,"
					+ "                .stb-right-cell img {"
					+ "                    width: 100%;"
					+ "                    height: auto;"
					+ "                }"
					+ "                .stb-left-cell > div {"
					+ "                    padding: 5px 10px !important;"
					+ "                    box-sizing: border-box;"
					+ "                }"
					+ "                .stb-right-cell > div {"
					+ "                    padding: 5px 10px !important;"
					+ "                    box-sizing: border-box;"
					+ "                }"
					+ "                .stb-cell-wrap {"
					+ "                    padding: 0 !important;"
					+ "                }"
					+ "                .stb-cell-wrap > tr > td {"
					+ "                    padding: 0 !important;"
					+ "                }"
					+ "                .stb-cell-wrap > tbody > tr > td {"
					+ "                    padding: 0 !important;"
					+ "                }"
					+ "                .stb-cell-wrap > tbody > tr > td.stb-text-box {"
					+ "                    padding: 0 10px !important;"
					+ "                }"
					+ "                .stb-left-cell > div.stb-text-box {"
					+ "                    padding: 5px 10px !important;"
					+ "                }"
					+ "                .stb-right-cell > div.stb-text-box {"
					+ "                    padding: 5px 10px !important;"
					+ "                }"
					+ "                .stb-container {"
					+ "                    width: 94% !important"
					+ "                }"
					+ "                .stb-container a {"
					+ "                    text-decoration: underline;"
					+ "                }"
					+ "                .stb-cta-only-wrap {"
					+ "                    padding: 10px 0 !important;"
					+ "                }"
					+ "            }"
					+ "        </style>"
					+ "    </head>"
					+ "    <body>"
					+ "        <div class=\"stb-container-full\" style=\"width:100%; padding:40px 0; background-color:#ffffff; margin: 0 auto;\">"
					+ "            <table class=\"stb-container\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" style=\"margin: 0px auto; width: 94%; max-width: 630px; background: rgb(255, 255, 255); border: 0px;\">"
					+ "                <tbody>"
					+ "                    <tr style=\"margin: 0;padding:0;\">"
					+ "                        <td style=\"width: 100%; max-width: 630px; margin: 0 auto; position: relative; border-spacing: 0; clear: both; border-collapse: separate;padding:0;overflow:hidden;_width:620px;\">"
					+ "                            <div style=\"height: 0px; max-height: 0px; border-width: 0px; border-color: initial; border-image: initial; visibility: hidden; line-height: 0px; font-size: 0px; overflow: hidden;display:none;\"></div>"
					+ "                            <table class=\"stb-block\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"overflow: hidden; margin: 0px auto; padding: 0px; width:100%;max-width: 630px; clear: both; background: none;border:0;\" width=\"100%\">"
					+ "                                <tbody>"
					+ "                                    <tr>"
					+ "                                        <td style=\"padding: 15px 0 15px 0; line-height: 1.8; border-width: 0px;\">"
					+ "                                            <table class=\"stb-cell-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0px 5px;table-layout:fixed\" width=\"100%\">"
					+ "                                                <tbody>"
					+ "                                                    <tr>"
					+ "                                                        <td style=\"padding: 0px 10px;\" width=\"100%\">"
					+ "                                                            <div>"
					+ "                                                                <p style=\"text-align: justify; margin: 0px;width:100%\"><img src=\"https://s3.ap-northeast-2.amazonaws.com/img.stibee.com/54874_1650865649.png\" style=\"width: 100%; display: inline; vertical-align: bottom; max-width: 100%; border-width: 0px; border-color: initial; border-image: initial; text-align: justify;\" width=\"590\"></p>"
					+ "                                                            </div>"
					+ "                                                        </td>"
					+ "                                                    </tr>"
					+ "                                                </tbody>"
					+ "                                            </table>"
					+ "                                        </td>"
					+ "                                    </tr>"
					+ "                                </tbody>"
					+ "                            </table>"
					+ "                            <table class=\"stb-block\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"overflow: hidden; margin: 0px auto; padding: 0px; width:100%;max-width: 630px; clear: both; background: none; border:0;\" width=\"100%;\">"
					+ "                                <tbody>"
					+ "                                    <tr>"
					+ "                                        <td style=\"padding: 15px 0 15px 0; line-height: 10px; border-width: 0px;\">"
					+ "                                            <table class=\"stb-cell-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"table-layout:fixed;padding: 0px 5px;\" width=\"100%\">"
					+ "                                                <tbody>"
					+ "                                                    <tr>"
					+ "                                                        <td style=\"padding: 0px 15px; line-height: 10px;\" width=\"100%\">"
					+ "                                                            <div>"
					+ "                                                                <p style=\"text-align: justify; margin: 0px; width:100%\"><img src=\"https://s3.ap-northeast-2.amazonaws.com/img.stibee.com/11188_1599120912.png\" style=\"width: 100%; display: inline; vertical-align: bottom; max-width: 100%; border-width: 0px; border-color: initial; border-image: initial; text-align: justify;\" width=\"590\" loading=\"eager\"></p>"
					+ "                                                            </div>"
					+ "                                                        </td>"
					+ "                                                    </tr>"
					+ "                                                </tbody>"
					+ "                                            </table>"
					+ "                                        </td>"
					+ "                                    </tr>"
					+ "                                </tbody>"
					+ "                            </table>"
					+ "                            <table class=\"stb-block\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"overflow: hidden; margin: 0px auto; padding: 0px; width:100%;max-width: 630px; clear: both; background: none;border:0;\" width=\"100%\">"
					+ "                                <tbody>"
					+ "                                    <tr>"
					+ "                                        <td style=\"padding: 5px 0 5px 0; line-height: 1.8; border-width: 0px;font-size: 14px;\">"
					+ "                                            <table class=\"stb-cell-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0px 5px;\" width=\"100%\">"
					+ "                                                <tbody>"
					+ "                                                    <tr>"
					+ "                                                        <td class=\"stb-text-box\" style=\"padding: 0px 15px;mso-line-height-rule: exactly;line-height:1.8;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;word-break: break-word;font-size: 14px;font-family: AppleSDGothic, apple sd gothic neo, noto sans korean, noto sans korean regular, noto sans cjk kr, noto sans cjk, nanum gothic, malgun gothic, dotum, arial, helvetica, MS Gothic, sans-serif!important; color: #333333\" width=\"100%\">"
					+ "                                                            <div style=\"text-align: center; font-size: 18px;\">"
					+ "                                                                <span style=\"font-weight: bold;\">안녕하세요, {아이디}님!&nbsp;</span>"
					+ "                                                            </div>"
					+ "                                                            <div style=\"text-align: center; font-size: 18px;\">"
					+ "                                                                <span style=\"font-weight: bold;\">딜링아트의 세계에 오신 걸 환영합니다.&nbsp;&nbsp;</span><br></div>"
					+ "                                                        </td>"
					+ "                                                    </tr>"
					+ "                                                </tbody>"
					+ "                                            </table>"
					+ "                                        </td>"
					+ "                                    </tr>"
					+ "                                </tbody>"
					+ "                            </table>"
					+ "                            <table class=\"stb-block\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"overflow: hidden; margin: 0px auto; padding: 0px; width:100%;max-width: 630px; clear: both; background: none;border:0;\" width=\"100%\">"
					+ "                                <tbody>"
					+ "                                    <tr>"
					+ "                                        <td style=\"padding: 20px 0 15px 0;line-height: 1.8; border-width: 0px;\">"
					+ "                                            <table class=\"stb-cell-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0px 0;\" width=\"100%\">"
					+ "                                                <tbody>"
					+ "                                                    <tr>"
					+ "                                                        <td style=\"padding: 0 0\">"
					+ "                                                            <div style=\"height: 0; background: none; padding: 0px; border-top-width:1px;border-top-style:dotted;border-top-color:#999999;margin:0 15px\"></div>"
					+ "                                                        </td>"
					+ "                                                    </tr>"
					+ "                                                </tbody>"
					+ "                                            </table>"
					+ "                                        </td>"
					+ "                                    </tr>"
					+ "                                </tbody>"
					+ "                            </table>"
					+ "                            <table class=\"stb-block\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"overflow: hidden; margin: 0px auto; padding: 0px; width:100%;max-width: 630px; clear: both; background: none;border:0;\" width=\"100%\">"
					+ "                                <tbody>"
					+ "                                    <tr>"
					+ "                                        <td style=\"padding: 15px 0 15px 0; line-height: 1.8; border-width: 0px;font-size: 14px;\">"
					+ "                                            <table class=\"stb-cell-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0px 5px;\" width=\"100%\">"
					+ "                                                <tbody>"
					+ "                                                    <tr>"
					+ "                                                        <td class=\"stb-text-box\" style=\"padding: 0px 15px;mso-line-height-rule: exactly;line-height:1.8;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;word-break: break-word;font-size: 14px;font-family: AppleSDGothic, apple sd gothic neo, noto sans korean, noto sans korean regular, noto sans cjk kr, noto sans cjk, nanum gothic, malgun gothic, dotum, arial, helvetica, MS Gothic, sans-serif!important; color: #333333\" width=\"100%\">"
					+ "                                                            <div style=\"text-align: center; color: rgb(51, 51, 51); font-size: 16px;\">"
					+ "                                                                <span style=\"font-weight: bold;\">딜링아트는 미술품 거래의 새로운 기준을 제시합니다.&nbsp;&nbsp;</span><br></div>"
					+ "                                                            <div style=\"text-align: center;\">"
					+ "                                                                <span style=\"color: rgb(51, 51, 51); font-family: AppleSDGothic, &quot;apple sd gothic neo&quot;, &quot;noto sans korean&quot;, &quot;noto sans korean regular&quot;, &quot;noto sans cjk kr&quot;, &quot;noto sans cjk&quot;, &quot;nanum gothic&quot;, &quot;malgun gothic&quot;, dotum, arial, helvetica, MS Gothic, sans-serif; font-style: normal;\"><br></span>"
					+ "                                                            </div>"
					+ "                                                            <div style=\"text-align: center;\">"
					+ "                                                                <span style=\"color: rgb(51, 51, 51); font-family: AppleSDGothic, &quot;apple sd gothic neo&quot;, &quot;noto sans korean&quot;, &quot;noto sans korean regular&quot;, &quot;noto sans cjk kr&quot;, &quot;noto sans cjk&quot;, &quot;nanum gothic&quot;, &quot;malgun gothic&quot;, dotum, arial, helvetica, MS Gothic, sans-serif; font-style: normal; font-weight: bold;\">□ 품격 있는 안심 서비스&nbsp;</span>"
					+ "                                                            </div>"
					+ "                                                            <div style=\"text-align: center; \">&nbsp;보증서 기반 거래, 프리미엄 운송 서비스를 제공합니다.&nbsp;</div>"
					+ "                                                            <div style=\"text-align: center; \"><br></div>"
					+ "                                                            <div style=\"text-align: center; \">"
					+ "                                                                <span style=\"font-weight: bold;\">□ 투명한 공개 경매&nbsp;</span>"
					+ "                                                            </div>"
					+ "                                                            <div style=\"text-align: center; \">실시간으로 경매 진행 현황을 확인할 수 있습니다.&nbsp;</div>"
					+ "                                                            <div style=\"text-align: center; \"><br></div>"
					+ "                                                            <div style=\"text-align: center; \">"
					+ "                                                                <span style=\"font-weight: bold;\">□ 온라인 다이렉트 결제 번거로운 과정은 이제 그만!&nbsp;</span>"
					+ "                                                            </div>"
					+ "                                                            <div style=\"text-align: center; \">온라인으로 간편하게 결제가 가능합니다.&nbsp;</div>"
					+ "                                                            <div style=\"text-align: center; \"><br></div>"
					+ "                                                            <div style=\"text-align: center; \">"
					+ "                                                                <span style=\"font-weight: bold;\">&nbsp;□ 다이어트 수수료&nbsp;</span>"
					+ "                                                            </div>"
					+ "                                                            <div style=\"text-align: center; \">거래 수수료의 거품을 빼고 합리적인 수수료를 제공합니다.&nbsp;</div>"
					+ "                                                            <div style=\"text-align: center; \"><br></div>"
					+ "                                                            <div style=\"text-align: center; \">&nbsp;<span style=\"font-weight: bold;\">□ 간편 판매 등록&nbsp;</span>"
					+ "                                                            </div>"
					+ "                                                            <div style=\"text-align: center; \">보증서만 업로드하면 딜링아트 에서 등록을 도와드립니다.&nbsp;<br></div>"
					+ "                                                        </td>"
					+ "                                                    </tr>"
					+ "                                                </tbody>"
					+ "                                            </table>"
					+ "                                        </td>"
					+ "                                    </tr>"
					+ "                                </tbody>"
					+ "                            </table>"
					+ "                            <table class=\"stb-block\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"overflow: hidden; margin: 0px auto; padding: 0px; max-width: 630px; clear: both; background: none;border:0;\" width=\"100%\">"
					+ "                                <tbody>"
					+ "                                    <tr>"
					+ "                                        <td style=\"padding: 15px 0 15px 0; text-align: center;margin:0 auto 0 auto\">"
					+ "                                            <div class=\"stb-cell-wrap-sns\" style=\"margin: 0 auto\">"
					+ "                                                <span style=\"list-style: none; padding: 0px 3px; margin: 0px;\">"
					+ "                                                    <a style=\"padding: 0px 3px; border-width: 0px; border-image: initial; text-decoration: none; display: inline-block;\" target=\"_blank\" title=\"홈페이지\"><img height=\"32px\" src=\"https://stibee.com/assets/images/sns/white/sns_icon_homepage.png\" style=\"width: 32px; height: 32px; display: block; border-width: 0px; border-color: initial; border-image: initial;\" width=\"32\"></a>"
					+ "                                                </span>"
					+ "                                                <span style=\"list-style: none; padding: 0px 3px; margin: 0px;\">"
					+ "                                                    <a style=\"padding: 0px 3px; border-width: 0px; border-image: initial; text-decoration: none; display: inline-block;\" target=\"_blank\" title=\"페이스북\"><img height=\"32px\" src=\"https://stibee.com/assets/images/sns/white/sns_icon_facebook.png\" style=\"width: 32px; height: 32px; display: block; border-width: 0px; border-color: initial; border-image: initial;\" width=\"32\"></a>"
					+ "                                                </span>"
					+ "                                                <span style=\"list-style: none; padding: 0px 3px; margin: 0px;\">"
					+ "                                                    <a style=\"padding: 0px 3px; border-width: 0px; border-image: initial; text-decoration: none; display: inline-block;\" target=\"_blank\" title=\"블로그\"><img height=\"32px\" src=\"https://stibee.com/assets/images/sns/white/sns_icon_blog.png\" style=\"width: 32px; height: 32px; display: block; border-width: 0px; border-color: initial; border-image: initial;\" width=\"32\"></a>"
					+ "                                                </span>"
					+ "                                                <span style=\"list-style: none; padding: 0px 3px; margin: 0px;\">"
					+ "                                                    <a style=\"padding: 0px 3px; border-width: 0px; border-image: initial; text-decoration: none; display: inline-block;\" target=\"_blank\" title=\"유튜브\"><img height=\"32px\" src=\"https://stibee.com/assets/images/sns/white/sns_icon_youtube.png\" style=\"width: 32px; height: 32px; display: block; border-width: 0px; border-color: initial; border-image: initial;\" width=\"32\"></a>"
					+ "                                                </span>"
					+ "                                                <span style=\"list-style: none; padding: 0px 3px; margin: 0px;\">"
					+ "                                                    <a style=\"padding: 0px 3px; border-width: 0px; border-image: initial; text-decoration: none; display: inline-block;\" target=\"_blank\" title=\"브런치\"><img height=\"32px\" src=\"https://stibee.com/assets/images/sns/white/sns_icon_brunch.png\" style=\"width: 32px; height: 32px; display: block; border-width: 0px; border-color: initial; border-image: initial;\" width=\"32\"></a>"
					+ "                                                </span>"
					+ "                                            </div>"
					+ "                                        </td>"
					+ "                                    </tr>"
					+ "                                </tbody>"
					+ "                            </table>"
					+ "                            <table class=\"stb-block\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"overflow: hidden; margin: 0px auto; padding: 0px; width:100%;max-width: 630px; clear: both; background: none;border:0;\" width=\"100%\">"
					+ "                                <tbody>"
					+ "                                    <tr>"
					+ "                                        <td style=\"padding: 20px 0 15px 0;line-height: 1.8; border-width: 0px;\">"
					+ "                                            <table class=\"stb-cell-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0px 0;\" width=\"100%\">"
					+ "                                                <tbody>"
					+ "                                                    <tr>"
					+ "                                                        <td style=\"padding: 0 0\">"
					+ "                                                            <div style=\"height: 0; background: none; padding: 0px; border-top-width:1px;border-top-style:dotted;border-top-color:#999999;margin:0 15px\"></div>"
					+ "                                                        </td>"
					+ "                                                    </tr>"
					+ "                                                </tbody>"
					+ "                                            </table>"
					+ "                                        </td>"
					+ "                                    </tr>"
					+ "                                </tbody>"
					+ "                            </table>"
					+ "                            <table class=\"stb-block\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"overflow: hidden; margin: 0px auto; padding: 0px; width:100%;max-width: 630px; clear: both; background: none;border:0;\" width=\"100%\">"
					+ "                                <tbody>"
					+ "                                    <tr>"
					+ "                                        <td style=\"padding: 15px 0 15px 0; border-width: 0px;\">"
					+ "                                            <table class=\"stb-cell-wrap\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"padding: 0px 5px;\" width=\"100%\">"
					+ "                                                <tbody>"
					+ "                                                    <tr>"
					+ "                                                        <td class=\"stb-text-box\" width=\"100%\" style=\"padding: 0px 10px;mso-line-height-rule: exactly;line-height:1.8;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;word-break: break-word;font-size: 12px;font-family: AppleSDGothic, apple sd gothic neo, noto sans korean, noto sans korean regular, noto sans cjk kr, noto sans cjk, nanum gothic, malgun gothic, dotum, arial, helvetica, MS Gothic, sans-serif!important;text-align: center; color: #606060\">"
					+ "                                                            <span style=\"color: rgb(153, 153, 153);\">맨션나인 주식회사</span><br><div>"
					+ "                                                                <span style=\"color: rgb(153, 153, 153);\">help@dealing-art.com</span>"
					+ "                                                            </div>"
					+ "                                                            <div>"
					+ "                                                                <span style=\"font-size: 12px; color: rgb(153, 153, 153);\">"
					+ "                                                                    <span style=\"font-size: 12px;\">주소:&nbsp;</span>"
					+ "                                                                    <span style=\"font-size: 12px; text-align: start;\">서울특별시 마포구 월드컵로28길 9 3층&nbsp;</span>"
					+ "                                                                </span>"
					+ "                                                                <span style=\"font-size: 14px; text-align: start;\"></span>"
					+ "                                                                <span style=\"color: rgb(153, 153, 153); font-size: inherit;\">전화번호: 070-4267-7371</span>"
					+ "                                                            </div>"
					+ "                                                            <div>"
					+ "                                                                <span style=\"color: rgb(153, 153, 153);\">"
					+ "                                                                    <a href=\"$%unsubscribe%$\" style=\"text-decoration: underline; color: rgb(153, 153, 153); display: inline;\" class=\" link-edited\" target=\"_blank\">수신거부</a>&nbsp;<a href=\"$%unsubscribe%$\" style=\"text-decoration: underline; color: rgb(153, 153, 153); display: inline;\" class=\" link-edited\" target=\"_blank\">Unsubscribe</a>"
					+ "                                                                </span>"
					+ "                                                                <b></b>"
					+ "                                                            </div>"
					+ "                                                        </td>"
					+ "                                                    </tr>"
					+ "                                                </tbody>"
					+ "                                            </table>"
					+ "                                        </td>"
					+ "                                    </tr>"
					+ "                                </tbody>"
					+ "                            </table>"
					+ "                        </td>"
					+ "                    </tr>"
					+ "                </tbody>"
					+ "            </table>"
					+ "        </div>"
					+ "    </body>"
					+ "</html>";
			
					
			//String memberEmail = (String) param.get("mbrId");
			
			String memberEmail = "swordbass.j3@gmail.com";
			
			tomap.put("type", "R");
			tomap.put("address", memberEmail);
			mList.add(tomap);
			
			params.put("title", title);
			params.put("body", content);
			//params.setContent(content, "text/html; charset=UTF-8");
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
	
	// 소장품 등록
	@PostMapping("/myPage/collectionReg")
	@ResponseBody
	public int collectionReg(@RequestPart(value = "work") Map<String, Object> param,
			@RequestPart(value = "workMainImgUrl") @Nullable MultipartFile workMainImgUrl,
			@RequestPart(value = "workImgFrtUrl") @Nullable MultipartFile workImgFrtUrl,
			@RequestPart(value = "workImgRerUrl") @Nullable MultipartFile workImgRerUrl,
			@RequestPart(value = "workGrtUrl") @Nullable MultipartFile workGrtUrl,
			@RequestPart(value = "workImgLefUrl") @Nullable MultipartFile workImgLefUrl,
			@RequestPart(value = "workImgRitUrl") @Nullable MultipartFile workImgRitUrl,
			@RequestPart(value = "workImgTopUrl") @Nullable MultipartFile workImgTopUrl,
			@RequestPart(value = "workImgBotUrl") @Nullable MultipartFile workImgBotUrl) throws IOException {
		
		//박상현 : 파일업로드 객체화 했으면??
		
		//작품 메인 사진
		if (workMainImgUrl != null) {
			FileVo file = awsS3Service.upload(workMainImgUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workMainImgUrl", file.getFileUrl());
		}
		//작품 전면 사진
		if (workImgFrtUrl != null) {
			FileVo file = awsS3Service.upload(workImgFrtUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workImgFrtUrl", file.getFileUrl());
		}
		//작품 후면 사진
		if (workImgRerUrl != null) {
			FileVo file = awsS3Service.upload(workImgRerUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workImgRerUrl", file.getFileUrl());
		}
		//보증서
		if (workGrtUrl != null) {
			FileVo file = awsS3Service.upload(workGrtUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workGrtUrl", file.getFileUrl());
		}
		//작품 사진 좌
		if (workImgLefUrl != null) {
			FileVo file = awsS3Service.upload(workImgLefUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workImgLefUrl", file.getFileUrl());
		}
		//작품 사진 우
		if (workImgRitUrl != null) {
			FileVo file = awsS3Service.upload(workImgRitUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workImgRitUrl", file.getFileUrl());
		}
		//작품 사진 상
		if (workImgTopUrl != null) {
			FileVo file = awsS3Service.upload(workImgTopUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workImgTopUrl", file.getFileUrl());
		}
		//작품 사진 하
		if (workImgBotUrl != null) {
			FileVo file = awsS3Service.upload(workImgBotUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workImgBotUrl", file.getFileUrl());
		}
		int result = myPageService.collectionReg(param);
		return result;
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

//	// 나의 작품 등록
//	@PostMapping("/myPage/myWorkReg")
//	@ResponseBody
//	public int myWorkReg(@RequestPart(value = "work") Map<String, Object> param,
//			@RequestPart(value = "workMainImgUrl") @Nullable MultipartFile workMainImgUrl,
//			@RequestPart(value = "workImgFrtUrl") @Nullable MultipartFile workImgFrtUrl,
//			@RequestPart(value = "workImgRerUrl") @Nullable MultipartFile workImgRerUrl,
//			@RequestPart(value = "workGrtUrl") @Nullable MultipartFile workGrtUrl,
//			@RequestPart(value = "workImgLefUrl") @Nullable MultipartFile workImgLefUrl,
//			@RequestPart(value = "workImgRitUrl") @Nullable MultipartFile workImgRitUrl,
//			@RequestPart(value = "workImgTopUrl") @Nullable MultipartFile workImgTopUrl,
//			@RequestPart(value = "workImgBotUrl") @Nullable MultipartFile workImgBotUrl) throws IOException {
//		//작품 타입
//		String workTypCd = param.get("workTypCd").toString();
//		//결과값
//		int result = 0;
//		if(workTypCd.equals("WORK")) {
//			//작품 메인 사진
//			if (workMainImgUrl != null) {
//				FileVo file = awsS3Service.upload(workMainImgUrl, "dealingart/work/"+param.get("mbrSq").toString());
//				param.put("workMainImgUrl", file.getFileUrl());
//			}
//			//작품 전면 사진
//			if (workImgFrtUrl != null) {
//				FileVo file = awsS3Service.upload(workImgFrtUrl, "dealingart/work/"+param.get("mbrSq").toString());
//				param.put("workImgFrtUrl", file.getFileUrl());
//			}
//			//작품 후면 사진
//			if (workImgRerUrl != null) {
//				FileVo file = awsS3Service.upload(workImgRerUrl, "dealingart/work/"+param.get("mbrSq").toString());
//				param.put("workImgRerUrl", file.getFileUrl());
//			}
//			//보증서
//			if (workGrtUrl != null) {
//				FileVo file = awsS3Service.upload(workGrtUrl, "dealingart/work/"+param.get("mbrSq").toString());
//				param.put("workGrtUrl", file.getFileUrl());
//			}
//			//작품 사진 좌
//			if (workImgLefUrl != null) {
//				FileVo file = awsS3Service.upload(workImgLefUrl, "dealingart/work/"+param.get("mbrSq").toString());
//				param.put("workImgLefUrl", file.getFileUrl());
//			}
//			//작품 사진 우
//			if (workImgRitUrl != null) {
//				FileVo file = awsS3Service.upload(workImgRitUrl, "dealingart/work/"+param.get("mbrSq").toString());
//				param.put("workImgRitUrl", file.getFileUrl());
//			}
//			//작품 사진 상
//			if (workImgTopUrl != null) {
//				FileVo file = awsS3Service.upload(workImgTopUrl, "dealingart/work/"+param.get("mbrSq").toString());
//				param.put("workImgTopUrl", file.getFileUrl());
//			}
//			//작품 사진 하
//			if (workImgBotUrl != null) {
//				FileVo file = awsS3Service.upload(workImgBotUrl, "dealingart/work/"+param.get("mbrSq").toString());
//				param.put("workImgBotUrl", file.getFileUrl());
//			}
//			result = myPageService.myWorkReg(param);
//		}else if(workTypCd.equals("COLL")){
//			//작품 메인 사진
//			if (workMainImgUrl != null) {
//				FileVo file = awsS3Service.upload(workMainImgUrl, "dealingart/collection/"+param.get("mbrSq").toString());
//				param.put("workMainImgUrl", file.getFileUrl());
//			}
//			//작품 전면 사진
//			if (workImgFrtUrl != null) {
//				FileVo file = awsS3Service.upload(workImgFrtUrl, "dealingart/collection/"+param.get("mbrSq").toString());
//				param.put("workImgFrtUrl", file.getFileUrl());
//			}
//			//작품 후면 사진
//			if (workImgRerUrl != null) {
//				FileVo file = awsS3Service.upload(workImgRerUrl, "dealingart/collection/"+param.get("mbrSq").toString());
//				param.put("workImgRerUrl", file.getFileUrl());
//			}
//			//보증서
//			if (workGrtUrl != null) {
//				FileVo file = awsS3Service.upload(workGrtUrl, "dealingart/collection/"+param.get("mbrSq").toString());
//				param.put("workGrtUrl", file.getFileUrl());
//			}
//			//작품 사진 좌
//			if (workImgLefUrl != null) {
//				FileVo file = awsS3Service.upload(workImgLefUrl, "dealingart/collection/"+param.get("mbrSq").toString());
//				param.put("workImgLefUrl", file.getFileUrl());
//			}
//			//작품 사진 우
//			if (workImgRitUrl != null) {
//				FileVo file = awsS3Service.upload(workImgRitUrl, "dealingart/collection/"+param.get("mbrSq").toString());
//				param.put("workImgRitUrl", file.getFileUrl());
//			}
//			//작품 사진 상
//			if (workImgTopUrl != null) {
//				FileVo file = awsS3Service.upload(workImgTopUrl, "dealingart/collection/"+param.get("mbrSq").toString());
//				param.put("workImgTopUrl", file.getFileUrl());
//			}
//			//작품 사진 하
//			if (workImgBotUrl != null) {
//				FileVo file = awsS3Service.upload(workImgBotUrl, "dealingart/collection/"+param.get("mbrSq").toString());
//				param.put("workImgBotUrl", file.getFileUrl());
//			}
//			result = myPageService.collectionReg(param);
//		}else{
//			result = 0;
//		}
//		
//		return result;
//	}
	
	// 나의 작품 등록
	@PostMapping("/myPage/myWorkReg")
	@ResponseBody
	public int myWorkReg(@RequestPart(value = "work") Map<String, Object> param,
			@RequestPart(value = "workMainImgUrl") @Nullable MultipartFile workMainImgUrl,
			@RequestPart(value = "workImgFrtUrl") @Nullable MultipartFile workImgFrtUrl,
			@RequestPart(value = "workImgRerUrl") @Nullable MultipartFile workImgRerUrl,
			@RequestPart(value = "workGrtUrl") @Nullable MultipartFile workGrtUrl,
			@RequestPart(value = "workImgLefUrl") @Nullable MultipartFile workImgLefUrl,
			@RequestPart(value = "workImgRitUrl") @Nullable MultipartFile workImgRitUrl,
			@RequestPart(value = "workImgTopUrl") @Nullable MultipartFile workImgTopUrl,
			@RequestPart(value = "workImgBotUrl") @Nullable MultipartFile workImgBotUrl,
			@RequestPart(value = "comtImgUrl") @Nullable MultipartFile comtImgUrl) throws IOException {
		
		// 작품 타입
		String workTypCd = param.get("workTypCd").toString();
		// 결과값
		int result = 0;
		String directory = "";
		
		if(workTypCd.equals("WORK")) {
			directory = "work";
		} else if(workTypCd.equals("COLL")) {
			directory = "collection";
		} else {
			directory = "fail";
		}
		
		Map<String, MultipartFile> imgUrlParams = new HashMap<String, MultipartFile>();
		
		imgUrlParams.put("workMainImgUrl", workMainImgUrl);
		imgUrlParams.put("workImgFrtUrl", workImgFrtUrl);
		imgUrlParams.put("workImgRerUrl", workImgRerUrl);
		imgUrlParams.put("workGrtUrl", workGrtUrl);
		imgUrlParams.put("workImgLefUrl", workImgLefUrl);
		imgUrlParams.put("workImgRitUrl", workImgRitUrl);
		imgUrlParams.put("workImgTopUrl", workImgTopUrl);
		imgUrlParams.put("workImgBotUrl", workImgBotUrl);
		
		// 작품 이미지 파일 서버에 올리기
		for (String key : imgUrlParams.keySet()) {
			MultipartFile imgUrl = imgUrlParams.get(key);
			
			if (imgUrl != null) {
				FileVo file = awsS3Service.upload(imgUrl, "dealingart/"+directory+"/"+param.get("mbrSq").toString());
				param.put(key, file.getFileUrl());
			}
		}
		
		// 커뮤니티 자랑하기 이미지 파일 서버에 올리기 
		if (comtImgUrl != null) {
			FileVo file = awsS3Service.upload(comtImgUrl, "dealingart/community/boa/"+param.get("mbrSq").toString());
			param.put("comtImgUrl", file.getFileUrl());
		}
		
		result = myPageService.regWorkAndComtBoa(param);
		
		return result;
	}
	
	//통합 나의 작품 수정 페이지 오픈
	@RequestMapping("/myPage/myWorkListMod")
	@ResponseBody
	public ModelAndView myWorkListMod(@RequestParam(value="workSq", required=false) String workSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/myWorkMod");
		Map<String, Object> work = myPageService.myWorkMod(workSq);
		mv.addObject("work", work);
		return mv;
	}

	// 나의 작품 수정 페이지 오픈
	@RequestMapping("/myPage/myWorkMod")
	@ResponseBody
	public ModelAndView myWorkMod(@RequestParam(value = "workSq", required = false) String workSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/myWork_mod");
		Map<String, Object> result = myPageService.myWorkMod(workSq);
		mv.addObject("result", result);
		return mv;
	}

	// 나의 작품 수정
	@PostMapping("/myPage/myWorkCor")
	@ResponseBody
	public int myWorkCor(@RequestPart(value = "work") Map<String, Object> param, 
			@RequestPart(value = "workMainImgUrl") @Nullable MultipartFile workMainImgUrl,
			@RequestPart(value = "workImgFrtUrl") @Nullable MultipartFile workImgFrtUrl,
			@RequestPart(value = "workImgRerUrl") @Nullable MultipartFile workImgRerUrl,
			@RequestPart(value = "workGrtUrl") @Nullable MultipartFile workGrtUrl,
			@RequestPart(value = "workImgLefUrl") @Nullable MultipartFile workImgLefUrl,
			@RequestPart(value = "workImgRitUrl") @Nullable MultipartFile workImgRitUrl,
			@RequestPart(value = "workImgTopUrl") @Nullable MultipartFile workImgTopUrl,
			@RequestPart(value = "workImgBotUrl") @Nullable MultipartFile workImgBotUrl) throws IOException {
		String workTypCd = param.get("workTypCd").toString();
		int result = 0;
		if(workTypCd.equals("WORK")) {
			//작품 메인 사진
			if (workMainImgUrl != null) {
				FileVo file = awsS3Service.upload(workMainImgUrl, "dealingart/work/"+param.get("mbrSq").toString());
				param.put("workMainImgUrl", file.getFileUrl());
			}
			//작품 전면 사진
			if (workImgFrtUrl != null) {
				FileVo file = awsS3Service.upload(workImgFrtUrl, "dealingart/work/"+param.get("mbrSq").toString());
				param.put("workImgFrtUrl", file.getFileUrl());
			}
			//작품 후면 사진
			if (workImgRerUrl != null) {
				FileVo file = awsS3Service.upload(workImgRerUrl, "dealingart/work/"+param.get("mbrSq").toString());
				param.put("workImgRerUrl", file.getFileUrl());
			}
			//보증서
			if (workGrtUrl != null) {
				FileVo file = awsS3Service.upload(workGrtUrl, "dealingart/work/"+param.get("mbrSq").toString());
				param.put("workGrtUrl", file.getFileUrl());
			}
			//작품 사진 좌
			if (workImgLefUrl != null) {
				FileVo file = awsS3Service.upload(workImgLefUrl, "dealingart/work/"+param.get("mbrSq").toString());
				param.put("workImgLefUrl", file.getFileUrl());
			}
			//작품 사진 우
			if (workImgRitUrl != null) {
				FileVo file = awsS3Service.upload(workImgRitUrl, "dealingart/work/"+param.get("mbrSq").toString());
				param.put("workImgRitUrl", file.getFileUrl());
			}
			//작품 사진 상
			if (workImgTopUrl != null) {
				FileVo file = awsS3Service.upload(workImgTopUrl, "dealingart/work/"+param.get("mbrSq").toString());
				param.put("workImgTopUrl", file.getFileUrl());
			}
			//작품 사진 하
			if (workImgBotUrl != null) {
				FileVo file = awsS3Service.upload(workImgBotUrl, "dealingart/work/"+param.get("mbrSq").toString());
				param.put("workImgBotUrl", file.getFileUrl());
			}
			
			result = myPageService.myWorkCor(param);
		}else if(workTypCd.equals("COLL")) {
			//작품 메인 사진
			if (workMainImgUrl != null) {
				FileVo file = awsS3Service.upload(workMainImgUrl, "dealingart/collection/"+param.get("mbrSq").toString());
				param.put("workMainImgUrl", file.getFileUrl());
			}
			//작품 전면 사진
			if (workImgFrtUrl != null) {
				FileVo file = awsS3Service.upload(workImgFrtUrl, "dealingart/collection/"+param.get("mbrSq").toString());
				param.put("workImgFrtUrl", file.getFileUrl());
			}
			//작품 후면 사진
			if (workImgRerUrl != null) {
				FileVo file = awsS3Service.upload(workImgRerUrl, "dealingart/collection/"+param.get("mbrSq").toString());
				param.put("workImgRerUrl", file.getFileUrl());
			}
			//보증서
			if (workGrtUrl != null) {
				FileVo file = awsS3Service.upload(workGrtUrl, "dealingart/collection/"+param.get("mbrSq").toString());
				param.put("workGrtUrl", file.getFileUrl());
			}
			//작품 사진 좌
			if (workImgLefUrl != null) {
				FileVo file = awsS3Service.upload(workImgLefUrl, "dealingart/collection/"+param.get("mbrSq").toString());
				param.put("workImgLefUrl", file.getFileUrl());
			}
			//작품 사진 우
			if (workImgRitUrl != null) {
				FileVo file = awsS3Service.upload(workImgRitUrl, "dealingart/collection/"+param.get("mbrSq").toString());
				param.put("workImgRitUrl", file.getFileUrl());
			}
			//작품 사진 상
			if (workImgTopUrl != null) {
				FileVo file = awsS3Service.upload(workImgTopUrl, "dealingart/collection/"+param.get("mbrSq").toString());
				param.put("workImgTopUrl", file.getFileUrl());
			}
			//작품 사진 하
			if (workImgBotUrl != null) {
				FileVo file = awsS3Service.upload(workImgBotUrl, "dealingart/collection/"+param.get("mbrSq").toString());
				param.put("workImgBotUrl", file.getFileUrl());
			}
			result = myPageService.collectionCor(param);
		}
		System.out.println("result = "+result);
		return result;
	}
	
	// 나의 소장품 수정 페이지 오픈
	@RequestMapping("/myPage/myCollectionMod")
	@ResponseBody
	public ModelAndView myCollectionMod(@RequestParam(value = "workSq", required = false) String workSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/collection_mod");
		Map<String, Object> result = myPageService.myCollectionMod(workSq);
		mv.addObject("result", result);
		return mv;
	}
	
	// 소장품 등록
	@PostMapping("/myPage/collectionCor")
	@ResponseBody
	public int collectionCor(@RequestPart(value = "work") Map<String, Object> param, 
			@RequestPart(value = "workMainImgUrl") @Nullable MultipartFile workMainImgUrl,
			@RequestPart(value = "workImgFrtUrl") @Nullable MultipartFile workImgFrtUrl,
			@RequestPart(value = "workImgRerUrl") @Nullable MultipartFile workImgRerUrl,
			@RequestPart(value = "workGrtUrl") @Nullable MultipartFile workGrtUrl,
			@RequestPart(value = "workImgLefUrl") @Nullable MultipartFile workImgLefUrl,
			@RequestPart(value = "workImgRitUrl") @Nullable MultipartFile workImgRitUrl,
			@RequestPart(value = "workImgTopUrl") @Nullable MultipartFile workImgTopUrl,
			@RequestPart(value = "workImgBotUrl") @Nullable MultipartFile workImgBotUrl) throws IOException {
		//작품 메인 사진
		if (workMainImgUrl != null) {
			FileVo file = awsS3Service.upload(workMainImgUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workMainImgUrl", file.getFileUrl());
		}
		//작품 전면 사진
		if (workImgFrtUrl != null) {
			FileVo file = awsS3Service.upload(workImgFrtUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workImgFrtUrl", file.getFileUrl());
		}
		//작품 후면 사진
		if (workImgRerUrl != null) {
			FileVo file = awsS3Service.upload(workImgRerUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workImgRerUrl", file.getFileUrl());
		}
		//보증서
		if (workGrtUrl != null) {
			FileVo file = awsS3Service.upload(workGrtUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workGrtUrl", file.getFileUrl());
		}
		//작품 사진 좌
		if (workImgLefUrl != null) {
			FileVo file = awsS3Service.upload(workImgLefUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workImgLefUrl", file.getFileUrl());
		}
		//작품 사진 우
		if (workImgRitUrl != null) {
			FileVo file = awsS3Service.upload(workImgRitUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workImgRitUrl", file.getFileUrl());
		}
		//작품 사진 상
		if (workImgTopUrl != null) {
			FileVo file = awsS3Service.upload(workImgTopUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workImgTopUrl", file.getFileUrl());
		}
		//작품 사진 하
		if (workImgBotUrl != null) {
			FileVo file = awsS3Service.upload(workImgBotUrl, "dealingart/collection/"+param.get("mbrSq").toString());
			param.put("workImgBotUrl", file.getFileUrl());
		}
		int result = myPageService.collectionCor(param);
		return result;
	}
	
	
	//구매내역 상세 페이지 이동
	@RequestMapping("/myPage/myDealDetailBuy")
	@ResponseBody
	public ModelAndView openMyDealDetailBuy(@RequestParam(value="dealSq", required=false)String dealSq, @RequestParam(value="mbrSq", required=false)String mbrSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/myDeal_detail_buy");
		Map<String, Object> result = myPageService.openMyDealDetailBuy(dealSq, mbrSq);
		mv.addObject("result", result);
		return mv;
	}
	
	//판매내역 상세 페이지 이동
	@RequestMapping("/myPage/myDealDetailSell")
	@ResponseBody
	public ModelAndView openMyDealDetailSell(@RequestParam(value="dealSq", required=false)String dealSq, @RequestParam(value="mbrSq", required=false)String mbrSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/myDeal_detail_sell");
		Map<String, Object> result = myPageService.openMyDealDetailSell(dealSq, mbrSq);
		mv.addObject("result", result);
		return mv;
	}
	
	//운송 매트리스 운송 가격, 코드 네임 가져오기
	@RequestMapping("/myPage/selectTrnsprtInfo")
	@ResponseBody
	public ModelAndView selectTrnsprtPrc(@RequestParam Map<String, Object> paramMap) {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> result = myPageService.selectTrnsprtInfo(paramMap);
		mv.addObject("result", result);
		return mv;
	}
	
	//배송 주소 변경
	@RequestMapping("/myPage/updateNewAddr")
	@ResponseBody
	public ModelAndView updateNewAddr(@RequestParam Map<String, Object> paramMap) {
		ModelAndView mv = new ModelAndView("jsonView");
		int result = memberService.mbrDelivryAddrCor(paramMap);
		mv.addObject("result", result);
		return mv;
	}
	
	//거래내역 응찰 히스토리 가져오기
	@RequestMapping("/myPage/myDealList/bidHistory")
	@ResponseBody
	public ModelAndView myDealListBidHistory(@RequestParam("dealSq") String dealSq) {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> result = myPageService.myDealListBidHistory(dealSq);
		mv.addObject("result", result);
		return mv;
	}
	
	//소장품 등록 작가 검색 모달창 자동완성
	@RequestMapping("/myPage/searchArtst")
	@ResponseBody
	public ModelAndView searchArtst(@RequestParam("searchKeyword") String searchKeyword) {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> result = mainMapper.totalSearchAutocompleteArtist(searchKeyword);
		mv.addObject("result", result);
		return mv;
	}
	
	//소장품 등록 작품 검색 모달창 자동완성
	@RequestMapping("/myPage/searchWork")
	@ResponseBody
	public ModelAndView searchWork(@RequestParam("searchKeyword") String searchKeyword) {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> result = mainMapper.totalSearchAutocompleteWork(searchKeyword);
		mv.addObject("result", result);
		return mv;
	}
	
	//운송 정보 저장
	@RequestMapping("/myPage/insertTrnsprt")
	@ResponseBody
	public int insertTrnsprt(@RequestBody Map<String, Object> param) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@ param : "+param);
		List<Map<String, Object>> paramList = (List<Map<String, Object>>) param.get("trnsprtInfo");
		for(int i=0; i<paramList.size(); i++) {
			paramList.get(i).put("dealSq", param.get("dealSq"));
			paramList.get(i).put("buyMbrSq", param.get("buyMbrSq"));
			paramList.get(i).put("sellMbrSq", param.get("sellMbrSq"));
			paramList.get(i).put("artstSq", param.get("artstSq"));
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@ paramList : "+paramList);
		int result = myPageService.insertTrnsprt(paramList);
		return result;
	}
	
	//해당 운송 정보 가져오기
	@RequestMapping("/myPage/getTrnsprt")
	@ResponseBody
	public ModelAndView getTrnsprt(@RequestBody List<Map<String, Object>> paramMap) {
		ModelAndView mv = new ModelAndView("jsonView");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@ TrnsprtParam : "+paramMap);
		List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
		for(int i=0; i<paramMap.size(); i++) {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("trnsprtDivCd", paramMap.get(i).get("trnsprtDivCd"));
			param.put("trnsprtServiceCdNm", paramMap.get(i).get("trnsprtServiceCdNm"));
			param.put("trnsprtPrc", paramMap.get(i).get("trnsprtPrc"));
			param.put("trnsprtTypCd", paramMap.get(i).get("trnsprtTypCd"));
			param.put("trnsprtAreaCd", paramMap.get(i).get("trnsprtAreaCd"));
			Map<String, Object> result = myPageMapper.getTrnsprt(param);
			resultList.add(result);
		}
		mv.addObject("result", resultList);
		return mv;
	}
	
	//소장품 등록 작품 검색 결과 클릭시
	@RequestMapping("/myPage/selectWork")
	@ResponseBody
	public ModelAndView selectWork(@RequestParam("workSq") String workSq) {
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> result = myPageService.myCollectionMod(workSq);
		mv.addObject("result", result);
		return mv;
	}
	
	//나의작품 / 소장품 거래등록 확인
	@RequestMapping("/mypage/dealWorkCountData")
	@ResponseBody
	public int dealWorkCount(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		//이메일 암호화
		String workSq = (String) param.get("workSq");
		param.put("workSq", workSq);
		
		int dealWorkCount = myPageService.dealWorkCount(param);
			
		return dealWorkCount;
	}
	
	//나의작품 / 소장품 거래등록 확인
	@RequestMapping("/myPage/applyCupon")
	@ResponseBody
	public ModelAndView applyCupon(@RequestParam Map<String, Object> param) {
		System.out.println(param);
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> result = myPageMapper.applyCupon(param);
		Long bTotalAmt = myPageMapper.beforeApplyCupon(param);
		Long totalAmt = myPageMapper.applyCuponTotal(param);
		Long discAmt = bTotalAmt - totalAmt;
		mv.addObject("result", result);
		mv.addObject("totalAmt", totalAmt);
		mv.addObject("discAmt", discAmt);
		return mv;
	}
	
	//소장품 삭제시 거래중 여부 확인
	@RequestMapping("/myPage/dealCheck")
	public ModelAndView dealCheck (@RequestParam("workSq") String workSq) {
		ModelAndView mv = new ModelAndView("jsonView");
		int result = myPageService.dealCheck(workSq);
		mv.addObject("result", result);
		return mv;
	}
	
	//소장품 삭제
	@RequestMapping("/myPage/deleteCollection")	
	public ModelAndView deleteCollection (@RequestParam("workSq") String workSq, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("jsonView");
		HttpSession session = request.getSession();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("workSq", workSq);
		param.put("mbrSq", session.getAttribute("REQ_SEQ").toString());
		myPageService.delCollection(param);
		String result = "/myCollection";
		mv.addObject("result", result);
		return mv;
	}
	
	// 작품 & 자랑하기 등록 페이지 오픈
	@RequestMapping("/myPage/myWorkList_reg")
	public String myWorkList_reg() {
		return "thymeleaf/fo/myPage/mypage_work_regipage2";
	}
	
	// (모바일)작품 & 자랑하기 등록 페이지 오픈
	@RequestMapping("/myPage/myWorkList_reg_mo")
	public String myWorkList_reg_mo() {
		return "thymeleaf/fo/myPage/mypage_work_regipage2_mo";
	}
	
	// 전시후기/소개 등록 페이지 오픈
	@RequestMapping("/myPage/myExhibit_reg")
	public String myExhibit_reg() {
		return "thymeleaf/fo/myPage/mypage_exhint_page2";
	}
	// 마이페이지 레프트 모바일
	@RequestMapping("/myPage/myPage_left")
	public String myPage_left() {
		return "thymeleaf/fo/myPage/mypage_left-nav";
	}
	
	// (모바일)전시후기/소개 등록 페이지 오픈
	@RequestMapping("/myPage/myExhibit_reg_mo")
	public String myExhibit_reg_mo() {
		return "thymeleaf/fo/myPage/mypage_exhint_page2_mo";
	}
	
	// 노하우 등록 페이지 오픈
	@RequestMapping("/myPage/issue_reg")
	public String myKnowhow_reg() {
		return "thymeleaf/fo/myPage/mypage_issue_page2";
	}
	
	// (모바일)노하우 등록 페이지 오픈
	@RequestMapping("/myPage/myKnowhow_reg_mo")
	public String myKnowhow_reg_mo() {
		return "thymeleaf/fo/myPage/mypage_knowhow_page2_mo";
	}
	
	// 전시후기/소개 등록
	@RequestMapping("/myPage/myexhibitReg")	
	@ResponseBody
	public int myexhibitReg(@RequestPart("exhibit") Map<String, Object> param,
			@RequestPart(value = "comtImgUrl") @Nullable MultipartFile comtImgUrl) throws IOException {
		int result = 0;
		System.out.println(param);
		
		if (comtImgUrl != null) {
			FileVo file = awsS3Service.upload(comtImgUrl, "dealingart/community/exhibit/"+param.get("mbrSq").toString());
			param.put("comtImgUrl", file.getFileUrl());
		}
		
		result = myPageService.myComtReg(param);
		
		return result;
	}
	
	// 노하우 등록
	@PostMapping("/myPage/myknowhowReg")
	@ResponseBody
	public int myKnowhowReg(@RequestPart("knowhow") Map<String, Object> param,
			@RequestPart(value = "comtImgUrl") @Nullable MultipartFile comtImgUrl) throws IOException {
		int result = 0;
		System.out.println(param);
		
		if (comtImgUrl != null) {
			FileVo file = awsS3Service.upload(comtImgUrl, "dealingart/community/knowhow/"+param.get("mbrSq").toString());
			param.put("comtImgUrl", file.getFileUrl());
		}
		
		result = myPageService.myComtReg(param);
		
		return result;
	}
	
	//마이페이지 알림창 열기
	@RequestMapping("/myPage/notis")
	public String serviceIntro() {
		return "thymeleaf/fo/myPage/myPage_notificationbox";
	}
	
	//마이페이지 알림 목록 조회
		@RequestMapping("/myPage/selectNotificationbox")
		@ResponseBody
		public ModelAndView myPage_notificationbox(@RequestParam Map<String, Object> param, HttpServletRequest request) {
			HttpSession session = request.getSession();
			String mbrSq = session.getAttribute("mbrSq").toString();
			
			int limit = Integer.parseInt(String.valueOf(param.get("limit")));
			
			param.put("mbrSq", mbrSq); //로그인한 회원 순번 넣기
			param.put("limit", limit);
			
			System.out.println(param);
			ModelAndView mv = new ModelAndView("jsonView");
			List<Map<String, Object>> result = myPageService.myPage_notificationbox(param);
			
			
			param.put("notiCatCd","");
			int myTotal = myPageService.myPage_notificationTotal(param); //총 갯수 조회
			
			param.put("notiCatCd","SEL");
			int mySelTotal = myPageService.myPage_notificationTotal(param); //판매제안 총 갯수 조회
			
			param.put("notiCatCd","PRC");
			int myPrcTotal = myPageService.myPage_notificationTotal(param); //가격협상 총 갯수 조회
			
			param.put("notiCatCd","PIC");
			int myPicTotal = myPageService.myPage_notificationTotal(param); //사진요청 총 갯수 조회

			mv.addObject("result", result);
			mv.addObject("myTotal", myTotal);
			mv.addObject("mySelTotal", mySelTotal);
			mv.addObject("myPrcTotal", myPrcTotal);
			mv.addObject("myPicTotal", myPicTotal);

			return mv;
		}
		
		//마이페이지 팔로잉 열기
		@RequestMapping("/myPage/following")
		public String serviceIntro2() {
			return "thymeleaf/fo/myPage/myPage_following";
		}
		
		//마이페이지 팔로잉 목록 조회
		@RequestMapping("/myPage/selectFollowing")
		@ResponseBody
		public ModelAndView myPage_following(@RequestParam Map<String, Object> param, HttpServletRequest request) {
			System.out.println(param);
			HttpSession session = request.getSession();
			String mbrSq = "";
			if(param.get("mbrSq") != null){
				mbrSq = param.get("mbrSq").toString();
			}else{
				mbrSq = session.getAttribute("mbrSq").toString();
			}
			System.out.println(mbrSq);
			int limit = Integer.parseInt(String.valueOf(param.get("limit")));
			
			param.put("mbrSq", mbrSq); //로그인한 회원 순번 넣기
			param.put("limit", limit);
			
			
			ModelAndView mv = new ModelAndView("jsonView");
			List<Map<String, Object>> result = myPageService.myPage_following(param);
			
			
			param.put("authSq","");
			int myTotal = myPageService.myPage_followingTotal(param); //총 갯수 조회
			
			param.put("authSq","1");
			int myColTotal = myPageService.myPage_followingTotal(param); //콜렉션 총 갯수 조회
			
			param.put("authSq","2");
			int myArtistTotal = myPageService.myPage_followingTotal(param); //작가 총 갯수 조회
			
			mv.addObject("result", result);
			mv.addObject("myTotal", myTotal);
			mv.addObject("myColTotal", myColTotal);
			mv.addObject("myArtistTotal", myArtistTotal);

			return mv;
		}
			
		//마이페이지 스크랩 열기
		@RequestMapping("/myPage/scrap")
		public String serviceIntro3() {
			return "thymeleaf/fo/myPage/myPage_scrap";
		}
		
		//마이페이지 스크랩 목록 조회
		@RequestMapping("/myPage/selectScrap")
		@ResponseBody
		public ModelAndView myPage_scrap(@RequestParam Map<String, Object> param, HttpServletRequest request) {
			HttpSession session = request.getSession();
			String mbrSq = session.getAttribute("mbrSq").toString();

			int limit = Integer.parseInt(String.valueOf(param.get("limit")));
			
			param.put("mbrSq", mbrSq); //로그인한 회원 순번 넣기
			param.put("limit", limit);
			
			System.out.println(param);
			ModelAndView mv = new ModelAndView("jsonView");

			List<Map<String, Object>> result = myPageService.myPage_scrap(param);
			
			
			param.put("scrapGbCd","myWork");
			int myWorkTotal = myPageService.myPage_scrapTotal(param); //나의 작품 갯수 조회
			
			param.put("scrapGbCd","BOA");
			int myBOATotal = myPageService.myPage_scrapTotal(param); //자랑하기 총 갯수 조회
			
			param.put("scrapGbCd","EXH");
			int myEXHTotal = myPageService.myPage_scrapTotal(param); //전시후기/소개 총 갯수 조회
			
			param.put("scrapGbCd","ISS");
			int myISSTotal = myPageService.myPage_scrapTotal(param); //이슈 총 갯수 조회
			
			param.put("scrapGbCd","IST");
			int myISTTotal = myPageService.myPage_scrapTotal(param); //인사이트 총 갯수 조회
			
			param.put("scrapGbCd","MDA");
			int myMDATotal = myPageService.myPage_scrapTotal(param); //아티스트 필름 총 갯수 조회
			
			mv.addObject("result", result);
			mv.addObject("myWorkTotal", myWorkTotal);
			mv.addObject("myBOATotal", myBOATotal);
			mv.addObject("myEXHTotal", myEXHTotal);
			mv.addObject("myISSTotal", myISSTotal);
			mv.addObject("myISTTotal", myISTTotal);
			mv.addObject("myMDATotal", myMDATotal);

			return mv;
		}

		//마이페이지 왼쪽 메뉴
		@RequestMapping("/myPage/leftNavMobile")
		public String leftNavMibile() {
			
			
			return "thymeleaf/fo/myPage/mypage_left-nav";
		}
				

		
		//타인페이지 메인
		@RequestMapping("/otherPage/main")
		public ModelAndView ohterPageMain(@RequestParam(value="mbrSq", required=false) String mbrSq) {
			ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/otherpage_main");
			mv.addObject("mbrSq", mbrSq);
			return mv;
		}
			
		//타인페이지 메인 활동내역 데이터
		@RequestMapping("/myPage/main/searchOtherInfoAction")
		@ResponseBody
		public ModelAndView otherPageMain_searchOtherInfoAction(@RequestParam Map<String, Object> param){
			ModelAndView mv = new ModelAndView("jsonView");
			
			String mbrSq = String.valueOf(param.get("mbrSq"));
			System.out.println("param++++++"+mbrSq);
			
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("mbrSq", mbrSq); //로그인한 회원 순번 넣기
			paramMap.put("workTypCd","");
			
			List<Map<String, Object>> myWorks = myPageService.myPageMain_myWorks(mbrSq); //나의 작품 리스트 조회
			int myWorksTotal = myPageService.myPageMain_myWorksTotal(paramMap); //나의 작품 총 갯수 조회
			
			paramMap.put("comtTypCd", "BOA"); //커뮤니티 구분 코드 자랑하기로 변경
			paramMap.put("limit", 3); //LIMIT 넣기
			List<Map<String, Object>> myBoast = myPageService.myPageMain_myCommunitys(paramMap); //나의 자랑하기 조회
			int myBoastTotal = myPageService.myPageMain_myCommunitysTotal(paramMap); //나의 자랑하기 총 갯수 조회
			
			paramMap.put("comtTypCd", "EXH"); //커뮤니티 구분 코드 전시후기로 변경
			paramMap.put("limit", 3); //LIMIT 넣기
			List<Map<String, Object>> myExhbn = myPageService.myPageMain_myCommunitys(paramMap); //나의 전시후기 조회
			int myExhbnTotal = myPageService.myPageMain_myCommunitysTotal(paramMap); //나의 전시후기 총 갯수 조회
			
			paramMap.put("comtTypCd", "ISS"); //커뮤니티 구분 코드 이슈로 변경
			paramMap.put("limit", 3); //LIMIT 넣기
			List<Map<String, Object>> myIssue = myPageService.myPageMain_myCommunitys(paramMap); //나의 이슈 조회
			int myIssueTotal = myPageService.myPageMain_myCommunitysTotal(paramMap); //나의 이슈 총 갯수 조회
			
			//paramMap.put("limit", 3); //LIMIT 넣기
			//List<Map<String, Object>> myNoti = myPageService.myPageMain_myNoti(paramMap); //나의 이슈 조회
			//int myNotiTotal = myPageService.myPageMain_myCommunitysTotal(paramMap); //나의 이슈 총 갯수 조회
			
			
			mv.addObject("myWorks", myWorks);
			mv.addObject("myWorksTotal", myWorksTotal);
			mv.addObject("myBoast", myBoast);
			mv.addObject("myBoastTotal", myBoastTotal);
			mv.addObject("myExhbn", myExhbn);
			mv.addObject("myExhbnTotal", myExhbnTotal);
			mv.addObject("myIssue", myIssue);
			mv.addObject("myIssueTotal", myIssueTotal);
			
			return mv;
		}
		
		//타인페이지 나의 작품
		@RequestMapping("/otherPage/workList")
		public ModelAndView otherPageWorkList(@RequestParam(value="mbrSq", required=false) String mbrSq) {
			ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/mypage_myworks");
			mv.addObject("mbrSq", mbrSq);
			return mv;
		}
		
		//타인페이지 자랑하기
		@RequestMapping("/otherPage/show_off")
		public ModelAndView otherPageShowOff(@RequestParam(value="mbrSq", required=false) String mbrSq) {
			ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/mypage_showingoff");
			mv.addObject("mbrSq", mbrSq);
			return mv;
		}
		
		//타인페이지 전시후기/소개
		@RequestMapping("/otherPage/exhint")
		public ModelAndView otherPageExhint(@RequestParam(value="mbrSq", required=false) String mbrSq) {
			ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/mypage_exhint");
			mv.addObject("mbrSq", mbrSq);
			return mv;
		}
		
		//타인페이지 이슈
		@RequestMapping("/otherPage/issue")
		public ModelAndView otherPageIssue(@RequestParam(value="mbrSq", required=false) String mbrSq) {
			ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/mypage_issue");
			mv.addObject("mbrSq", mbrSq);
			return mv;
		}
		
		//타인페이지 팔로잉
		@RequestMapping("/otherPage/following")
		public ModelAndView otherPageFollowing(@RequestParam(value="mbrSq", required=false) String mbrSq) {
			ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/myPage_following");
			mv.addObject("mbrSq", mbrSq);
			return mv;
		}

}
