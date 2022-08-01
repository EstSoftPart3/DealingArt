package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface boMemberMapper {
	
	//회원 목록
	public List memberList(Map<String, Object> param);
	
	//회원 상세
	public List memberContent(Map<String, Object> param);
	
	//회원 아이디.닉네임 중복 체크
	public List memberCheck(Map<String, Object> param);
	
	//회원 가입
	public void memberInsert(Map<String, Object> param);
	
	//회원 수정
	public int memberUpdate(Map<String, Object> param);
	
	//회원 비밀번호 초기화
	public int memberPasswdClear(Map<String, Object> param);
	
	//회원 목록
	public List artistApp(Map<String, Object> param);
	
	//탈퇴 회원 정보 상세 페이지
	public List wthdrMemContent(Map<String, Object> param);

}
