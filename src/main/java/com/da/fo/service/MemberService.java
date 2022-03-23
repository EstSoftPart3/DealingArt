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
	int login(Map<String, Object> param);

}
