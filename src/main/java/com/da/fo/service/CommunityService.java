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
	
	/*
	 * 커뮤니티 전시후시/소개, 노하우 상세페이지에서 작성자의 다른 글 들고오기 
	 * param : 
	 * return : 
	 */
	public List<Map<String, Object>> writerOtherComt(Map<String, Object> param);
	
	/*
	 * 커뮤니티 댓글 가져오기
	 * param : 
	 * return : 
	 */
	public List<Map<String, Object>> communityComment(Map<String, Object> param);
	
	/*
	 * 커뮤니티 대댓글 가져오기
	 * param : 
	 * return : 
	 */
	public List<Map<String, Object>> communityReply(Map<String, Object> param);
	
	/*
	 * 커뮤니티 댓글, 대댓글 삭제하기
	 * param : 
	 * return : 
	 */
	public int delCommentAndReply(Map<String, Object> param);
	
	/*
	 * 커뮤니티 팔로우
	 * param : 
	 * return : 
	 */
	public int communityFollow(Map<String, Object> param);
	
}
