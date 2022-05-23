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
	
	/**
	 * 공지사항,FAQ ServiceImpl
	 * 
	 * **/	
	
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
	
	/**
	 * 메거진 ServiceImpl
	 * 
	 * **/
	
	//메거진 목록
	@Override
	public Map<String, Object> magazineList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = boardDao.magazineList(param);
		
		return result;
	}
	
	//메거진 입력
	@Override
	public void magazineInsert(Map<String, Object> param){
		boardDao.magazineInsert(param);
	}
	
	//메거진 상세
	@Override
	public Map<String, Object> magazineDetail(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = boardDao.magazineDetail(param);
		
		return result;
	}
		
	//메거진 삭제
	@Override
	public void magazineDelete(Map<String, Object> param){
		boardDao.magazineDelete(param);
	}
	
	//메거진 수정
	@Override
	public void magazineUpdate(Map<String, Object> param){
		boardDao.magazineUpdate(param);
	}
	
	/**
	 * CK에디터 통합 ServiceImpl
	 * 
	 * **/
	
	//CK에디터 통합 목록
	@Override
	public Map<String, Object> ckeditorList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = boardDao.ckeditorList(param);
		
		return result;
	}
	
	//CK에디터 통합 입력
	@Override
	public void ckeditorInsert(Map<String, Object> param){
		boardDao.ckeditorInsert(param);
	}
	
	//CK에디터 통합 상세
	@Override
	public Map<String, Object> ckeditorDetail(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = boardDao.ckeditorDetail(param);
		
		return result;
	}
		
	//CK에디터 통합 삭제
	@Override
	public void ckeditorDelete(Map<String, Object> param){
		boardDao.ckeditorDelete(param);
	}
	
	//CK에디터 통합 수정
	@Override
	public void ckeditorUpdate(Map<String, Object> param){
		boardDao.ckeditorUpdate(param);
	}	
	
}
