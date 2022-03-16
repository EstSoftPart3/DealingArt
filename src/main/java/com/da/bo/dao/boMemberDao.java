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
	
	//회원정보 목록
	public Map<String, Object> memberList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("MEMBER_LIST_REQUEST = " + param);
		
		List memberList = boMemberMapper.memberList(param);
		
		result.put("memberList", memberList);
		
		return result;
	}
	
	//회원정보 상세
	public Map<String, Object> memberContent(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("MEMBER_CONTENT_REQUEST = " + param);
		
		List memberContent = boMemberMapper.memberContent(param);
		
		result.put("memberContent", memberContent);
		
		return result;
	}
	
	//회원정보 아이디.닉네임 중복 체크
	public Map<String, Object> memberCheck(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("MEMBER_CHECK_REQUEST = " + param);
		List memberCheck = boMemberMapper.memberCheck(param);
		
		result.put("memberCheck", memberCheck);
		
		return result;
	}
	
	//회원정보 입력
	public void memberInsert(Map<String, Object> param){
		
		System.out.println("MEMBER_INSERT_REQUEST = " + param);
		boMemberMapper.memberInsert(param);
		
	}
	
	//회원정보 수정
	public void memberUpdate(Map<String, Object> param){
		
		System.out.println("MEMBER_UPDATE_REQUEST = " + param);
		boMemberMapper.memberUpdate(param);
		
	}

}
