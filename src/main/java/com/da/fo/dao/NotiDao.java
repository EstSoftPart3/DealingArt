package com.da.fo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import com.da.mapper.NotiMapper;

@Repository
public class NotiDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	NotiMapper NotiMapper;
	
	//보냄 히스토리 등록
	public int notiInsert(Map<String, Object> param){
		
		int insertState = -1;
		
		insertState = NotiMapper.notiInsert(param);
		
		return insertState;
		
	}
	
	//보냄 히스토리
	public Map<String, Object> notiSelect(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		List notiList = NotiMapper.notiSelect(param);
		
		result.put("noti", notiList);
		
		return result;
	}

}
