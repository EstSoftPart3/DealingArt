package com.da.bo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.comCodeMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;



@Repository
public class comCodeDao {
	
private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	comCodeMapper comCodeMapper;
	
	//공통코드 리스트
	public Map<String, Object> comCodeList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("COMMON_CODE_PARAM = " + param);
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> comCodeListData = comCodeMapper.comCodeList(param);
		
		result.put("comCodeListData", comCodeListData);
		
		return result;
	}
	
	//작가회원정보 입력
	public int comCodeInsert(Map<String, Object> param){
		
		System.out.println("COMMON_INSERT_REQUEST = " + param);
		
		return comCodeMapper.comCodeInsert(param);
		
	}
	
}
