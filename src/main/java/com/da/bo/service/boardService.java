package com.da.bo.service;

import java.util.Map;

public interface boardService {
	
	/**
	 * 공지사항,FAQ DAO
	 * 
	 * **/
	
	//게시판 목록
	public Map<String, Object> boardList(Map<String, Object> param);
	//게시판 등록
	public void boardInsert(Map<String, Object> param);
	//게시판 상세
	public Map<String, Object> boardDetail(Map<String, Object> param);
	//게시판 삭제
	public void boardDelete(Map<String, Object> param); 
	//게시판 수정
	public void boardUpdate(Map<String, Object> param);
	
	/**
	 * 잡지 DAO
	 * 
	 * **/
	
	//게시판 목록
	public Map<String, Object> magazineList(Map<String, Object> param);
	//게시판 등록
	public void magazineInsert(Map<String, Object> param);
	//게시판 상세
	public Map<String, Object> magazineDetail(Map<String, Object> param);
	//게시판 삭제
	public void magazineDelete(Map<String, Object> param); 
	//게시판 수정
	public void magazineUpdate(Map<String, Object> param);
	
}
