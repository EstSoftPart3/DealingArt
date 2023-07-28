package com.da.bo.event;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 임시로 만든 컨트롤러. 페이지만 연결시켜놓음. 나중에 삭제 예정
@Controller
public class TempController {

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
	public String othermem_mypage_exhint_detailpage() {
		return "thymeleaf/fo/myPage/othermem_mypage_exhint_detailpage";
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
	
}
