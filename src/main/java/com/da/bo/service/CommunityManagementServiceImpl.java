package com.da.bo.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.bo.dao.CommunityManagementDao;

@Service
public class CommunityManagementServiceImpl implements CommunityManagementService{
	
	@Autowired
	CommunityManagementDao communityManagementDao;
	
	//게시판 관리 목록 조회
	@Override
	public Map<String, Object> communityManagementList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = communityManagementDao.communityManagementList(param);
		
		return result;
	}

	//게시판 관리 상세 조회
	@Override
	public Map<String, Object> communityManagementDtlList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = communityManagementDao.communityManagementDtlList(param);
		
		return result;
	}
	
	//게시판 관리 정보 저장
	@Override
	public int communityManagementSave(Map<String, Object> param){
		int result = -1;
		result = communityManagementDao.communityManagementSave(param);
		
		return result;
	}
	
	//게시물 관리 게시판 조회
	@Override
	public Map<String, Object> boardListData(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = communityManagementDao.boardList(param);
		
		return result;
	}
}
