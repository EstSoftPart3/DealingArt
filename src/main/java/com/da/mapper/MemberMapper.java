package com.da.mapper;

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

}
