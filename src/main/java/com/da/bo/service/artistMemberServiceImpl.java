package com.da.bo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.bo.dao.artistMemberDao;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class artistMemberServiceImpl implements artistMemberService{
	
	@Autowired
	artistMemberDao artistMemberDao;
	
	//작가회원정보
	@Override
	public Map<String, Object> artistMemberInfo(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = artistMemberDao.artistMemberInfo(param);
		
		return result;
	}
	
	//작가회원등록
	@Override
	public int artistMemberInsert(Map<String, Object> param) {
		
		int resultState = -1;
		
		//작가회원 입력확인
		int artistMemberInfoCount = artistMemberDao.artistMemberInfoCount(param);
		//입력이 되어있다면 수정 
		if(artistMemberInfoCount > 0) {
			resultState = artistMemberDao.artistMemberUpdate(param);
		} else {
		//입력이 안되어있다면 추가	
			resultState = artistMemberDao.artistMemberInsert(param);
		}
		
		return resultState;
	}

} 
