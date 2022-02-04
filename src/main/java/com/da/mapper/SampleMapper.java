package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface SampleMapper {
	/*
	 * 로그인 기능
	 * param : memId, memPw
	 * return : int (해당 조건으로 조회된 회원의 row 갯수)
	 */
	public int sampleLogin(String memId, String memPw);
	
	/*
	 * 게시판 목록 검색 기능
	 * param : null
	 * return : List (전체 게시판의 목록)
	 */
	public List searchBoard();
	
	/*
	 * 회원가입 기능
	 * param : MemberEntity
	 * return : int (insert된 row의 수 true = 1 false = 0)
	 */
	public int insertMem(Object Object);
	
	/*
	 * 게시판 게시물 작성 기능
	 * param : Map(SampleBoard)
	 * return : int (insert된 row의 수 true = 1 false = 0)
	 */
	public int insertBoard(Object Object);
	
	/*
	 * 게시판 게시물 조회 기능
	 * param : Map(SampleBoard)
	 * return : Map(SampleBoard)
	 */
	public Map selectBoard(Object Object);
}
