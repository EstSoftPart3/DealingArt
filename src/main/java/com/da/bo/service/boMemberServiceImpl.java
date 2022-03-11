package com.da.bo.service;

import java.util.HashMap;
import java.util.Map;
import com.da.bo.dao.boMemberDao;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class boMemberServiceImpl implements boMemberService {
	
	@Autowired
	boMemberDao boMemberDao;
	
	@Override
	public Map<String, Object> memberList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = boMemberDao.memberList(param);
		
		return result;
	}
}
