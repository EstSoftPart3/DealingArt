package com.da.fo.service;

import java.util.List;
import java.util.Map;

public interface CommunityService {
	
	/*
	 * 커뮤니티 홈 목록 조회
	 */
	
	//public Map<String, Object> searchHomeList();
	
	public Map<String, Object> selectBigBnn();
	  
	public Map<String, Object> mainPop(); 

	public Map<String, Object> mainBoast();
  
	public Map<String, Object> mainExhibit();
  
	public Map<String, Object> mainIssue();
	
	
	/*
	 * 자랑하기 상세
	 */
	public Map<String, Object> searchShowingOffDetail(Map<String, Object> param);
	
	/*
	 * 커뮤니티 이벤트 리스트 조회
	 */
	public Map<String, Object> searchEventList(Map<String, Object> param);
	
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
	
	/*
	 * 커뮤니티 팔로우 (새로운 데이터베이스 사용)
	 * param : 
	 * return : 
	 */
	public int communityNewFollow(Map<String, Object> param);
	
	/*
	 * 댓글 등록
	 * param :
	 * return :
	 */
	public int comtReg(Map<String, Object> param);

	/*
	 * 해당 상품의 판매 상태 확인
	 * param :
	 * return :
	 */
	public Map<String, Object> searchDealStatus(Map<String, Object> param);
	
	/*
	 * 대댓글 등록
	 * param :
	 * return :
	 */
	public int replyReg(Map<String, Object> param);
	
	/*
	 * 댓글, 대댓글 수정
	 * param :
	 * return :
	 */
	public int modCommentAndReply(Map<String, Object> param);
	
	/*
	 * 커뮤니티 팔로우하기, 팔로우 취소하기
	 * param : 
	 * return : 
	 */
	public int followCheck(Map<String, Object> param);
	
	/*
	 * 판매 제안하기 or 요청하기 등록
	 * param :
	 * return :
	 */
	public int insertComtRequest(Map<String, Object> param);
	
	/*
	 * 커뮤니티 상세 오픈여부/삭제여부 확인
	 * param : comtSq
	 * return : useYn, delYn
	 */
	public Map<String, Object> comtOpenDelYnCheck(String param);
	
	//커뮤니티 조회수 증가
	public void updateComtViews(Object param);
	
	//커뮤니티 좋아요 갯수 증가
	public void updateComtLikes(Object param);
	
	/*
	 * 커뮤니티 권한 조회
	 * param : boardCode
	 * return : 
	 */
	public List<Map<String, Object>> selectBoardAuth(String param);
	
	/*
	 * 커뮤니티 공지 조회
	 * param : boardCode
	 * return : 
	 */
	public Map<String, Object> selectnoti(Map<String, Object> param);
 

	


 


	
}
