package com.da.bo.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.da.fo.service.CommunityService;

// 임시로 만든 컨트롤러. 페이지만 연결시켜놓음. 나중에 삭제 예정
@Controller
public class TempController {

	@Autowired
	CommunityService communityService;
	
	// 메인 리뉴얼
	@RequestMapping("/temp/main")
	public String main() {
		return "thymeleaf/da_main";
	}
	
	// 커뮤니티 홈
	@RequestMapping("/temp/community_home")
	public String community_home() {
		return "thymeleaf/fo/community/community_home";
	}
	
	// 커뮤니티 홈 백업
	@RequestMapping("/temp/community_home_back")
	public String community_home_back() {
		return "thymeleaf/fo/community/community_home_back";
	}
	
	// 커뮤니티 작품자랑
	@RequestMapping("/temp/community_works")
	public String community_works() {
		return "thymeleaf/fo/community/community_works";
	}
	
	// 커뮤니티 전시후기/소개
	@RequestMapping("/temp/community_exhint")
	public String community_exhint() {
		return "thymeleaf/fo/community/community_exhint";
	}
	
	// 커뮤니티 이슈
	@RequestMapping("/temp/community_issue")
	public String community_issue() {
		return "thymeleaf/fo/community/community_issue";
	}
	
	// 커뮤니티 이슈 백업
	@RequestMapping("/temp/community_issue_back")
	public String community_issue_back() {
		return "thymeleaf/fo/community/community_issue_back";
	}
	
	// 커뮤니티 이벤트
	@RequestMapping("/temp/community_event")
	public String community_event() {
		return "thymeleaf/fo/community/community_event";
	}
	
	// 마이페이지 모두보기 페이지
	@RequestMapping("/temp/mypage_main")
	public String mypage_main() {
		return "thymeleaf/fo/myPage/mypage_main";
	}
	
	// 마이페이지 나의 작품 페이지
	@RequestMapping("/temp/mypage_myworks")
	public String mypage_myworks() {
		return "thymeleaf/fo/myPage/mypage_myworks";
	}
	
	// 마이페이지 자랑하기 페이지
	@RequestMapping("/temp/mypage_showingoff")
	public String mypage_showingoff() {
		return "thymeleaf/fo/myPage/mypage_showingoff";
	}
	
	// 마이페이지 전시후기/소개 페이지
	@RequestMapping("/temp/mypage_exhint")
	public String mypage_exhint() {
		return "thymeleaf/fo/myPage/mypage_exhint";
	}
	
	// 마이페이지 이슈 페이지
	@RequestMapping("/temp/mypage_issue")
	public String mypage_issue() {
		return "thymeleaf/fo/myPage/mypage_issue";
	}
	
	// 마이페이지 알림함 페이지
	@RequestMapping("/temp/mypage_notificationbox")
	public String mypage_notificationbox() {
		return "thymeleaf/fo/myPage/mypage_notificationbox";
	}
	
	// 마이페이지 스크랩 페이지
	@RequestMapping("/temp/mypage_scrap")
	public String mypage_scrap() {
		return "thymeleaf/fo/myPage/mypage_scrap";
	}
	
	// 마이페이지 팔로잉 페이지
	@RequestMapping("/temp/mypage_following")
	public String mypage_following() {
		return "thymeleaf/fo/myPage/mypage_following";
	}
	
	// 마이페이지 전시후기/소개 등록 페이지
	@RequestMapping("/temp/mypage_exhint_knowhow_page")
	public String mypage_exhint_knowhow_page() {
		return "thymeleaf/fo/myPage/mypage_exhint_knowhow_page";
	}
	
	// 마이페이지 소장품/창작품 등록 페이지
	@RequestMapping("/temp/mypage_work_regipage")
	public String mypage_work_regipage() {
		return "thymeleaf/fo/myPage/mypage_work_regipage";
	}
	
	// 타 회원 마이 페이지 자랑하기 상세 페이지
	@RequestMapping("/temp/othermem_mypage_showingoff_detailpage")
	public String othermem_mypage_showingoff_detailpage() {
		return "thymeleaf/fo/myPage/othermem_mypage_showingoff_detailpage";
	}
	
	// 타 회원 마이 페이지 전시후기/소개 상세 페이지
	@RequestMapping("/temp/othermem_mypage_exhint_detailpage")
	public ModelAndView othermem_mypage_exhint_detailpage() {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/othermem_mypage_exhint_detailpage");
		
		Map<String, Object> param = new HashMap<>();
		param.put("SqNumber", 59);
		
		Map<String, Object> exhibit = communityService.communityExhKnoDetail(String.valueOf(param.get("SqNumber")));
		mv.addObject("exhibit", exhibit);
		
		param.put("comtSq", String.valueOf(param.get("SqNumber")));
		param.put("mbrSq", String.valueOf(exhibit.get("mbrSq")));
		param.put("comtTypCd", String.valueOf(exhibit.get("comtTypCd")));
		
		// 해당 작성자의 다른 커뮤니티 정보
		List<Map<String, Object>> otherComt = communityService.writerOtherComt(param);
		mv.addObject("otherComt", otherComt);
		
		return mv;
	}
	
