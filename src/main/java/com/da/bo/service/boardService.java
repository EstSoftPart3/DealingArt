package com.da.bo.service;

import java.util.Map;

public interface boardService {
	
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
}
