package com.da.bo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.MainMapper;
import com.da.mapper.bannerMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class bannerDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	JPAQueryFactory queryFactory; // QueryDsl을 사용하기 위해

	@Autowired
	bannerMapper bannerMapper;
	@Autowired
	MainMapper mainMapper;

	// 배너 목록
	public Map<String, Object> bannerList(Map<String, Object> param) {

		Map<String, Object> result = new HashMap<>();

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> boardInfo = bannerMapper.bannerList(param);

		result.put("boardInfo", boardInfo);

		return result;
	}

	// 배너 등록
	public int bannerInsert(Map<String, Object> param) {

		System.out.println("DATA = " + param);
		return bannerMapper.bannerInsert(param);

	}	
	//배너 삭제
	public int bannerDelete(String param) {
		System.out.println("DATA = " + param);			
		return bannerMapper.bannerDelete(param);	
	
	}
	//이벤트프로모션리스트
	public Map<String, Object> eventProList(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<>();

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> eventProInfo = bannerMapper.eventProList(param);

		result.put("eventProInfo", eventProInfo);

		return result;
	}
	



}