package com.da.fo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.CommunityMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class CommunityDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	CommunityMapper communityMapper;
	
	/*
	 * 커뮤니티 홈 목록 테스트 중
	 */
	public Map<String, Object> communityHomeList() {
		Map<String, Object> result = new HashMap<>();
		result.put("popList", communityMapper.popularShowingOffThisWeek()); // 이 주의 인기 작품자랑
		return result;
	}
	
}
