package com.da.mapper;
import java.util.List;
import java.util.Map;

public interface bannerMapper {
	
	//배너 목록
	public List bannerList(Map<String, Object> param);
	//배너 등록
	public int bannerInsert(Map<String, Object> param);
	//배너 삭제
	public int bannerDelete(String param);
	//팝업
	public List openPopup(Map<String, Object> param);
	//이벤트프로모션 리스트 
	public List eventProList(Map<String, Object> param);
	//프로모션 영역 수정
	public int promoUpdate(Map<String, Object> param);
	//배너목록 조회
	public int bannerSelect(Map<String, Object> param);
	
	
}
