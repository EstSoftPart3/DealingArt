package com.da.fo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.fo.service.CommunityService;
import com.da.fo.service.DealService;

@Controller
public class CommunityController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CommunityService communityService;
	
	@Autowired
	DealService dealService;
	
	// 커뮤니티 홈 페이지
	@RequestMapping("/community/main")
	public String communityHome() {
		return "thymeleaf/fo/community/community_home";
	}
	
	// 커뮤니티 자랑하기 상세 페이지
	@RequestMapping("/community/showingOffDetail")
	public ModelAndView showingOffDetail(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/othermem_mypage_showingoff_detailpage");
		// 자랑하기 상세 정보
		Map<String, Object> showOffDtl = communityService.showingOffDetail(param);
		// 해당 작성자의 다른 커뮤니티 정보
		List<Map<String, Object>> otherComt = communityService.writerOtherComt(param);
		// 해당 작품 판매 상태 가져오기
		Map<String, Object> dealProgress = communityService.searchDealProgress(param);
		Map<String, Object> result = new HashMap<>();

		// 판매중인 작품이 아닐 경우 작품 정보만 출력
		if(dealProgress == null) {
			// 작품 상세 정보
			result = dealService.workDetail((String) param.get("workSq"));
			result.put("deal", null);
		} else { // 판매중이거나 거래종료인 경우 거래 관련 정보도 출력
			// 거래 상태 코드
			String dealSttsCd = (String) dealProgress.get("dealSttsCd");
			String dealSq = String.valueOf(dealProgress.get("dealSq"));
			
			switch(dealSttsCd) {
			case "TP": // 거래진행중
				result = dealService.dealDetail(dealSq);
				result.put("work", null);
				break;
			case "TC": case "PD": case "DS": case "DC": case "PC": // 거래종료
				result = dealService.soldoutDetail(dealSq);
				result.put("deal", null);
				break;
			}
		}
		
		mv.addObject("showOffDtl", showOffDtl);
		mv.addObject("otherComt", otherComt);
		mv.addObject("dealProgress", dealProgress);
		mv.addObject("result", result);
		
		return mv;
	}
	
	// 커뮤니티 홈 목록 조회
	@RequestMapping("/community/searchHomeList")
	@ResponseBody
	public ModelAndView searchHomeList() {
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> result = communityService.searchHomeList();
		mv.addObject("result", result);
		return mv;
	}
	
	// 커뮤니티 이벤트 메인 페이지
	@RequestMapping("/community/event")
	public String communityEvent() {
		return "thymeleaf/fo/community/community_event";
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
		
	// 커뮤니티 리스트 데이터 조회 
	@RequestMapping("/community/communityListData")
	@ResponseBody
	public ModelAndView communityListData(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		
		if(null != param.get("offset")) {
			param.put("offset", Integer.parseInt(param.get("offset").toString()));
			param.put("limit", Integer.parseInt(param.get("limit").toString()));
		}
		
		List<Map<String, Object>> result = communityService.communityListData(param);
		
		// 커뮤니티 총개수 들고오기 
		Map<String, Object> totalCount = communityService.getCommunityTotalCount(param);

		mv.addObject("result", result);
		mv.addObject("totalCount", totalCount);

		return mv;
	}
	
	// 전시후기/소개 리스트 페이지
	@RequestMapping("/community/exhintList")
	public String communityExhintListPage() {
		return "thymeleaf/fo/community/community_exhint";
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
	public String communityKnowhowListPage() {
		return "thymeleaf/fo/community/community_issue";
	}
	
	// 작품/ 자랑하기 상세페이지
	@RequestMapping("/community/workDetail")
	@ResponseBody
	public ModelAndView communityWorkDetailPage(@RequestParam String comtSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/othermem_mypage_showingoff_detailpage");
		
		// 조회해서 결과값 리턴해주기
		
		return mv;
	}
	
	// 전시후기/소개 상세페이지
	@RequestMapping("/community/exhibitDetail")
	@ResponseBody
	public ModelAndView communityExhibitDetailPage(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/othermem_mypage_exhint_detailpage");

		Map<String, Object> exhibit = communityService.communityExhKnoDetail((String) param.get("comtSq"));
		mv.addObject("exhibit", exhibit);
		
		// 해당 작성자의 다른 커뮤니티 정보
		List<Map<String, Object>> otherComt = communityService.writerOtherComt(param);
		mv.addObject("otherComt", otherComt);
		
		return mv;
	}
	
	// 노하우 상세페이지
	@RequestMapping("/community/knowhowDetail")
	@ResponseBody
	public ModelAndView communityKnowhowDetailPage(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/othermem_mypage_knowhow_detailpage");
		
		Map<String, Object> knowhow = communityService.communityExhKnoDetail((String) param.get("comtSq"));
		mv.addObject("knowhow", knowhow);
		
		// 해당 작성자의 다른 커뮤니티 정보
		List<Map<String, Object>> otherComt = communityService.writerOtherComt(param);
		mv.addObject("otherComt", otherComt);
		
		return mv;
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
		
		int result = communityService.communityFollow(param);
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
		
		mv.addObject("comments", comments);
		mv.addObject("replys", replys);
		
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
	
}
