package com.da.bo.dao;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.boMemberMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class boMemberDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	boMemberMapper boMemberMapper;
	
	public Map<String, Object> memberList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("REQUEST = " + param);
		
		List memberList = boMemberMapper.memberList(param);
		
		result.put("memberList", memberList);
		
		return result;
		
	}

}
