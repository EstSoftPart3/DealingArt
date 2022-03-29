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
import com.da.sample.service.CommonService;



@Repository
public class MemberDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	MemberMapper memberMapper;
	
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
						
			 memberContent.get(z).put("mbrId", mbrIdDecrypt);
			 memberContent.get(z).put("mbrPasswrd", mbrPasswrdDecrypt);
			 memberContent.get(z).put("mbrEmail", mbrEmailDecrypt);
			 memberContent.get(z).put("mbrCpNum", mbrCpNumDecrypt);
			 memberContent.get(z).put("mbrHomeAddr", mbrHomeAddrDecrypt);
		  }
		
		result.put("memberContent", memberContent);
		
		return result;
	}

}
