package com.da.bo.service;

import java.util.Map;

public interface bannerService {
	
	//배너리스트
	public Map<String, Object> bannerList(Map<String, Object> param);
	//배너 등록
	public int bannerInsert(Map<String, Object> param);
	
	//배너 삭제
	public void bannerDelete(Map<String, Object> param);

	//이벤트프로모션리스트
	public Map<String, Object> eventProList(Map<String, Object> param);
	
	//프로모션 영역 수정
	public int promoUpdate(Map<String, Object> param);

}
