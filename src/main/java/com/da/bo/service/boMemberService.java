package com.da.bo.service;

import java.util.Map;

public interface boMemberService {
	
	//회원정보 목록
	public Map<String, Object> memberList(Map<String, Object> param);
	
	//회원정보 상세	
	public Map<String, Object> memberContent(Map<String, Object> param);
	
	//회원정보 아이디.닉네임 조회
	public Map<String, Object> memberCheck(Map<String, Object> param);
	
	//회원정보 등록
	public void memberInsert(Map<String, Object> param);
	
	//회원정보 수정
	public int memberUpdate(Map<String, Object> param);
	
	//회원 비밀번호 초기화
	public int memberPasswdClear(Map<String, Object> param);
	
	//작가신청 목록
	public Map<String, Object> artistAppList(Map<String, Object> param);

	//탈퇴 회원 정보 상세 페이지
	public Map<String, Object> wthdrMemContent(Map<String, Object> param);
}
