package com.da.bo.service;

import java.util.Map;

public interface CommunityManagementService {
	
	//게시판 관리 목록 조회
	public Map<String, Object> communityManagementList(Map<String, Object> param);
	
	//게시판 관리 상세 조회
	public Map<String, Object> communityManagementDtlList(Map<String, Object> param);
	
	//게시판 관리 정보 저장
	public int communityManagementSave(Map<String, Object> param);
	
	//게시물 관리 게시판 조회
	public Map<String, Object> boardListData(Map<String, Object> param);
}
