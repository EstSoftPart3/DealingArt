package com.da.bo.service;

import java.util.List;
import java.util.Map;

public interface bannerService {
	
	//배너리스트
	public Map<String, Object> bannerList(Map<String, Object> param);
	//배너 등록
	public int bannerInsert(Map<String, Object> param);
	  
	//배너 삭제
	public int bannerDelete(String string);

	//이벤트프로모션리스트
	public Map<String, Object> eventProList(Map<String, Object> param);
	
	//프로모션 영역 수정
	public int promoUpdate(Map<String, Object> param);
	
	//프로모션 영역 조회
	public List<Map<String, Object>> promoDataList(Object param);

}
