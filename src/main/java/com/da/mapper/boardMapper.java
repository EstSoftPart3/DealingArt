package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface boardMapper {
	
	/**
	 * 공지사항, FAQ Mapper
	 * 
	 * **/
	
	//게시판 목록
	public List boardList(Map<String, Object> param);
	//게시판 등록
	public void boardInsert(Map<String, Object> param);
	//게시판 상세
	public List boardDetail(Map<String, Object> param);
	//긴급 게시판 상세
	public List emBoardDetail(Map<String, Object> param);
	//게시판 삭제
	public void boardDelete(Map<String, Object> param);
	//게시판 수정
	public void boardUpdate(Map<String, Object> param);
	
	/**
	 * 메거진 Mapper
	 * 
	 * **/
	
	//메거진 목록
	public List magazineList(Map<String, Object> param);
	//메거진 등록
	public void magazineInsert(Map<String, Object> param);
	//메거진 상세
	public List magazineDetail(Map<String, Object> param);
	//메거진 삭제
	public void magazineDelete(Map<String, Object> param);
	//메거진 수정
	public void magazineUpdate(Map<String, Object> param);
	
	/**
	 * CK에디터 통합 Mapper
	 * 
	 * **/
	
	//CK에디터 통합 목록
	public List ckeditorList(Map<String, Object> param);
	//CK에디터 통합 등록
	public void ckeditorInsert(Map<String, Object> param);
	//CK에디터 통합 상세
	public List ckeditorDetail(Map<String, Object> param);
	//CK에디터 통합 삭제
	public void ckeditorDelete(Map<String, Object> param);
	//CK에디터 통합 수정
	public void ckeditorUpdate(Map<String, Object> param);
	
}
