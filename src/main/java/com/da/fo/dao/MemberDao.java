package com.da.fo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.da.mapper.MemberMapper;
import com.da.sample.service.CommonService;
import com.querydsl.jpa.impl.JPAQueryFactory;




@Repository
public class MemberDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	MemberMapper memberMapper;
	
	//회원정보 수정
	public void memberUpdate(Map<String, Object> param){
		
		System.out.println("FO_MEMBER_UPDATE_REQUEST = " + param);
		memberMapper.memberUpdate(param);
		
	}
	
	//회원정보 입력
	public void memberInsert(Map<String, Object> param){
		
		System.out.println("FO_MEMBER_INSERT_REQUEST = " + param);
		memberMapper.memberInsert(param);
		
	}
	
	/*
	 * 로그인 기능
	 * param : loginId, loginPw
	 * return : int
	 */
	public Map<String, Object> login(Map<String, Object> param) {
		return memberMapper.login(param);
	}
	
	/*
	 * 회원탈퇴
	 * param : name, email, password
	 * return : int
	 */
	public int memberWithdrawal(Map<String, Object> param) {
		return memberMapper.memberWithdrawal(param);
	}
	
	/*
	 * 회원탈퇴 체크
	 * param : name, email, password
	 * return : Map
	 */
	public int memberWithdrawalCheck(Map<String, Object> param){
		return memberMapper.memberWithdrawalCheck(param);
	}
	
	//회원정보 상세
	public Map<String, Object> memberContent(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("MEMBER_CONTENT_REQUEST = " + param);
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> memberContent = memberMapper.memberContent(param);
		
		for(int z=0; z<memberContent.size(); z++){
		 	
			 //아이디 복호화
			 String mbrIdDecrypt = commonService.decrypt((String) memberContent.get(z).get("mbrId"));
			 //비밀번호 복호화
			 String mbrPasswrdDecrypt = commonService.decrypt((String) memberContent.get(z).get("mbrPasswrd"));
			 //이메일 복호화
			 String mbrEmailDecrypt = commonService.decrypt((String) memberContent.get(z).get("mbrEmail"));
			 //휴대전화번호 복호화
			 String mbrCpNumDecrypt = commonService.decrypt((String) memberContent.get(z).get("mbrCpNum"));
			 //집주소 복호화
			 String mbrHomeAddrDecrypt = commonService.decrypt((String) memberContent.get(z).get("mbrHomeAddr"));
			 //이메일 이벤트 알림
			 String mbrEmlAlarm = (String) memberContent.get(z).get("mbrEmlAlarm");
			 //휴대폰 이벤트 알림
			 String mbrCpAlarm = (String) memberContent.get(z).get("mbrCpAlarm");
						
			 memberContent.get(z).put("mbrId", mbrIdDecrypt);
			 memberContent.get(z).put("mbrPasswrd", mbrPasswrdDecrypt);
			 memberContent.get(z).put("mbrEmail", mbrEmailDecrypt);
			 memberContent.get(z).put("mbrCpNum", mbrCpNumDecrypt);
			 memberContent.get(z).put("mbrHomeAddr", mbrHomeAddrDecrypt);
			 memberContent.get(z).put("mbrEmlAlarm", mbrEmlAlarm);
			 memberContent.get(z).put("mbrCpAlarm", mbrCpAlarm);
			 
		  }
		
		result.put("memberContent", memberContent);
		
		return result;
	}
	
	//회원정보 아이디.닉네임 중복 체크
	public Map<String, Object> memberIdCheck(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("MEMBER_CHECK_REQUEST = " + param);
		List memberIdCheck = memberMapper.memberIdCheck(param);
		
		result.put("memberIdCheck", memberIdCheck);
		
		return result;
	}
	
	//작가정보 등록
	public int authorInfoBaseSave(Map<String, Object> param){
		
		int saveState = -1;
		
		System.out.println("FO_AUTHOR_INFO_BASE_SAVE_REQUEST = " + param);
		
		
		int authorInfoBaseCount = memberMapper.authorBaseInfoCount(param);
		
		if(authorInfoBaseCount == 0) {
			saveState = memberMapper.authorInfoBaseInsert(param);
		} else {
			saveState = memberMapper.authorInfoBaseUpdate(param);
		}
				 
		return saveState;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> authorBaseInfoView(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		System.out.println("AUTHOR_BASE_INFO_VIEW = " + param);
		
		List<Map<String, Object>> baseInfo = memberMapper.authorBaseInfo(param);
		
		result.put("baseInfo", baseInfo);
				
		return result;
	}
	
	//작가학력정보 등록
	public int authorEduInfoSaveData(Map<String, Object> param){
		
		int saveState = -1;
		
		System.out.println("FO_AUTHOR_INFO_BASE_SAVE_REQUEST = " + param);
		
		saveState = memberMapper.authorEduInfoInsert(param);
			 
		return saveState;
	}

}
