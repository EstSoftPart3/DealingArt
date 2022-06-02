package com.da.fo.service;

import java.util.Map;

public interface NotiService {
	
	//보냄 히스토리 등록
	public int notiInsert(Map<String, Object> param);
	
	
	//보냄 히스토리
	public Map<String, Object> notiSelect(Map<String, Object> param);
	
	

}
