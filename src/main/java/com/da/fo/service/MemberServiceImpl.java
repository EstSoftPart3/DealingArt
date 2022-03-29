package com.da.fo.service;

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
}
