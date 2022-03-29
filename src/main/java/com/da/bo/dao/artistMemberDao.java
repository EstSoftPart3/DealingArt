package com.da.bo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.artistMemberMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class artistMemberDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	artistMemberMapper artistMemberMapper;
	
	//작가회원정보 상세
	public Map<String, Object> artistMemberInfo(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("ARTIST_MEMBER_INFO_PARAM = " + param);
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> artistMemberInfoData = artistMemberMapper.artistMemberInfo(param);
		
		result.put("artistMemberInfo", artistMemberInfoData);
		
		return result;
	}
	
	//작가회원정보 입력
	public int artistMemberInsert(Map<String, Object> param){
		
		System.out.println("ARTIST_MEMBER_INSERT_REQUEST = " + param);
		return artistMemberMapper.artistMemberInsert(param);
		
	}
	
	//작가회원정보 입력
	public int artistMemberUpdate(Map<String, Object> param){
		
		System.out.println("ARTIST_MEMBER_INSERT_REQUEST = " + param);
		return artistMemberMapper.artistMemberUpdate(param);
		
	}
	
	//작가정보 입력확인
	public int artistMemberInfoCount(Map<String, Object> param){
		
		System.out.println("ARTIST_MEMBER_INFO_COUNT = " + param);
		return artistMemberMapper.artistMemberInfoCount(param);
		
	}

}
