package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface CommunityManagementMapper {
	
	/* 게시판 관리 목록 조회 */
	public List communityManagementList(Object param);
	
	/* 게시판 관리 목록 조회 */
	public Map communityManagementDtlList(Object param);
	
	/* 게시판 관리 정보 저장 */
	public int communityManagementSave(Object param);
	
	/* 게시판 관리 공지글 등록 */
	public int insertCommunityManagementNotice(Map<String, Object> param);
	
	//게시판 목록
	public List boardList(Map<String, Object> param);

}
