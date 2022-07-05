package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface ReportMapper {
	
	/*
	 * 작품 신고 
	 * param: 신고 내용이 담긴 데이터
	 * return: int 
	 */
	public int reportInsert(Object param);


	public List reportList(Object param);
	
	
	public int reportUpdate(Map<String, Object> param);

}
