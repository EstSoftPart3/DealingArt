package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface NotiMapper {
	
	//보냄 히스토리 등록
	public int notiInsert(Map<String, Object> param);
		
	//보냄 히스토리 리스트
	public List notiSelect(Map<String, Object> param);
	
	//보냄 히스토리 카운터
	public int notiCount(Map<String, Object> param);
}
