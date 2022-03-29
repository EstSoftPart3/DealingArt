package com.da.bo.service;

import java.util.HashMap;
import java.util.Map;
import com.da.bo.dao.comCodeDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class comCodeServiceImpl implements comCodeService {
	
	@Autowired
	comCodeDao comCodeDao;
	
	//공통코드 리스트
	@Override
	public Map<String, Object> comCodeList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = comCodeDao.comCodeList(param);
		
		return result;
		
	}
	
	//공통코드 입력
	@Override
	public int comCodeInsert(Map<String, Object> param) {
		
		int resultState = -1;
		
		resultState = comCodeDao.comCodeInsert(param);
				
		return resultState;
	}

}
