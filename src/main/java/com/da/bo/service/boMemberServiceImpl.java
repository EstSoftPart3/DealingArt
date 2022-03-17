package com.da.bo.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.da.bo.dao.boMemberDao;
import lombok.AllArgsConstructor;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class boMemberServiceImpl implements boMemberService {
	
	@Autowired
	boMemberDao boMemberDao;
	
	//회원정보 목록
	@Override
	public Map<String, Object> memberList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = boMemberDao.memberList(param);
		
		return result;
	}
		
	//회원정보 상세
	@Override
	public Map<String, Object> memberContent(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = boMemberDao.memberContent(param);
		
		return result;
	}
	
	
	//회원정보 아이디.닉네임 중복 체크
	@Override
	public Map<String, Object> memberCheck(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = boMemberDao.memberCheck(param);
		
		return result;
	}
	
	//회원정보 입력
	@Override
	public void memberInsert(Map<String, Object> param){
		boMemberDao.memberInsert(param);
	}
	
	@Override
	public void memberUpdate(Map<String, Object> param){
		boMemberDao.memberUpdate(param);
	}
}
