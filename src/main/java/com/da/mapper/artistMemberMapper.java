package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface artistMemberMapper {
	
	//작가회원정보
	public List artistMemberInfo(Map<String, Object> param);
	
	
	//작가회원정보 입력
	public int artistMemberInsert(Map<String, Object> param);
	
	//작가회원정보 수정
	public int artistMemberUpdate(Map<String, Object> param);

	//작가회원정보 입력확인
	public int artistMemberInfoCount(Map<String, Object> param);
}
