package com.da.mapper;
import java.util.List;
import java.util.Map;

public interface bannerMapper {
	
	//배너 목록
	public List bannerList(Map<String, Object> param);
	//배너 등록
	public void bannerInsert(Map<String, Object> param);
	public List openPopup(Map<String, Object> param);
	//이벤트프로모션 리스트 
	public List eventProList(Map<String, Object> param);
}