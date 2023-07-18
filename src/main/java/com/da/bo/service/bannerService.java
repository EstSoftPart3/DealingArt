package com.da.bo.service;

import java.util.Map;

public interface bannerService {
	
	//배너리스트
	public Map<String, Object> bannerList(Map<String, Object> param);
	//배너등록
	public void bannerInsert(Map<String, Object> param);
	//팝업-메인
	//이벤트프로모션리스트
	public Map<String, Object> eventProList(Map<String, Object> param);

}
