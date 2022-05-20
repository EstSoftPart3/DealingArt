package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface boardMapper {
	
	/**
	 * 공지사항,FAQ DAO
	 * 
	 * **/
	
	//게시판 목록
	public List boardList(Map<String, Object> param);
	//게시판 등록
	public void boardInsert(Map<String, Object> param);
	//게시판 상세
	public List boardDetail(Map<String, Object> param);
	//게시판 삭제
	public void boardDelete(Map<String, Object> param);
	//게시판 수정
	public void boardUpdate(Map<String, Object> param);
	
	/**
	 * 잡지 DAO
	 * 
	 * **/
	
	//잡지 목록
	public List magazineList(Map<String, Object> param);
	//잡지 등록
	public void magazineInsert(Map<String, Object> param);
	//잡지 상세
	public List magazineDetail(Map<String, Object> param);
	//잡지 삭제
	public void magazineDelete(Map<String, Object> param);
	//잡지 수정
	public void magazineUpdate(Map<String, Object> param);
	
}