	// 소장품/창작품 상세 페이지(미 판매 상태)
	@RequestMapping("/temp/search__collection_creation_detailpage_notsold")
	public String search__collection_creation_detailpage_notsold() {
		return "thymeleaf/fo/myPage/search__collection_creation_detailpage_notsold";
	}
	
	// 거래 상세 페이지 (판매 상태)
	@RequestMapping("/temp/search__collection_creation_detailpage_sold")
	public String search__collection_creation_detailpage_sold() {
		return "thymeleaf/fo/myPage/search__collection_creation_detailpage_sold";
	}
	
	// (모바일) 커뮤니티 이벤트 페이지
	@RequestMapping("/temp/community_event_mo")
	public String community_event_mo() {
		return "thymeleaf/fo/community/community_event_mo";
	}
	
	// (모바일) 커뮤니티 전시후기/소개 페이지
	@RequestMapping("/temp/community_exhint_mo")
	public String community_exhint_mo() {
		return "thymeleaf/fo/community/community_exhint_mo";
	}
	
	// (모바일) 커뮤니티 홈 페이지
	@RequestMapping("/temp/community_home_mo")
	public String community_home_mo() {
		return "thymeleaf/fo/community/community_home_mo";
	}
	
	// (모바일) 커뮤니티 이슈 페이지
	@RequestMapping("/temp/community_issue_mo")
	public String community_issue_mo() {
		return "thymeleaf/fo/community/community_issue_mo";
	}
	
	// (모바일) 커뮤니티 작품자랑 페이지
	@RequestMapping("/temp/community_works_mo")
	public String community_works_mo() {
		return "thymeleaf/fo/community/community_works_mo";
	}
	
	// 매거진9 아티스트 페이지
	@RequestMapping("/temp/magazine9_artist")
	public String magazine9_artist() {
		return "thymeleaf/fo/community/magazine9_artist";
	}
	
	// 매거진9 메인 페이지
	@RequestMapping("/temp/magazine9_main")
	public String magazine9_main() {
		return "thymeleaf/fo/community/magazine9_main";
	}
	
	// (모바일) 매거진9 메인 페이지
	@RequestMapping("/temp/magazine9_main_mo")
	public String magazine9_main_mo() {
		return "thymeleaf/fo/community/magazine9_main_mo";
	}
	
	// (모바일) 전시후기/소개 등록 페이지
	@RequestMapping("/temp/mypage_exhint_knowhow_page_mo")
	public String mypage_exhint_knowhow_page_mo() {
		return "thymeleaf/fo/myPage/mypage_exhint_knowhow_page_mo";
	}
	
	// (모바일) 마이페이지 전시후기/소개 페이지
	@RequestMapping("/temp/mypage_exhint_mo")
	public String mypage_exhint_mo() {
		return "thymeleaf/fo/myPage/mypage_exhint_mo";
	}
	
	// (모바일) 마이페이지 팔로잉 페이지
	@RequestMapping("/temp/mypage_following_mo")
	public String mypage_following_mo() {
		return "thymeleaf/fo/myPage/mypage_following_mo";
	}
	
	// (모바일) 마이페이지 이슈 페이지
	@RequestMapping("/temp/mypage_issue_mo")
	public String mypage_issue_mo() {
		return "thymeleaf/fo/myPage/mypage_issue_mo";
	}
	
	// (모바일) 마이페이지 메인 페이지
	@RequestMapping("/temp/mypage_main_mo")
	public String mypage_main_mo() {
		return "thymeleaf/fo/myPage/mypage_main_mo";
	}
	
	// (모바일) 마이페이지 작품자랑 페이지
	@RequestMapping("/temp/mypage_myworks_mo")
	public String mypage_myworks_mo() {
		return "thymeleaf/fo/myPage/mypage_myworks_mo";
	}
	
	// (모바일) 마이페이지 알림함 페이지
	@RequestMapping("/temp/mypage_notificationbox_mo")
	public String mypage_notificationbox_mo() {
		return "thymeleaf/fo/myPage/mypage_notificationbox_mo";
	}
	
	// (모바일) 마이페이지 스크랩 페이지
	@RequestMapping("/temp/mypage_scrap_mo")
	public String mypage_scrap_mo() {
		return "thymeleaf/fo/myPage/mypage_scrap_mo";
	}
	
	// (모바일) 마이페이지 작품자랑 페이지
	@RequestMapping("/temp/mypage_showingoff_mo")
	public String mypage_showingoff_mo() {
		return "thymeleaf/fo/myPage/mypage_showingoff_mo";
	}
	
	// (모바일) 마이페이지 작품등록 페이지
	@RequestMapping("/temp/mypage_work_regipage_mo")
	public String mypage_work_regipage_mo() {
		return "thymeleaf/fo/myPage/mypage_work_regipage_mo";
	}
	
	// (모바일) 소장품/창작품 상세 페이지(미 판매 상태)
	@RequestMapping("/temp/search__collection_creation_detailpage_notsold_mo")
	public String search__collection_creation_detailpage_notsold_mo() {
		return "thymeleaf/fo/myPage/search__collection_creation_detailpage_notsold_mo";
	}
	
	// (모바일) 거래 상세 페이지 (판매 상태)
	@RequestMapping("/temp/search__collection_creation_detailpage_sold_mo")
	public String search__collection_creation_detailpage_sold_mo() {
		return "thymeleaf/fo/myPage/search__collection_creation_detailpage_sold_mo";
	}
}
