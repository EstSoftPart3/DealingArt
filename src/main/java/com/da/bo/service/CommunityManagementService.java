package com.da.bo.service;

import java.util.List;
import java.util.Map;

public interface CommunityManagementService {
	
	//게시판 관리 목록 조회
	public Map<String, Object> communityManagementList(Map<String, Object> param);
	
	//게시판 관리 상세 조회
	public Map<String, Object> communityManagementDtlList(Map<String, Object> param);
	
	//게시판 관리 정보 저장
	public int communityManagementSave(Map<String, Object> param);
	
	/* 게시판 관리 공지글 등록 */
	public int insertCommunityManagementNotice(Map<String, Object> param);
	
	//게시물 관리 게시판 조회
	public Map<String, Object> searchAllBoardList(Map<String, Object> param);
	
	//댓글 게시물 리스트
	public Map<String, Object> searchAllReplyList(Map<String, Object> param);
	
	//새창 댓글 리스트
	public List<Map<String, Object>> boardAllCmtsList(Object param);
	
	//신고된 게시물 리스트
	public Map<String, Object> searchAllRprtList(Map<String, Object> param);
	
	//게시물 상태 변경
	public int boardStatusUpdate(String statusType, String comtSqList);
	
	//신고된 게시물 상태 변경
	public int rprtStatusUpdate(String statusType, String rprtSqList);
	
	
	
}
