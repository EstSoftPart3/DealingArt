package com.da.bo.service;

import java.util.Map;

public interface comCodeService {
	
	
	//공통코드 리스트
	public Map<String, Object> comCodeList(Map<String, Object> param);
	
	//공통코드 입력
	public int comCodeInsert(Map<String, Object> param);	
	
	//공통코드 수정
	public int comCodeUpdate(Map<String, Object> param);
	
	//공통코드 삭제
	public int comCodeDelete(Map<String, Object> param);
	
	//공통 서브코드 리스트
	public Map<String, Object> comSubCodeList(Map<String, Object> param);
	
	//공통 서브코드 입력
	public int comSubCodeInsert(Map<String, Object> param);
	
	//공통 서브코드 수정
	public int comSubCodeUpdate(Map<String, Object> param);

}
