package com.da.bo.service;

import java.util.Map;

public interface boardService {
	
	/**
	 * 공지사항,FAQ Service Interface
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
	 * 메거진 Service Interface
	 * 
	 * **/
	
	//메거진 목록
	public Map<String, Object> magazineList(Map<String, Object> param);
	//메거진 등록
	public void magazineInsert(Map<String, Object> param);
	//메거진 상세
	public Map<String, Object> magazineDetail(Map<String, Object> param);
	//메거진 삭제
	public void magazineDelete(Map<String, Object> param); 
	//메거진 수정
	public void magazineUpdate(Map<String, Object> param);
	
	/**
	 * CK에디터 통합 Service Interface
	 * 
	 * **/
	
	//CK에디터 통합 목록
	public Map<String, Object> ckeditorList(Map<String, Object> param);
	//CK에디터 통합 등록
	public void ckeditorInsert(Map<String, Object> param);
	//CK에디터 통합 상세
	public Map<String, Object> ckeditorDetail(Map<String, Object> param);
	//CK에디터 통합 삭제
	public void ckeditorDelete(Map<String, Object> param); 
	//CK에디터 통합 수정
	public void ckeditorUpdate(Map<String, Object> param);
	
}
