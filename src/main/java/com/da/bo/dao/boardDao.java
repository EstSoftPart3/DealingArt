package com.da.bo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.boardMapper;

import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class boardDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	boardMapper boardMapper;
	
	/**
	 * 공지사항,FAQ DAO
	 * 
	 * **/
	
	//게시판 목록
	public Map<String, Object> boardList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> boardInfo = boardMapper.boardList(param);
		
		result.put("boardInfo", boardInfo);
				
		return result;
	}

	//게시판 등록
	public void boardInsert(Map<String, Object> param){
		
		System.out.println("DATA = " + param);
		boardMapper.boardInsert(param);
		
	}
	
	//게시판 상세
	public Map<String, Object> boardDetail(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("DATA = " + param);
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> boardDetailData = boardMapper.boardDetail(param);
		
		result.put("boardDetailData", boardDetailData);
		
		return result;
	}
	
	//게시판 삭제
	public void boardDelete(Map<String, Object> param){
		
		System.out.println("DATA = " + param);
		boardMapper.boardDelete(param);
		
	}
	
	//게시판 수정
	public void boardUpdate(Map<String, Object> param){
		
		System.out.println("DATA = " + param);
		boardMapper.boardUpdate(param);
		
	}
	
	/**
	 * 잡지 DAO
	 * 
	 * **/
	
	//잡지 목록
	public Map<String, Object> magazineList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> magazineInfo = boardMapper.magazineList(param);
		
		result.put("magazineInfo", magazineInfo);
				
		return result;
	}

	//잡지 등록
	public void magazineInsert(Map<String, Object> param){
		
		System.out.println("DATA = " + param);
		boardMapper.magazineInsert(param);
		
	}
	
	//잡지 상세
	public Map<String, Object> magazineDetail(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("DATA = " + param);
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> magazineDetailData = boardMapper.magazineDetail(param);
		
		result.put("magazineDetailData", magazineDetailData);
		
		return result;
	}
	
	//잡지 삭제
	public void magazineDelete(Map<String, Object> param){
		
		System.out.println("DATA = " + param);
		boardMapper.magazineDelete(param);
		
	}
	
	//잡지 수정
	public void magazineUpdate(Map<String, Object> param){
		
		System.out.println("DATA = " + param);
		boardMapper.magazineUpdate(param);
		
	}
	
	
}
