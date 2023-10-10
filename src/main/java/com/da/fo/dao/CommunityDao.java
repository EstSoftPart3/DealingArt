package com.da.fo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.CommunityMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class CommunityDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	CommunityMapper communityMapper;
	
	/*
	 * 커뮤니티 홈 목록 조회
	 */
	public Map<String, Object> searchHomeList() {
		String BOA = "BOA"; // 자랑하기
		String EXH = "EXH"; // 전기후기/소개
		String ISS = "ISS"; // 이슈
		String EVH = "EVH"; // 이벤트
		String CMH = "CMH"; // 커뮤니티 홈
		
		Map<String, Object> result = new HashMap<>();
		
		Map<String, Object> popWrkThisWeek = communityMapper.boardManageDetail(BOA); // 이 주의 인기 작품자랑 상세 조건
		result.put("popList", communityMapper.searchHomeList(popWrkThisWeek)); // 이 주의 인기 작품자랑
		
		Map<String, Object> boastMst = communityMapper.boardManageDetail(BOA); // 자랑하기 고수 상세 조건
		result.put("boastMstList", communityMapper.searchHomeList(boastMst)); // 자랑하기 고수
		
		Map<String, Object> bestExhibit = communityMapper.boardManageDetail(EXH); // 전시후기/소개 베스트 게시물 상세 조건
		result.put("bestExhibitList", communityMapper.searchHomeList(bestExhibit)); // 전시후기/소개 베스트 게시물
		
		Map<String, Object> bestIssue = communityMapper.boardManageDetail(ISS); // 이슈 베스트 게시물 상세 조건
		result.put("bestIssueList", communityMapper.searchHomeList(bestIssue)); // 이슈 베스트 게시물
		
		Map<String, Object> bigBnn = communityMapper.searchHomeBnnList(CMH);
		result.put("bigBnn", bigBnn);
		
		Map<String, Object> eventBnn = communityMapper.searchHomeBnnList(EVH);
		result.put("eventBnn", eventBnn);
		
		return result;
	}
	
	/*
	 * 자랑하기 상세 정보
	 */
