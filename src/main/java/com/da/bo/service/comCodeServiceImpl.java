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
	
	//공통코드 수정
	@Override
	public int comCodeUpdate(Map<String, Object> param) {
		
		int resultState = -1;
		
		resultState = comCodeDao.comCodeUpdate(param);
				
		return resultState;
	}
	
	//공통코드 삭제
	@Override
	public int comCodeDelete(Map<String, Object> param) {
		
		int resultState = -1;
		
		resultState = comCodeDao.comCodeDelete(param);
				
		return resultState;
	}
	
	
	//공통 서브코드 리스트
	@Override
	public Map<String, Object> comSubCodeList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = comCodeDao.comSubCodeList(param);
		
		return result;
		
	}
	
	//공통 서브코드 입력
	@Override
	public int comSubCodeInsert(Map<String, Object> param) {
		
		int resultState = -1;
		
		resultState = comCodeDao.comSubCodeInsert(param);
				
		return resultState;
	}
	
	//공통코드 수정
	@Override
	public int comSubCodeUpdate(Map<String, Object> param) {
		
		int resultState = -1;
		
		resultState = comCodeDao.comSubCodeUpdate(param);
				
		return resultState;
	}
		

}
