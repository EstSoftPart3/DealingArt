package com.da.bo.service;

import java.util.List;
import java.util.Map;

public interface ArtistWorkService {
	
	//작가 정보 리스트
	public Map<String, Object> artistWorkList(Map<String, Object> param);
	
	//작가 정보 상세
	public Map<String, Object> artistWorkDetail(Map<String, Object> param);

	//작가 작품 리스트
	public Map<String, Object> workList(Map<String, Object> param);
}
