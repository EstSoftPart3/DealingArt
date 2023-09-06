package com.da.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CommunityManagementMapper {
	
	/* 게시판 관리 목록 조회 */
	public List communityManagementList(Object param);
	
	/* 게시판 관리 목록 조회 */
	public Map communityManagementDtlList(Object param);
	
	/* 게시판 관리 정보 저장 */
	public int communityManagementSave(Object param);
	
	/* 게시판 관리 공지글 등록 */
	public int insertCommunityManagementNotice(Map<String, Object> param);
	
	//게시물 목록 boardList였음
	public List searchAllBoardList(Map<String, Object> param);
	
	//게시물 상태 변경
	public int boardStatusUpdate(@Param("statusType")String statusType, @Param("comtSq")String comtSqList);
	
	//전체 댓글 게시물 리스트
	public List searchAllReplyList(Map<String, Object> param);
	
	//전체 댓글 리스트
	public List boardCmtsList(Object param);
	
	//전체 대댓글 리스트
	public List boardReplysList(Object param);
	
	//신고된 게시물 리스트
	public List searchAllRprtList(Map<String, Object> param);
	
	//신고된 게시물 상태 변경
	public int rprtStatusUpdate(@Param("statusType")String statusType, @Param("rprtSq")String rprtSqList);
	
	

}
