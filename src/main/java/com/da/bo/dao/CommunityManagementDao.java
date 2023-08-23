package com.da.bo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.CommunityManagementMapper;
import com.da.util.CommonService;

@Repository
public class CommunityManagementDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private CommunityManagementMapper communityManagementMapper;
	
	//게시판 관리 목록 조회
	public Map<String, Object> communityManagementList(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<>();
		
		List<Map<String, Object>> workList = communityManagementMapper.communityManagementList(param);
		
		result.put("list", workList);
				
		return result;
	}

	//게시판 관리 상세 조회
	public Map<String, Object> communityManagementDtlList(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<>();
		
		Map<String, Object> dtlList = communityManagementMapper.communityManagementDtlList(param);
		
		result.put("dtlList", dtlList);
				
		return result;
	}
	
	//게시판 관리 정보 저장
	public int communityManagementSave(Map<String, Object> param) {
		return communityManagementMapper.communityManagementSave(param);
	}
	
	/* 게시판 관리 공지글 등록 */
	public int insertCommunityManagementNotice(Map<String, Object> param) {
		return communityManagementMapper.insertCommunityManagementNotice(param);
	}
	
	//게시물 목록
	public Map<String, Object> searchAllBoardList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> boardInfo = communityManagementMapper.searchAllBoardList(param);
		
		//Map데이터를 List에 삽입
		
		 for(int z=0; z<boardInfo.size(); z++){
			 String mbrIdDecrypt = (String) boardInfo.get(z).get("mbrId");	
			
			//아이디 복호화
			 mbrIdDecrypt = commonService.decrypt(mbrIdDecrypt);
			 
			 boardInfo.get(z).put("mbrId", mbrIdDecrypt);
		  }
		
		result.put("boardInfo", boardInfo);
				
		return result;
	}
	//댓글 목록
	public Map<String, Object> searchAllReplyList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> boardInfo = communityManagementMapper.searchAllBoardList(param);
		
		//Map데이터를 List에 삽입
		
		 for(int z=0; z<boardInfo.size(); z++){
			 String mbrIdDecrypt = (String) boardInfo.get(z).get("mbrId");	
			
			//아이디 복호화
			 mbrIdDecrypt = commonService.decrypt(mbrIdDecrypt);
			 
			 boardInfo.get(z).put("mbrId", mbrIdDecrypt);
		  }
		
		result.put("boardInfo", boardInfo);
				
		return result;
	}
	
	//신고된 게시물 목록
	public Map<String, Object> searchAllRprtList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> boardInfo = communityManagementMapper.searchAllRprtList(param);
		
		
		result.put("boardInfo", boardInfo);
				
		return result;
	}
	//전체 게시물 상태 변경
    public int boardStatusUpdate(String statusType, String comtSqList) {
    	

        return communityManagementMapper.boardStatusUpdate(statusType, comtSqList);
    }
    //신고된 게시물 상태 변경
    public int rprtStatusUpdate(String statusType, String rprtSqList) {

        return communityManagementMapper.rprtStatusUpdate(statusType, rprtSqList);
    }
    
    

}
