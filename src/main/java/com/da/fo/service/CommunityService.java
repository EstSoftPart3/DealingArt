package com.da.fo.service;

import java.util.List;
import java.util.Map;

public interface CommunityService {
	
	public Map<String, Object> searchHomeList();
	
	public Map<String, Object> showingOffDetail(Map<String, Object> param);
	
	public Map<String, Object> searchEventList(Map<String, Object> param);
	
	/*
	 * 댓글, 대댓글 조회
	 */
	public Map<String, Object> searchCmtsList(Map<String, Object> param);
	
	/*
	 * 커뮤니티 자랑하기 리스트 조회
	 * param : 
	 * return : 
	 */
	public List<Map<String, Object>> communityListData(Map<String, Object> param);
	
	/*
	 * 커뮤니티 페이지 총 개수 가져오기
	 * param : 
	 * return : 
	 */
	public Map<String, Object> getCommunityTotalCount(Map<String, Object> param);
	
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
