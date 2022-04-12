package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface MemberMapper {
	
	//회원 가입
	public void memberInsert(Map<String, Object> param);
	
	//회원 수정
	public void memberUpdate(Map<String, Object> param);
	
	//회원 아이디 중복 체크
	public List memberIdCheck(Map<String, Object> param);
	
	//회원 상세
	public List memberContent(Map<String, Object> param);
		
	/*
	 * 로그인 기능
	 * param : loginId, loginPw
	 * return : int
	 */
	public Map<String, Object> login(Map<String, Object> param);
	
	/*
	 * 회원탈퇴
	 * param : name, email, password
	 * return : int
	 */
	public int memberWithdrawal(Map<String, Object> param);

	/*
	 * 회원탈퇴 체크
	 * param : name, email, password
	 * return : Map
	 */
	int memberWithdrawalCheck(Map<String, Object> param);
	
	
	//작가기본정보 등록
	public int authorInfoBaseInsert(Map<String, Object> param);
	
	//작가기본정보 수정
	public int authorInfoBaseUpdate(Map<String, Object> param);
	
	//작가기본정보 View
	public List authorBaseInfo(Map<String, Object> param);
	
	//작가기본정보 카운터
	public int authorBaseInfoCount(Map<String, Object> param);
	
	//작가학력정보 등록
	public int authorEduInfoInsert(Map<String, Object> param);
}
