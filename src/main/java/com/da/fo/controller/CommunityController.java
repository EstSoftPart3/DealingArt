package com.da.fo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.fo.service.CommunityService;
import com.da.fo.service.DealService;
import com.da.fo.service.MyPageService;


@Controller
public class CommunityController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CommunityService communityService;
	
	@Autowired
	MyPageService myPageService;
	
	@Autowired
	DealService dealService;
	
	// 커뮤니티 홈 페이지
	@RequestMapping("/community/main")
	public String communityHome() {
		return "thymeleaf/fo/community/community_home";
	}

	// 커뮤니티 홈 모바일 메인페이지
	@RequestMapping("/community/mainMobile")
	public String communityHomeMobile() {
		return "thymeleaf/fo/community/community_home_mo";
	}

	// 커뮤니티 자랑하기 상세 페이지
	@RequestMapping("/community/showingOffDetail")
	@ResponseBody
	public ModelAndView showingOffDetail(@RequestParam(value="SqNumber") String param) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/othermem_mypage_showingoff_detailpage");
		Map<String, Object> result = communityService.comtOpenDelYnCheck(param);
		String openYn = result.get("openYn").toString();
		String delYn = result.get("delYn").toString();
		if(openYn.equals("N") || delYn.equals("Y")){
			mv.addObject("message", "존재하지 않는 게시물입니다.");
			return mv;
		}else{
			communityService.updateComtViews(param); //커뮤니티 조회수 증가
			
			mv.addObject("comtSq", param);
			
			return mv;
		}
	}
	

	// 커뮤니티 자랑하기 상세 정보 조회
	@RequestMapping("/community/searchShowingOffDetailList")
	@ResponseBody
	public ModelAndView searchShowingOffDetailList(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");

		Map<String, Object> result = new HashMap<>();
		Map<String, Object> showOffDtl = communityService.searchShowingOffDetail(param); // 자랑하기 상세 정보
		Map<String, Object> dealStatus = (Map<String, Object>) showOffDtl.get("dealStatus");
		
		//List<Map<String, Object>> result = myPageService.myPage_myCommunitysList(param);
		
		// 판매중인 작품이 아닐 경우 작품 정보만 출력
		if (dealStatus == null) {
			Map<String, Object> showOff = (Map<String, Object>) showOffDtl.get("showOff");
			result.put("work", dealService.workDetail(String.valueOf(showOff.get("workSq")))); // 작품 상세 정보
			result.put("deal", null);
		} else { // 판매중이거나 거래종료인 경우 작품 정보, 거래 관련 정보 출력
			String dealSttsCd = String.valueOf(dealStatus.get("dealSttsCd"));
			String dealSq = String.valueOf(dealStatus.get("dealSq"));

			switch (dealSttsCd) {
			case "TP": // 거래진행중
				result.put("deal", dealService.dealDetail(dealSq));
				result.put("work", null);
				break;
			case "TC":
			case "PD":
			case "DS":
			case "DC":
			case "PC": // 거래종료
				result.put("work", dealService.soldoutDetail(dealSq));
				result.put("deal", null);
				break;
			}
		}

		result.put("showOffList", showOffDtl);

		mv.addObject("result", result);

		return mv;
	}

	// 커뮤니티 홈 목록 조회
	@RequestMapping("/community/searchHomeList")
	@ResponseBody
	public ModelAndView searchHomeList() {
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> result = communityService.searchHomeList();
		
		// 커뮤니티 권한 정보 가져오기
		List<Map<String, Object>> boardAuth = communityService.selectBoardAuth("");
		
		mv.addObject("result", result);
		mv.addObject("boardAuth", boardAuth);
		return mv;
	}

	// 커뮤니티 이벤트 메인 페이지
	@RequestMapping("/community/event")
	public String communityEvent() {
		return "thymeleaf/fo/community/community_event";
	}

	// 커뮤니티 이벤트 모바일메인 페이지
	@RequestMapping("/community/eventMobile")
	public String communityEventMobile() {
		return "thymeleaf/fo/community/community_event_mo";
	}

	// 커뮤니티 이벤트 목록 조회
	@RequestMapping("/community/searchEventList")
	@ResponseBody
	public ModelAndView searchEventList(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> result = communityService.searchEventList(param);
		mv.addObject("result", result);
		return mv;
	}

	// 작품자랑 리스트 페이지
	@RequestMapping("/community/worksList")
	public String communityWorksListPage() {
		return "thymeleaf/fo/community/community_works";
	}
	// 작품자랑 리스트 페이지 모바일
	@RequestMapping("/community/worksListMobile")
	public String communityWorksListPageMobile() {
		return "thymeleaf/fo/community/community_works_mo";
	}

	// 커뮤니티 리스트 데이터 조회
	@RequestMapping("/community/communityListData")
	@ResponseBody
	public ModelAndView communityListData(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");

		if (null != param.get("offset")) {
			param.put("offset", Integer.parseInt(param.get("offset").toString()));
			param.put("limit", Integer.parseInt(param.get("limit").toString()));
		}

		List<Map<String, Object>> result = communityService.communityListData(param);

		// 커뮤니티 총개수 들고오기
		Map<String, Object> totalCount = communityService.getCommunityTotalCount(param);
		
		// 커뮤니티 권한 정보 가져오기
		List<Map<String, Object>> boardAuth = communityService.selectBoardAuth(param.get("comtTypCd").toString());

		mv.addObject("result", result);
		mv.addObject("totalCount", totalCount);
		mv.addObject("boardAuth", boardAuth);

		return mv;
	}

	// 전시후기/소개 리스트 페이지
	@RequestMapping("/community/exhintList")
	public String communityExhintListPage() {
		return "thymeleaf/fo/community/community_exhint";
	}
	// 전시후기/소개 리스트 페이지 모바일
	@RequestMapping("/community/exhintListMobile")
	public String communityExhintListPageMobile() {
		return "thymeleaf/fo/community/community_exhint_mo";
	}

	// 커뮤니티 전시후기/소개 지역구분 코드 들고오기
	@RequestMapping("/community/getExhibitRegionCdNm")
	public ModelAndView getExhibitRegionCdNm(@RequestParam String cdSq) {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> result = communityService.getDtlCdNm(cdSq);
		mv.addObject("result", result);
		return mv;
	}

	// 커뮤니티 전시후기/소개 전시구분 코드 들고오기
	@RequestMapping("/community/getExhibitTypCdNm")
	public ModelAndView getExhibitTypCdNm(@RequestParam String cdSq) {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> result = communityService.getDtlCdNm(cdSq);
		mv.addObject("result", result);
		return mv;
	}

	// 커뮤니티 이슈 페이지
	@RequestMapping("/community/issueList")
	public String communityIssueListPage() {
		return "thymeleaf/fo/community/community_issue";
	}
	// 커뮤니티 이슈 페이지 모바일
	@RequestMapping("/community/issueListMobile")
	public String communityIssueListPageMobile() {
		return "thymeleaf/fo/community/community_issue_mo";
	}

	// 전시후기/소개 상세페이지
	@RequestMapping("/community/exhibitDetail")
	@ResponseBody
	public ModelAndView communityExhibitDetailPage(@RequestParam Map<String, Object> param) {
//	public ModelAndView communityExhibitDetailPage(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/othermem_mypage_exhint_detailpage");
//		Map<String, Object> result = communityService.comtOpenDelYnCheck(String.valueOf(param.get("SqNumber")));
		Map<String, Object> result = communityService.comtOpenDelYnCheck(String.valueOf(param.get("SqNumber")));
		String openYn = result.get("openYn").toString();
		String delYn = result.get("delYn").toString();
		if(openYn.equals("N") || delYn.equals("Y")){
			mv.addObject("message", "존재하지 않는 게시물입니다.");
			return mv;
		}else{
			communityService.updateComtViews(param); //커뮤니티 조회수 증가
			//Map<String, Object> exhibit = communityService.communityExhKnoDetail(param);
			Map<String, Object> exhibit = communityService.communityExhKnoDetail(String.valueOf(param.get("SqNumber")));
			mv.addObject("exhibit", exhibit);
			
			param.put("comtSq", String.valueOf(param.get("SqNumber")));
			param.put("mbrSq", String.valueOf(exhibit.get("mbrSq")));
			param.put("comtTypCd", String.valueOf(exhibit.get("comtTypCd")));

			// 해당 작성자의 다른 커뮤니티 정보
			List<Map<String, Object>> otherComt = communityService.writerOtherComt(param);
			
			// 커뮤니티 권한 정보 가져오기
			List<Map<String, Object>> boardAuth = communityService.selectBoardAuth(param.get("comtTypCd").toString());
			
			mv.addObject("otherComt", otherComt);
			mv.addObject("boardAuth", boardAuth);
			return mv;
		}

	}

	// 이슈 상세페이지
	@RequestMapping("/community/issueDetail")
	@ResponseBody
	public ModelAndView communityIssueDetailPage(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/othermem_mypage_issue_detailpage");

		Map<String, Object> result = communityService.comtOpenDelYnCheck(String.valueOf(param.get("SqNumber")));
		
		String openYn = result.get("openYn").toString();
		String delYn = result.get("delYn").toString();
		if(openYn.equals("N") || delYn.equals("Y")){
			mv.addObject("message", "존재하지 않는 게시물입니다.");
			
			return mv;
		}else{
			communityService.updateComtViews(param); //커뮤니티 조회수 증가
			Map<String, Object> issue = communityService.communityExhKnoDetail(String.valueOf(param.get("SqNumber")));
			mv.addObject("issue", issue);

			param.put("comtSq", String.valueOf(param.get("SqNumber")));
			param.put("mbrSq", String.valueOf(issue.get("mbrSq")));
			param.put("comtTypCd", String.valueOf(issue.get("comtTypCd")));

			// 해당 작성자의 다른 커뮤니티 정보
			List<Map<String, Object>> otherComt = communityService.writerOtherComt(param);
			
			// 커뮤니티 권한 정보 가져오기
			List<Map<String, Object>> boardAuth = communityService.selectBoardAuth(param.get("comtTypCd").toString());
			
			mv.addObject("otherComt", otherComt);
			mv.addObject("boardAuth", boardAuth);
			
			return mv;
		}
	}

	// 댓글, 대댓글 삭제
	@RequestMapping("/community/delCommentAndReply")
	@ResponseBody
	public ModelAndView communityDelComment(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");

		int result = communityService.delCommentAndReply(param);
		mv.addObject("result", result);

		return mv;
	}

	// 팔로우 하기
	@RequestMapping("/community/follow")
	public ModelAndView communityFollow(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");

		//int result = communityService.communityFollow(param);
		int result = communityService.communityNewFollow(param);
		mv.addObject("result", result);

		return mv;
	}

	// 댓글 등록
	@RequestMapping("/community/cmtReg")
	@ResponseBody
	public ModelAndView comtReg(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		int result = communityService.comtReg(param);
		mv.addObject("result", result);
		return mv;
	}

	// 댓글, 대댓글 조회
	@RequestMapping("/community/searchComtCmtsList")
	@ResponseBody
	public ModelAndView searchComtCmtsList(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		
		// 댓글 리스트
		List<Map<String, Object>> comments = communityService.communityComment(param);
		// 대댓글 리스트
		List<Map<String, Object>> replys = communityService.communityReply(param);
		
		String commTypeCd = "";
				
		// 커뮤니티 권한 정보 가져오기
		if(!StringUtils.isBlank(commTypeCd)){
			commTypeCd = param.get("commTypeCd").toString();
		}else {
			commTypeCd = "";
		}
		List<Map<String, Object>> boardAuth = communityService.selectBoardAuth(commTypeCd);
		
		mv.addObject("comments", comments);
		mv.addObject("replys", replys);
		mv.addObject("boardAuth", boardAuth);

		return mv;
	}

	// 대댓글 등록
	@RequestMapping("/community/replyReg")
	@ResponseBody
	public ModelAndView replyReg(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		int result = communityService.replyReg(param);
		mv.addObject("result", result);
		return mv;
	}

	// 댓글, 대댓글 수정
	@RequestMapping("/community/modCommentAndReply")
	@ResponseBody
	public ModelAndView modCommentAndReply(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		int result = communityService.modCommentAndReply(param);
		mv.addObject("result", result);
		return mv;
	}

	// 팔로우 했는지 체크
	@RequestMapping("/community/followCheck")
	public ModelAndView followCheck(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");

		int result = communityService.followCheck(param);
		mv.addObject("result", result);

		return mv;
	}

	// 판매 제안하기 or 요청하기 등록
	@RequestMapping("/community/insertComtRequest")
	@ResponseBody
	public ModelAndView insertComtRequest(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		int result = communityService.insertComtRequest(param);
		mv.addObject("result", result);
		return mv;
	}

}