//	public Map<String, Object> searchShowingOffDetail(Map<String, Object> param) {
//		Map<String, Object> result = new HashMap<>();
//		result.put("showOff", communityMapper.searchShowingOffDetail(param));
//		result.put("workKeywrd", communityMapper.searchWorkKeywrd(param)); // 작품 키워드 (자랑하기 키워드 아님)
//		return result;
//	}
	/*
	 * 자랑하기 상세 정보
	 */
	public Map<String, Object> searchShowingOffDetail(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> showOffDtl = communityMapper.searchShowingOffDetail(param); // 자랑하기 상세 정보
		
		param.put("workSq", String.valueOf(showOffDtl.get("workSq")));
		param.put("mbrSq", String.valueOf(showOffDtl.get("mbrSq")));
		param.put("comtTypCd", String.valueOf(showOffDtl.get("comtTypCd")));
		
		Map<String, Object> dealStatus = communityMapper.searchDealStatus(param); // 해당 작품 판매 상태
		List<Map<String, Object>> otherComt = communityMapper.writerOtherComt(param); // 작성자의 다른 자랑하기 글
		Map<String, Object> workKeywrd = communityMapper.searchWorkKeywrd(param); // 작품 키워드 (자랑하기 키워드 아님)
		
		result.put("showOff", showOffDtl);
		result.put("dealStatus", dealStatus);
		result.put("otherComt", otherComt);
		result.put("workKeywrd", workKeywrd);
		
		return result;
	}
	
	/*
	 * 커뮤니티 이벤트 리스트 조회
	 */
	public Map<String, Object> searchEventList(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<>();
		param.put("pageStart", Integer.parseInt((String)param.get("pageStart")));
		param.put("pageSize", Integer.parseInt((String)param.get("pageSize")));
		List<Map<String, Object>> eventList = communityMapper.searchEventList(param);
		result.put("eventList", eventList);
		return result;
	}
	
	/*
	 * 커뮤니티 자랑하기 리스트 조회
	 * param : 
	 * return : 
	 */
	public List<Map<String, Object>> communityWorksListData(Map<String, Object> param) {
		List<Map<String, Object>> result = communityMapper.communityListData(param);
		return result;
	}
	
	/*
	 * 커뮤니티 페이지 총 개수 가져오기
	 * param : 
	 * return : 
	 */
	public Map<String, Object> getCommunityTotalCount(Map<String, Object> param){
		Map<String, Object> totalCount = communityMapper.getTotalCount(param);
		return totalCount;
	}

	/*
	 * 커뮤니티 전시후시/소개 공통코드 들고오기
	 * param : 
	 * return : 
	 */
	public List<Map<String, Object>> getDtlCdNm(String cdSq) {
		List<Map<String, Object>> result = communityMapper.getDtlCdNm(cdSq);
		return result;
	}
	
	/*
	 * 커뮤니티 전시후시/소개, 이슈 상세 정보 들고오기 
	 * param : 
	 * return : 
	 */
	public Map<String, Object> communityExhKnoDetail(String comtSq){
		Map<String, Object> result = communityMapper.communityExhKnoDetail(comtSq);
		return result;
	}
	
	/*
	 * 커뮤니티 전시후시/소개, 이슈 상세페이지에서 작성자의 다른 글 들고오기 
	 * param : 
	 * return : 
	 */
	public List<Map<String, Object>> writerOtherComt(Map<String, Object> param){
		List<Map<String, Object>> result = communityMapper.writerOtherComt(param);
		return result;
	}
	
	/*
	 * 커뮤니티 댓글 가져오기
	 * param : 
	 * return : 
	 */
	public List<Map<String, Object>> communityComment(Map<String, Object> param){
		List<Map<String, Object>> result = communityMapper.communityComment(param);
		return result;
	}
	
	/*
	 * 커뮤니티 대댓글 가져오기
	 * param : 
	 * return : 
	 */
	public List<Map<String, Object>> communityReply(Map<String, Object> param){
		List<Map<String, Object>> result = communityMapper.communityReply(param);
		return result;
	}
	
	/*
	 * 커뮤니티 댓글, 대댓글 삭제하기
	 * param : 
	 * return : 
	 */
	public int delCommentAndReply(Map<String, Object> param) {
		int result = communityMapper.delCommentAndReply(param);
		param.put("cnt", -result); // 삭제의 경우는 삭제한 갯수를 뻄
		communityMapper.updateCmtCnt(param);
		return result;
	}
	
	/*
	 * 커뮤니티 팔로우되어 있는지 확인하기
	 * param : 
	 * return : 
	 */
	public int findFollow(Map<String, Object> param) {
		int result = communityMapper.findFollow(param);
		return result;
	}
	
	/*
	 * 커뮤니티 팔로우 삭제하기
	 * param : 
	 * return : 
	 */
	public int delFollow(Map<String, Object> param) {
		int result = communityMapper.delFollow(param);
		return result;
	}
	
	/*
	 * 커뮤니티 팔로우하기
	 * param : 
	 * return : 
	 */
	public int insertFollow(Map<String, Object> param) {
		int result = communityMapper.insertFollow(param);
		return result;
	}
	
	/*
	 * 커뮤니티 팔로우되어 있는지 확인하기 (새로운 데이터베이스 사용)
	 * param : 
	 * return : 
	 */
	public int findNewFollow(Map<String, Object> param) {
		int result = communityMapper.findNewFollow(param);
		return result;
	}
	
	/*
	 * 커뮤니티 팔로우 삭제하기 (새로운 데이터베이스 사용)
	 * param : 
	 * return : 
	 */
	public int delNewFollow(Map<String, Object> param) {
		int result = communityMapper.delNewFollow(param);
		return result;
	}
	
	/*
	 * 커뮤니티 팔로우하기 (새로운 데이터베이스 사용)
	 * param : 
	 * return : 
	 */
	public int insertNewFollow(Map<String, Object> param) {
		int result = communityMapper.insertNewFollow(param);
		return result;
	}
	
	/*
	 * 댓글 등록
	 * param :
	 * return :
	 */
	public int comtReg(Map<String, Object> param) {
		int result = communityMapper.comtReg(param);
		param.put("cnt", result);
		communityMapper.updateCmtCnt(param);
		return result;
	}

	/*
	 * 해당 상품의 판매 상태 확인
	 * param :
	 * return :
	 */
	public Map<String, Object> searchDealStatus(Map<String, Object> param) {
		Map<String, Object> result = communityMapper.searchDealStatus(param);
		return result;
	}
	
	/*
	 * 대댓글 등록
	 * param :
	 * return :
	 */
	public int replyReg(Map<String, Object> param) {
		int result = communityMapper.replyReg(param);
		param.put("cnt", result);
		communityMapper.updateCmtCnt(param);
		return result;
	}
	
	/*
	 * 댓글, 대댓글 수정
	 * param :
	 * return :
	 */
	public int modCommentAndReply(Map<String, Object> param) {
		int result = communityMapper.modComment(param);
		return result;
	}
	
	/*
	 * 판매 제안하기 or 요청하기 등록
	 * param :
	 * return :
	 */
	public int insertComtRequest(Map<String, Object> param) {
		return communityMapper.insertComtRequest(param);
	}
	   
	
	/*
	 * 커뮤니티 상세 오픈여부/삭제여부 확인
	 * param : comtSq
	 * return : useYn, delYn
	 */
	public Map<String, Object> comtOpenDelYnCheck(String param){
		return communityMapper.comtOpenDelYnCheck(param);
	}
	
	//커뮤니티 조회수 증가
	public void updateComtViews(Object param){
		communityMapper.updateComtViews(param);
	}
	
}
