package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface CommunityMapper {

	/*
	 * 이 주의 인기 작품자랑 목록
	 * param : 
	 * return : 이 주의 인기 작품자랑 목록
	 */
	public List<Map<String, Object>> popularShowingOffThisWeek();
	
}
