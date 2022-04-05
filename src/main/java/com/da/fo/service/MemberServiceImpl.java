package com.da.fo.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.da.fo.dao.MemberDao;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService  {
	
	@Autowired
	MemberDao memberDao;
	
	//회원정보 입력
	@Override
	public void memberInsert(Map<String, Object> param){
		memberDao.memberInsert(param);
	}
	
	//회원정보 입력
	@Override
	public void memberUpdate(Map<String, Object> param){
		memberDao.memberUpdate(param);
	}
	
	/*
	 * 로그인 기능
	 * param : loginId, loginPw
	 * return : int
	 */
	public Map<String, Object> login(Map<String, Object> param) {
		return memberDao.login(param);
	}

	/*
	 * 회원탈퇴
	 * param : name, email, password
	 * return : int
	 */
	public int memberWithdrawal(Map<String, Object> param) {
		return memberDao.memberWithdrawal(param);
	}
	
	/*
	 * 회원탈퇴 체크
	 * param : name, email, password
	 * return : Map
	 */
	public int memberWithdrawalCheck(Map<String, Object> param){
		return memberDao.memberWithdrawalCheck(param);
	}
	
	//회원정보 상세
	@Override
	public Map<String, Object> memberContent(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = memberDao.memberContent(param);
		
		return result;
	}
	
	//회원정보 아이디 중복 체크
	@Override
	public Map<String, Object> memberIdCheck(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = memberDao.memberIdCheck(param);
		
		return result;
	}
}
