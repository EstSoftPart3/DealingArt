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
	MemberDao MemberDao;
	
	//회원정보 입력
	@Override
	public void memberInsert(Map<String, Object> param){
		MemberDao.memberInsert(param);
	}
	
	/*
	 * 로그인 기능
	 * param : loginId, loginPw
	 * return : int
	 */
	public int login(Map<String, Object> param) {
		return MemberDao.login(param);
	}

}
