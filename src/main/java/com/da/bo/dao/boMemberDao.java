package com.da.bo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.boMemberMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;

import com.da.util.CommonService;

@Repository
public class boMemberDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	boMemberMapper boMemberMapper;
	
	//회원정보 목록
	@SuppressWarnings("null")
	public Map<String, Object> memberList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		System.out.println("MEMBER_LIST_REQUEST = " + param);
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> memberList = boMemberMapper.memberList(param);
		
		 for(int z=0; z<memberList.size(); z++){
			 String mbrIdDecrypt = (String) memberList.get(z).get("mbrId");	
			 String mbrEmailDecrypt = (String) memberList.get(z).get("mbrEmail");	
			 String mbrCpNumDecrypt = (String) memberList.get(z).get("mbrCpNum");	
			 String mbrHomeAddrDecrypt = (String) memberList.get(z).get("mbrHomeAddr");	
			
			//아이디 복호화
			 mbrIdDecrypt = commonService.decrypt(mbrIdDecrypt);
			 //이메일 복호화
			 mbrEmailDecrypt = commonService.decrypt(mbrEmailDecrypt);
			 //휴대전화번호 복호화
			 mbrCpNumDecrypt = commonService.decrypt(mbrCpNumDecrypt);
			 if(mbrHomeAddrDecrypt != null && !mbrHomeAddrDecrypt.equals("")) {
				 //집주소 복호화
				 mbrHomeAddrDecrypt = commonService.decrypt(mbrHomeAddrDecrypt);
			 }
			 //회원구분
			 String mbrSocialSort = (String) memberList.get(z).get("mbrSocialSort");
			 
			 memberList.get(z).put("mbrSocialSort", mbrSocialSort);
			 memberList.get(z).put("mbrId", mbrIdDecrypt);
			 memberList.get(z).put("mbrEmail", mbrEmailDecrypt);
			 memberList.get(z).put("mbrCpNum", mbrCpNumDecrypt);
			 memberList.get(z).put("mbrHomeAddr", mbrHomeAddrDecrypt);
		  }
		
		result.put("memberList", memberList);
		
		return result;
	}
	
	//회원정보 상세
	public Map<String, Object> memberContent(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("MEMBER_CONTENT_REQUEST = " + param);
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> memberContent = boMemberMapper.memberContent(param);
		
		for(int z=0; z<memberContent.size(); z++){
		 	
			 String mbrIdDecrypt = (String) memberContent.get(z).get("mbrId");	
			 String mbrEmailDecrypt = (String) memberContent.get(z).get("mbrEmail");	
			 String mbrCpNumDecrypt = (String) memberContent.get(z).get("mbrCpNum");	
			 String mbrHomeAddrDecrypt = (String) memberContent.get(z).get("mbrHomeAddr");	
			
			 //아이디 복호화
			 mbrIdDecrypt = commonService.decrypt(mbrIdDecrypt);
			 //이메일 복호화
			 mbrEmailDecrypt = commonService.decrypt(mbrEmailDecrypt);
			 //휴대전화번호 복호화
			 mbrCpNumDecrypt = commonService.decrypt(mbrCpNumDecrypt);
			 if(mbrHomeAddrDecrypt != null && !mbrHomeAddrDecrypt.equals("")) {
				 //집주소 복호화
				 mbrHomeAddrDecrypt = commonService.decrypt(mbrHomeAddrDecrypt);
			 }
			 
			 String authSq = String.valueOf( memberContent.get(z).get("authSq"));
			 			
			 memberContent.get(z).put("authSq", authSq);
			 memberContent.get(z).put("mbrId", mbrIdDecrypt);
			 memberContent.get(z).put("mbrEmail", mbrEmailDecrypt);
			 memberContent.get(z).put("mbrCpNum", mbrCpNumDecrypt);
			 memberContent.get(z).put("mbrHomeAddr", mbrHomeAddrDecrypt);
		  }
		
		result.put("memberContent", memberContent);
		
		return result;
	}
	
	//회원정보 아이디.닉네임 중복 체크
	public Map<String, Object> memberCheck(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("MEMBER_CHECK_REQUEST = " + param);
		List memberCheck = boMemberMapper.memberCheck(param);
		
		result.put("memberCheck", memberCheck);
		
		return result;
	}
	
	//회원정보 입력
	public void memberInsert(Map<String, Object> param){
		
		System.out.println("MEMBER_INSERT_REQUEST = " + param);
		boMemberMapper.memberInsert(param);
		
	}
	
	//회원정보 수정
	public int memberUpdate(Map<String, Object> param){
		
		int updateState = -1;
		
		updateState =  boMemberMapper.memberUpdate(param);
		
		return updateState;
		
	}
	
	//회원 비밀번호 초기화
	public int memberPasswdClear(Map<String, Object> param){
		
		int updateState = -1;
		
		updateState =  boMemberMapper.memberPasswdClear(param);
		
		return updateState;
		
	}
	
	//작가신청 목록
	public Map<String, Object> artistAppList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
			
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> memberList = boMemberMapper.artistApp(param);
		
		 for(int z=0; z<memberList.size(); z++){
			 	
			
			//아이디 복호화
			 String mbrIdDecrypt = commonService.decrypt((String) memberList.get(z).get("mbrId"));
			 //비밀번호 복호화
			 String mbrPasswrdDecrypt = commonService.decrypt((String) memberList.get(z).get("mbrPasswrd"));
			 //이메일 복호화
			 String mbrEmailDecrypt = commonService.decrypt((String) memberList.get(z).get("mbrEmail"));
			 //휴대전화번호 복호화
			 String mbrCpNumDecrypt = commonService.decrypt((String) memberList.get(z).get("mbrCpNum"));
			 //집주소 복호화
			 String mbrHomeAddrDecrypt = commonService.decrypt((String) memberList.get(z).get("mbrHomeAddr"));
			 
			 //회원구분
			 String mbrSocialSort = (String) memberList.get(z).get("mbrSocialSort");
			 
			 memberList.get(z).put("mbrSocialSort", mbrSocialSort);
			 memberList.get(z).put("mbrId", mbrIdDecrypt);
			 memberList.get(z).put("mbrPasswrd", mbrPasswrdDecrypt);
			 memberList.get(z).put("mbrEmail", mbrEmailDecrypt);
			 memberList.get(z).put("mbrCpNum", mbrCpNumDecrypt);
			 memberList.get(z).put("mbrHomeAddr", mbrHomeAddrDecrypt);
		  }
		
		result.put("appList", memberList);
		
		return result;
	}

}
