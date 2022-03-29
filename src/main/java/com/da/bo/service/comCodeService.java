package com.da.bo.service;

import java.util.Map;

public interface comCodeService {
	
	
	//공통코드 리스트
	public Map<String, Object> comCodeList(Map<String, Object> param);
	
	//공통코드 입력
	public int comCodeInsert(Map<String, Object> param);	

}
