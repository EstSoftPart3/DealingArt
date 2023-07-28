package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface CommunityMapper {

	/*
	 * 커뮤니티 홈 리스트 조회
	 * param : 
	 * return : 커뮤니티 홈 리스트
	 */
	public List<Map<String, Object>> searchHomeList(Map<String, Object> param);
	
	/*
	 * 게시판 관리 상세 조건 조회
	 * param: 커뮤니티 구분 코드
	 * return : 게시판 정렬 구분, 유형 조건, 조회 시작, 조회 종료 일시, 커뮤니티 구분 코드
	 */
	public Map<String, Object> boardManageDetail(String comtTypCd);
	
	/*
	 * 자랑하기 상세 정보
	 */
	public Map<String, Object> showingOffDetail(Map<String, Object> param);
	
	/*
	 * 커뮤니티 이벤트 리스트 조회
	 */
	public List<Map<String, Object>> searchEventList(Map<String, Object> param);
	
	/*
	 * 커뮤니티 홈 배너 조회
	 */
	public Map<String, Object> searchHomeBnnList(String bnnDivCd);
	
	/*
	 * 자랑하기 댓글 조회
	 */
	public List<Map<String, Object>> searchComtCmtsList(Map<String, Object> param);
	
	/*
	 * 자랑하기 대댓글 조회
	 */
	public List<Map<String, Object>> searchComtReplysList(Map<String, Object> param);
	
	/*
	 * 커뮤니티 리스트 조회
	 * param : 
	 * return : 
	 */
	public List<Map<String, Object>> communityListData(Map<String, Object> param);
	
	/*
	 * 커뮤니티 페이지 총 개수 들고오기 
	 * param : 
	 * return : 
	 */
	public Map<String, Object> getTotalCount(Map<String, Object> param);
	
	/*
	 * 커뮤니티 전시후시/소개 공통코드 들고오기
	 * param : 
	 * return : 
	 */
	public List<Map<String, Object>> getDtlCdNm(String cdSq);
	
	/*
	 * 커뮤니티 전시후시/소개, 노하우 상세 정보 들고오기 
	 * param : 
	 * return : 
	 */
	public Map<String, Object> communityExhKnoDetail(String comtSq);
}
