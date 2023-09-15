package com.da.bo.service;

import java.util.HashMap;
import java.util.List;
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
	
	/* 게시판 관리 공지글 등록 */
	public int insertCommunityManagementNotice(Map<String, Object> param) {
		return communityManagementDao.insertCommunityManagementNotice(param);
	}
	
	//게시물 관리 게시판 조회
	@Override
	public Map<String, Object> searchAllBoardList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = communityManagementDao.searchAllBoardList(param);
		
		return result;
	}
	
	//댓글 게시물 리스트 댓글 조회
	@Override
	public Map<String, Object> searchAllReplyList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = communityManagementDao.searchAllReplyList(param);
		
		return result;
	}
	
	//새창 댓글 리스트
	@Override
	public List<Map<String, Object>> boardAllCmtsList(Object param){
		
		return communityManagementDao.boardAllCmtsList(param);
	}
	
	
	//신고된 게시물 조회
	@Override
	public Map<String, Object> searchAllRprtList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = communityManagementDao.searchAllRprtList(param);
		
		return result;
	}
	
	//전체 게시물 상태 업데이트
	@Override
	public int boardStatusUpdate(String statusType, String comtSqList){
		
		return communityManagementDao.boardStatusUpdate(statusType, comtSqList);
	}
	//신고된 게시물 상태 업데이트
	@Override
	public int rprtStatusUpdate(String statusType, String rprtSqList){
		
		return communityManagementDao.rprtStatusUpdate(statusType, rprtSqList);
	}
	
	//댓글 숨김 상태 변경
	@Override
	public int updateReplyState(String state, int cmtSq) {
		return communityManagementDao.updateReplyState(state, cmtSq);
	}
	
	//뎃글 삭제 상태 변경
	@Override
	public int deleteReplyState(String state, int cmtSq) {
		return communityManagementDao.deleteReplyState(state, cmtSq);
	}
	
	//대댓글 숨김 상태 변경
	@Override
	public int updateReReplyState(String state, int replySq) {		
		return communityManagementDao.updateReReplyState(state, replySq);
	}
	
	//대댓글 삭제 상태 변경
	@Override
	public int deleteReReplyState(String state, int replySq) {
		return communityManagementDao.deleteReReplyState(state, replySq);
	}
	
}
