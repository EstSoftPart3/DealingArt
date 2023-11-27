package com.da.fo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.fo.dao.CommunityDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	CommunityDao communityDao;

	/*
	 * 커뮤니티 홈 목록 조회
	 */
	
	/*
	 * @Override public Map<String, Object> searchHomeList() {
	 * 
	 * return communityDao.searchHomeList(); }
	 */
	  

	@Override
	public Map<String, Object> selectBigBnn() {
		 
		Map<String, Object> result = communityDao.selectBigBnn();
		return result;
	}

	  
	@Override
	public Map<String, Object> mainPop() {
		
	    
	    Map<String, Object> result = communityDao.mainPop();
	    return result;
		  
	}

	@Override
	public Map<String, Object> mainBoast() {
		
		Map<String, Object> result = communityDao.mainBoast();
	    return result;
	}

	@Override
	public Map<String, Object> mainExhibit() {
		Map<String, Object> result = communityDao.mainExhibit();
	    return result;
	}

	@Override
	public Map<String, Object> mainIssue() {
		Map<String, Object> result = communityDao.mainIssue();
	    return result;
	}
	
	/*
	 * 자랑하기 상세
	 */
	@Override
	public Map<String, Object> searchShowingOffDetail(Map<String, Object> param) {
		return communityDao.searchShowingOffDetail(param);
	}

	/*
	 * 커뮤니티 이벤트 리스트 조회
	 */
	@Override
	public Map<String, Object> searchEventList(Map<String, Object> param) {
		return communityDao.searchEventList(param);
	}

	/*
	 * 커뮤니티 자랑하기 리스트 조회
	 * param : 
	 * return : 
	 */
	@Override
	public List<Map<String, Object>> communityListData(Map<String, Object> param) {
		List<Map<String, Object>> result = communityDao.communityWorksListData(param);
		return result;
	}

	/*
	 * 커뮤니티 페이지 총 개수 가져오기
	 * param : 
	 * return : 
	 */
	@Override
	public Map<String, Object> getCommunityTotalCount(Map<String, Object> param){
		Map<String, Object> totalCount = communityDao.getCommunityTotalCount(param);
		return totalCount;
	}
	
	/*
	 * 커뮤니티 전시후시/소개 공통코드 들고오기
	 * param : 
	 * return : 
	 */
	@Override
	public List<Map<String, Object>> getDtlCdNm(String cdSq) {
		List<Map<String, Object>> result = communityDao.getDtlCdNm(cdSq);
		return result;
	}
	
	/*
	 * 커뮤니티 전시후시/소개, 노하우 상세 정보 들고오기 
	 * param : 
	 * return : 
	 */
	public Map<String, Object> communityExhKnoDetail(String comtSq){
		Map<String, Object> result = communityDao.communityExhKnoDetail(comtSq);
		return result;
	}
	
	/*
	 * 커뮤니티 전시후시/소개, 노하우 상세페이지에서 작성자의 다른 글 들고오기 
	 * param : 
	 * return : 
	 */
	public List<Map<String, Object>> writerOtherComt(Map<String, Object> param){
		List<Map<String, Object>> result = communityDao.writerOtherComt(param);
		return result;
	}
	
	/*
	 * 커뮤니티 댓글 가져오기
	 * param : 
	 * return : 
	 */
	public List<Map<String, Object>> communityComment(Map<String, Object> param){
		List<Map<String, Object>> result = communityDao.communityComment(param);
		return result;
	}
	
	/*
	 * 커뮤니티 대댓글 가져오기
	 * param : 
	 * return : 
	 */
	public List<Map<String, Object>> communityReply(Map<String, Object> param){
		List<Map<String, Object>> result = communityDao.communityReply(param);
		return result;
	}
	
	/*
	 * 커뮤니티 댓글, 대댓글 삭제하기
	 * param : 
	 * return : 
	 */
	public int delCommentAndReply(Map<String, Object> param) {
		
		int result = communityDao.delCommentAndReply(param);

		String commentType = param.get("commentType").toString();
		if(commentType.equals("cmt")) {
			
			// 댓글을 삭제한거면 대댓글 삭제해주기 
			param.put("commentType", "autoDelReply");
			result += communityDao.delCommentAndReply(param);
		}
		
		return result;
	}
	
	/*
	 * 커뮤니티 팔로우하기, 팔로우 취소하기
	 * param : 
	 * return : 
	 */
	public int communityFollow(Map<String, Object> param) {
		// 팔로우되어 있는지 확인하기 
		int result = communityDao.findFollow(param);
		
		if(result > 0) {
			// 조회가 되면 팔로우 취소 
			result = communityDao.delFollow(param);
			
		} else {
			// 조회 안되면 팔로우하기
			result = communityDao.insertFollow(param);
		}
		return result;
	}
	
	/*
	 * 커뮤니티 팔로우하기, 팔로우 취소하기 (새로운 데이터베이스 사용)
	 * param : 
	 * return : 
	 */
	public int communityNewFollow(Map<String, Object> param) {
		// 팔로우되어 있는지 확인하기 
		int result = communityDao.findNewFollow(param);
		
		if(result > 0) {
			// 조회가 되면 팔로우 취소 
			result = communityDao.delNewFollow(param);
			
		} else {
			// 조회 안되면 팔로우하기
			result = communityDao.insertNewFollow(param);
		}
		return result;
	}
	
	/*
	 * 댓글 등록
	 * param :
	 * return :
	 */
	public int comtReg(Map<String, Object> param) {
		return communityDao.comtReg(param);
	}

	/*
	 * 해당 상품의 판매 상태 확인
	 * param :
	 * return :
	 */
	public Map<String, Object> searchDealStatus(Map<String, Object> param) {
		return communityDao.searchDealStatus(param);
	}
	
	/*
	 * 대댓글 등록
	 * param :
	 * return :
	 */
	public int replyReg(Map<String, Object> param) {
		return communityDao.replyReg(param);
	}
	
	/*
	 * 댓글, 대댓글 수정
	 * param :
	 * return :
	 */
	public int modCommentAndReply(Map<String, Object> param) {
		return communityDao.modCommentAndReply(param);
	}
	
	/*
	 * 커뮤니티 팔로우하기, 팔로우 취소하기
	 * param : 
	 * return : 
	 */
	public int followCheck(Map<String, Object> param) {
		// 팔로우되어 있는지 확인하기 
		int result = communityDao.findNewFollow(param);
		return result;
	}
	
	/*
	 * 판매 제안하기 or 요청하기 등록
	 * param :
	 * return :
	 */
	public int insertComtRequest(Map<String, Object> param) {
		return communityDao.insertComtRequest(param);
	}
	
	/*
	 * 커뮤니티 상세 오픈여부/삭제여부 확인
	 * param : comtSq
	 * return : useYn, delYn
	 */
	public Map<String, Object> comtOpenDelYnCheck(String param){
		return communityDao.comtOpenDelYnCheck(param);
	}
	
	//커뮤니티 조회수 증가
	public void updateComtViews(Object param){
		communityDao.updateComtViews(param);
	}
	
	//커뮤니티 좋아요 갯수 증가
	public void updateComtLikes(Object param){
		communityDao.updateComtLikes(param);
	}
	
	/*
	 * 커뮤니티 권한 조회
	 * param : boardCode
	 * return : 
	 */
	public List<Map<String, Object>> selectBoardAuth(String param){
		List<Map<String, Object>> result = communityDao.selectBoardAuth(param);
		return result;
	}
	
	/*
	 * 커뮤니티 권한 조회
	 * param : boardCode
	 * return : 
	 */
	public Map<String, Object> selectnoti(Map<String, Object> param){
		Map<String, Object> result = communityDao.selectnoti(param);
		return result;
	}
 

}
