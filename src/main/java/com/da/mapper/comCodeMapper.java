package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface comCodeMapper {
	
	//공통코드 리스트
	public List comCodeList(Map<String, Object> param);
	
	//공통코드 입력
	public int comCodeInsert(Map<String, Object> param);

}
