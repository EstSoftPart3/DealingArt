package com.da.fo.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.DealMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class DealDao {
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	DealMapper dealMapper;
	
	/*
	 * 딜 페이지에서 검색 필터별로 검색 결과를 조회한다.
	 * param : searchOption
	 * return : 검색 결과
	 */
	public Map<String, Object> dealSerach(Map<String, Object> searchOptions){
		Map<String, Object> param = new HashMap<>();
		String dealTypCds = (String) searchOptions.get("searchOptions");
		param.put("dealTypCds", dealTypCds);
		System.out.println("################ param : " + param);
		Map<String, Object> result = dealMapper.dealSerach(param);
		return result;
	}
}
