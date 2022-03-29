package com.da.bo.service;

import java.util.Map;

public interface artistMemberService {
	
	//작가회원정보	
	public Map<String, Object> artistMemberInfo(Map<String, Object> param);
	
	//작가회원정보 입력
	public int artistMemberInsert(Map<String, Object> param);			
		

}
