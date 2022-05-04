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
	
	//공통코드 입력
	public int comCodeInsert(Map<String, Object> param){
		return comCodeMapper.comCodeInsert(param);
	}
		
	//공통코드 수정
	public int comCodeUpdate(Map<String, Object> param){
		return comCodeMapper.comCodeUpdate(param);
	}
	
	//공통코드 삭제
	public int comCodeDelete(Map<String, Object> param){
		return comCodeMapper.comCodeDelete(param);
	}
		
	//공통서브코드 리스트
	public Map<String, Object> comSubCodeList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> comSubCodeListData = comCodeMapper.comSubCodeList(param);
		
		result.put("comSubCodeListData", comSubCodeListData);
		
		return result;
	}
	
	//공통 서브코드 입력
	public int comSubCodeInsert(Map<String, Object> param){
		return comCodeMapper.comSubCodeInsert(param);
	}
	
	//공통 서브코드 수정
	public int comSubCodeUpdate(Map<String, Object> param){
		return comCodeMapper.comSubCodeUpdate(param);
	}
	
	//공통 서브코드 삭제
	public int comSubCodeDelete(Map<String, Object> param){
		return comCodeMapper.comSubCodeDelete(param);
	}
	
}
