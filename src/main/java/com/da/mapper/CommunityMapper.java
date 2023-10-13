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
	public Map<String, Object> searchShowingOffDetail(Map<String, Object> param);
	
	/*
	 * 커뮤니티 이벤트 리스트 조회
	 */
	public List<Map<String, Object>> searchEventList(Map<String, Object> param);
	
	/*
	 * 커뮤니티 홈 배너 조회
	 */
	public Map<String, Object> searchHomeBnnList(String bnnDivCd);
	
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
	 * 커뮤니티 팔로우되어 있는지 확인하기
	 * param : 
	 * return : 
	 */
	public int findFollow(Map<String, Object> param);
	
	/*
	 * 커뮤니티 팔로우 삭제하기
	 * param : 
	 * return : 
	 */
	public int delFollow(Map<String, Object> param);
	
	/*
	 * 커뮤니티 팔로우하기
	 * param : 
	 * return : 
	 */
	public int insertFollow(Map<String, Object> param);
	
	/*
	 * 커뮤니티 팔로우되어 있는지 확인하기 (새로운 데이터베이스 사용)
	 * param : 
	 * return : 
	 */
	public int findNewFollow(Map<String, Object> param);
	
	/*
	 * 커뮤니티 팔로우 삭제하기 (새로운 데이터베이스 사용)
	 * param : 
	 * return : 
	 */
	public int delNewFollow(Map<String, Object> param);
	
	/*
	 * 커뮤니티 팔로우하기 (새로운 데이터베이스 사용)
	 * param : 
	 * return : 
	 */
	public int insertNewFollow(Map<String, Object> param);
	
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
	 * 작품 키워드 조회
	 * param :
	 * return :
	 */
	public Map<String, Object> searchWorkKeywrd(Map<String, Object> param);
	
	/*
	 * 댓글 수정
	 * param :
	 * return :
	 */
	public int modComment(Map<String, Object> param);
	
	/*
	 * 대댓글 수정
	 * param :
	 * return :
	 */
	public int modReply(Map<String, Object> param);
	
	/*
	 * 커뮤니티 댓글수 업데이트
	 * param :
	 * return :
	 */
	public int updateCmtCnt(Map<String, Object> param);
	
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
	
	
	// 좋아요 갯수 증가
	public void updateComtLikes(Object param);
}
