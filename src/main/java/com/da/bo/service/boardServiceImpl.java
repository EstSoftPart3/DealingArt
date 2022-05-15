package com.da.bo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.da.bo.dao.boardDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class boardServiceImpl implements boardService {
	
	@Autowired
	boardDao boardDao;
	
	//게시판 목록
	@Override
	public Map<String, Object> boardList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = boardDao.boardList(param);
		
		return result;
	}
	
	//게시판 입력
	@Override
	public void boardInsert(Map<String, Object> param){
		boardDao.boardInsert(param);
	}
	
	//게시판 상세
	@Override
	public Map<String, Object> boardDetail(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = boardDao.boardDetail(param);
		
		return result;
	}
		
	//게시판 삭제
	@Override
	public void boardDelete(Map<String, Object> param){
		boardDao.boardDelete(param);
	}
	
	//게시판 수정
	@Override
	public void boardUpdate(Map<String, Object> param){
		boardDao.boardUpdate(param);
	}
	
}
