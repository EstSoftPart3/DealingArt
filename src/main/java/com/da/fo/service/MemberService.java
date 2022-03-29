package com.da.fo.service;

import java.util.Map;


public interface MemberService {
	
	//회원정보 등록
	public void memberInsert(Map<String, Object> param);
	
	/*
	 * 로그인 기능
	 * param : loginId, loginPw
	 * return : int
	 */
	Map<String, Object> login(Map<String, Object> param);
	
	/*
	 * 회원탈퇴
	 * param : name, email, password
	 * return : int
	 */
	int memberWithdrawal(Map<String, Object> param);
	
	/*
	 * 회원탈퇴 체크
	 * param : name, email, password
	 * return : Map
	 */
	int memberWithdrawalCheck(Map<String, Object> param);

}
