package com.da.sample.service;

import java.util.List;

import com.da.model.MemberEntity;
import com.da.model.SampleBoard;

public interface  SampleService{
	/*
	 * 로그인 기능
	 * param : 화면에서 입력한 회원아이디, 회원패스워드
	 * return : 검색조건으로 조회된 row의 count
	 */
	int sampleLogin(String memId, String memPw);
	
	/*
	 * 게시물 목록 조회 기능
	 * param : null
	 * return : 전체 게시물이 조회된 List
	 */
	List<SampleBoard> searchBoard();
	
	/*
	 * 새로운 회원 정보 저장 기능
	 * param : 입력한 회원정보가 들어있는 VO
	 * return : 성공 여부를 숫자로 보낸다
	 */
	int insertMem(MemberEntity memberEntity);
	
	/*
	 * 작성한 게시물을 저장하는 기능
	 * param : 입력한 게시물 정보가 들어있는 VO
	 * return : 저장된 게시물 정보가 들어있는 VO
	 */
	SampleBoard insertBoard(SampleBoard sampleBoard);
	
	/*
	 * 게시물 목록중 하나의 게시물을 선택해서 조회하는 기능
	 * param : 목록 중 해당하는 row의 정보가 들어있는 VO
	 * return : 조회된 게시물의 정보가 들어있는 VO
	 */
	SampleBoard selectBoard(SampleBoard sampleBoard);
}
