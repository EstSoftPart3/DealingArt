package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface MemberMapper {
	
	//회원 가입
	public void memberInsert(Map<String, Object> param);
	
	/*
	 * 로그인 기능
	 * param : loginId, loginPw
	 * return : int
	 */
	public int login(Map<String, Object> param);
	
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
	
	//회원 상세
	public List memberContent(Map<String, Object> param);

}
